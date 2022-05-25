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
import com.pop.practic.repository.room.movies.Movies;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pop.practic.R;
import com.pop.practic.repository.Repository;
import com.pop.practic.ui.list.adapters.NotesAdapter;


import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {
    private final Repository repository;
    Context context;
    List<Movies> moviesList;

    public MoviesAdapter(Repository repository) {
        moviesList = repository.getMoviesDB().moviesDAO().getAll();
        this.repository=repository;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View movies_full = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row_movies_fragment, viewGroup, false);
        return new MoviesViewHolder(movies_full);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder viewHolder, int position) {
        viewHolder.getEditTextView().setText(moviesList.get(position).title);
        viewHolder.getButton().setVisibility(View.INVISIBLE);
        Log.i("HELP", "ToDoAdapter: " + moviesList.get(position).title);

        if (position + 1 == moviesList.size()) {
            viewHolder.getButton().setText("+");
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getEditTextView().setEnabled(true);
            viewHolder.getButton().setOnClickListener(view -> {
                if (viewHolder.getEditTextView().getText().toString().equals("")) {
                    Toast.makeText(viewHolder.getEditTextView().getContext(), "Пустое поле!", Toast.LENGTH_SHORT).show();
                } else {
                    Movies movies = moviesList.get(position);
                    movies.title = (String) viewHolder.getEditTextView().getText().toString();
                    repository.getMoviesDB().moviesDAO().updateUsers(movies);
                    movies.title = "";
                    movies = new Movies();
                    repository.getMoviesDB().moviesDAO().insertAll(movies);
                    upDateAdapter(moviesList);
                    Toast.makeText(viewHolder.getEditTextView().getContext(), "Сохранено!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            viewHolder.getButton().setText("-");
            viewHolder.getButton().setVisibility(View.VISIBLE);
            viewHolder.getEditTextView().setEnabled(false);
            viewHolder.getButton().setOnClickListener(view -> {
                repository.getMoviesDB().moviesDAO().deleteNote(moviesList.get(position));
                upDateAdapter(moviesList);
                notifyItemChanged(position);
            });
        }

    }

    private void upDateAdapter(List<Movies> moviesList) {
        moviesList.clear();
        moviesList.addAll(repository.getMoviesDB().moviesDAO().getAll());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return moviesList.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder{
        EditText editTextView;
        Button button;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextView = itemView.findViewById(R.id.item_row_movies_text);
            button = itemView.findViewById(R.id.item_row_movies_button);
        }
        public Button getButton() {
            return button;
        }
        public TextView getEditTextView() { return editTextView; }
    }


}
