package com.pop.practic.ui.zametki.adapters;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pop.practic.R;
import com.pop.practic.repository.Repository;
import com.pop.practic.repository.room.goals.Goals;


import java.util.List;

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.ViewHolder> {
    private List<Goals> notes;
    static Context context;
    Repository repository;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final Button button;
        public ViewHolder(View view) {
            super(view);
            button  = view.findViewById(R.id.item_row_goalds_button);
        }
        }
}
