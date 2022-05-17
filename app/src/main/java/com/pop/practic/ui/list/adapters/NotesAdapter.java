package com.pop.practic.ui.list.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pop.practic.R;
import com.pop.practic.repository.Repository;
import com.pop.practic.repository.room.notes.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Note> notes;
    static Context context;

    Repository repository;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final Button button;
        public ViewHolder(View view) {
            super(view);
            button  = view.findViewById(R.id.item_row_note_button);
            textView = view.findViewById(R.id.item_row_note_edit_text);
        }

        public TextView getTextView() {
            return textView;
        }
        public Button getButton() {
            return button;
        }
    }

    public NotesAdapter(Repository repository) {
        notes = repository.getNoteDB().noteDAO().getAll();
        this.repository=repository;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View note_new = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_note_new, viewGroup, false);

        View note_full = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_note_full, viewGroup, false);

        return new ViewHolder(note_full);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextView().setText(notes.get(position).title);
        if (position == notes.size()+1) {
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getButton().setOnClickListener(view -> {
                Note note = new Note();
                note.title = (String) viewHolder.getTextView().getText();
                repository.getNoteDB().noteDAO().insertAll(note);
                repository.getNoteDB().noteDAO().updateUsers();
            });
        }
    }

    @Override
    public int getItemCount() {
        return notes.size()+1;
    }
}
