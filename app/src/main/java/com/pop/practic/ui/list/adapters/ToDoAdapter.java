package com.pop.practic.ui.list.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pop.practic.R;
import com.pop.practic.repository.Repository;
import com.pop.practic.repository.room.todolist.ToDoRef;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private static List<ToDoRef> todo;
    static Context context;
    Repository repository;
    private TextView textView;

    public ToDoAdapter(Repository repository) {
        todo = repository.getToDoRefDB().todorefDAO().getAll();
        this.repository = repository;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView getTextView;
        private final TextView textView;
        private final Button button;
        private Repository repository;

        public ViewHolder(View view) {
            super(view);
            button = view.findViewById(R.id.item_row_note_button);
            getTextView = view.findViewById(R.id.item_row_note_edit_text);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }

        public Button getButton() {
            return button;
        }

        public TextView getGetTextView() {
            return getTextView;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View todo_fr = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_todolist_fragment, viewGroup, false);

        View todo_sh_fr = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.shape_todolist_fragment, viewGroup, false);

        return new ViewHolder(todo_sh_fr);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getGetTextView().setText(todo.get(position).title);
        Log.i("HELP", "ToDoAdapter: " + todo.get(position).title);

        if (position == todo.size()) {
            viewHolder.getTextView().setVisibility(View.INVISIBLE);
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getButton().setOnClickListener(view -> {
                ToDoRef todoref = new ToDoRef();
                todoref.title = (String) viewHolder.getTextView().getText().toString();
                repository.getToDoRefDB().todorefDAO().insertAll(todoref);
                repository.getToDoRefDB().todorefDAO().updateUsers();
            });
        }

    }

    @Override
    public int getItemCount() {
        return todo.size();
    }
}