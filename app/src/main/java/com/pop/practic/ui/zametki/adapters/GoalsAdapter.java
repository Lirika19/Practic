package com.pop.practic.ui.zametki.adapters;

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
import com.pop.practic.repository.room.goals.Goals;
import com.pop.practic.repository.room.notes.Note;
import com.pop.practic.ui.list.adapters.NotesAdapter;


import java.util.List;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.ViewHolder> {
    private List<Goals> notes;
    static Context context;
    Repository repository;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView getTextView;
        private final TextView textView;
        private final Button button;
        public ViewHolder(View view) {
            super(view);
            button  = view.findViewById(R.id.item_row_goals_button);
            getTextView = view.findViewById(R.id.item_row_goals_edit_text);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
        public Button getButton() {
            return button;
        }
        public TextView getGetTextView() { return getTextView; }
    }

    public GoalsAdapter(Repository repository) {
        List<Goals> goals = repository.getGoalsDB().goalsDAO().getAll();
        this.repository=repository;

    }

    @Override
    public GoalsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        
        View goalds_new = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_goals_new, viewGroup, false);

        View goalds_full = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_goals_full, viewGroup, false);

        return new GoalsAdapter(goals_full);
    }

    @Override
    public void onBindViewHolder(GoalsAdapter.ViewHolder viewHolder, final int position) {

        viewHolder.getGetTextView().setText(goals.get(position).title);
        Log.i("LOX", "NotesAdapter: "+ goals.get(position).title);
        if (position == goals.size()) {
            viewHolder.getTextView().setVisibility(View.INVISIBLE);
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getButton().setOnClickListener(view -> {
                Goals goals = new Goals();
                goals.title = (String) viewHolder.getTextView().getText().toString();
                repository.getGoalsDB().goalsDAO().insertAll(goals);
                repository.getGoalsDB().goalsDAO().updateUsers();
            });
        }

    }

    @Override
    public int getItemCount() {
        return goalds.size();
    }
}
