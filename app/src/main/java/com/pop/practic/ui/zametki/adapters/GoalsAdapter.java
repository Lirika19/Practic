package com.pop.practic.ui.zametki.adapters;

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
import com.pop.practic.repository.room.goals.Goals;


import java.util.List;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalsViewHolder> {
    private final Repository repository;
    Context context;
    List<Goals> goalsList;

    public GoalsAdapter(Repository repository) {
        goalsList = repository.getGoalsDB().goalsDAO().getAll();
        this.repository=repository;
    }

    @NonNull
    @Override
    public GoalsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View goals_full = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_goals_fragment, viewGroup, false);
        return new GoalsViewHolder(goals_full);    }


    @Override
    public void onBindViewHolder(GoalsViewHolder viewHolder, int position) {
        viewHolder.getEditTextView().setText(goalsList.get(position).title);
        viewHolder.getButton().setVisibility(View.INVISIBLE);
        Log.i("HELP", "ToDoAdapter: " + goalsList.get(position).title);

        if (position + 1 == goalsList.size()) {
            viewHolder.getButton().setText("+");
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getEditTextView().setEnabled(true);
            viewHolder.getButton().setOnClickListener(view -> {
                if (viewHolder.getEditTextView().getText().toString().equals("")) {
                    Toast.makeText(viewHolder.getEditTextView().getContext(), "Пустое поле!", Toast.LENGTH_SHORT).show();
                } else {
                    Goals goal = goalsList.get(position);
                    goal.title = (String) viewHolder.getEditTextView().getText().toString();
                    repository.getGoalsDB().goalsDAO().updateUsers(goal);
                    goal.title = "";
                    goal = new Goals();
                    repository.getGoalsDB().goalsDAO().insertAll(goal);
                    updateAdapter(goalsList);
                    Toast.makeText(viewHolder.getEditTextView().getContext(), "Сохранено!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            viewHolder.getButton().setText("-");
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getEditTextView().setEnabled(false);
            viewHolder.getButton().setOnClickListener(view -> {
                repository.getGoalsDB().goalsDAO().deleteNote(goalsList.get(position));
                updateAdapter(goalsList);
                notifyItemChanged(position);
            });
        }

    }

    private void updateAdapter(List<Goals> goalsList) {
        goalsList.clear();
        goalsList.addAll(repository.getGoalsDB().goalsDAO().getAll());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return goalsList.size();
    }

    public class GoalsViewHolder extends RecyclerView.ViewHolder{
        EditText editTextView;
        Button button;

        public GoalsViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextView = itemView.findViewById(R.id.item_row_goals_edit_text);
            button = itemView.findViewById(R.id.item_row_goals_button);
        }
        public Button getButton() {
            return button;
        }
        public TextView getEditTextView() { return editTextView; }
    }


}
