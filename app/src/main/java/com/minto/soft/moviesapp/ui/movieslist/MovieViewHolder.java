package com.minto.soft.moviesapp.ui.movieslist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minto.soft.moviesapp.data.local.model.Movie;
import com.minto.soft.moviesapp.databinding.ItemMovieBinding;
import com.minto.soft.moviesapp.ui.moviedetails.DetailsActivity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ItemMovieBinding binding;

    public MovieViewHolder(@NonNull ItemMovieBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bindTo(final Movie movie) {
        binding.setMovie(movie);
        // movie click event
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_ID, movie.getId());
                view.getContext().startActivity(intent);
            }
        });

        binding.executePendingBindings();
    }

    public static MovieViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemMovieBinding binding =
                ItemMovieBinding.inflate(layoutInflater, parent, false);
        return new MovieViewHolder(binding);
    }
}
