package com.pop.practic.ui.list.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pop.practic.R;
import com.pop.practic.repository.Repository;
import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.repository.room.todolist.ToDoRef;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private static List<Note> notes;
    static Context context;
    Repository repository;

    public NotesAdapter(Repository repository) {
        notes = repository.getNoteDB().noteDAO().getAll();
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
            textView = view.findViewById(R.id.textViewnote);
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

    @NonNull
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {


        View note_fr = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_note_full, viewGroup, false);

        return new ViewHolder(note_fr);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.getGetTextView().setText(notes.get(position).title);
        viewHolder.getButton().setVisibility(View.INVISIBLE);
        viewHolder.getTextView().setText(String.valueOf(position + 1));
        Log.i("HELP", "NoteAdapter: " + notes.get(position).title);

        if (position + 1 == notes.size()) {
            viewHolder.getButton().setText("+");
            viewHolder.getTextView().setVisibility(View.INVISIBLE);
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getGetTextView().setEnabled(true);
            viewHolder.getButton().setOnClickListener(view -> {
                if (viewHolder.getGetTextView().getText().toString().equals("")) {
                    Toast.makeText(viewHolder.getGetTextView().getContext(), "Пустое поле!", Toast.LENGTH_SHORT).show();
                } else {
                    viewHolder.getTextView().setVisibility(View.INVISIBLE);
                    Note note = notes.get(position);
                    note.title = (String) viewHolder.getGetTextView().getText().toString();

                    repository.getNoteDB().noteDAO().updateUsers(note);
                    note = new Note();
                    note.title = "";
                    repository.getNoteDB().noteDAO().insertAll(note);
                    updateAdapter(notes);
                    Toast.makeText(viewHolder.getGetTextView().getContext(), "Сохранено!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            viewHolder.getButton().setText("-");
            viewHolder.getTextView().setText(String.valueOf(position + 1));
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getGetTextView().setEnabled(false);
            viewHolder.getButton().setOnClickListener(view -> {
                repository.getNoteDB().noteDAO().deleteNote(notes.get(position));
                updateAdapter(notes);
                notifyItemChanged(position);
            });
        }

    }

    public void updateAdapter(List<Note> newList) {
        notes.clear();
        notes.addAll(repository.getNoteDB().noteDAO().getAll());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}