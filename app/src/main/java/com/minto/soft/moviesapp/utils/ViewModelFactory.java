package com.minto.soft.moviesapp.utils;

import com.minto.soft.moviesapp.data.MovieRepository;
import com.minto.soft.moviesapp.ui.moviedetails.MovieDetailsViewModel;
import com.minto.soft.moviesapp.ui.movieslist.popular.PopularMoviesViewModel;
import com.minto.soft.moviesapp.ui.movieslist.favorites.FavoritesViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final MovieRepository repository;

    public static ViewModelFactory getInstance(MovieRepository repository) {
        return new ViewModelFactory(repository);
    }

    private ViewModelFactory(MovieRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PopularMoviesViewModel.class)) {
            //noinspection unchecked
            return (T) new PopularMoviesViewModel(repository);
        } else if (modelClass.isAssignableFrom(FavoritesViewModel.class)) {
            //noinspection unchecked
            return (T) new FavoritesViewModel(repository);
        } else if (modelClass.isAssignableFrom(MovieDetailsViewModel.class)) {
            //noinspection unchecked
            return (T) new MovieDetailsViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
