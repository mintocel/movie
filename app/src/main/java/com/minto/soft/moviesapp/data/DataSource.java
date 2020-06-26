package com.minto.soft.moviesapp.data;

import com.minto.soft.moviesapp.data.local.model.Movie;
import com.minto.soft.moviesapp.data.local.model.MovieDetails;
import com.minto.soft.moviesapp.data.local.model.RepoMoviesResult;
import com.minto.soft.moviesapp.data.local.model.Resource;
import com.minto.soft.moviesapp.ui.movieslist.MoviesFilterType;

import java.util.List;

import androidx.lifecycle.LiveData;


public interface DataSource {

    LiveData<Resource<MovieDetails>> loadMovie(long movieId);

    RepoMoviesResult loadMoviesFilteredBy(MoviesFilterType sortBy);

    LiveData<List<Movie>> getAllFavoriteMovies();

    void favoriteMovie(Movie movie);

    void unfavoriteMovie(Movie movie);
}
