package com.minto.soft.moviesapp.utils;

import android.content.Context;

import com.minto.soft.moviesapp.data.MovieRepository;
import com.minto.soft.moviesapp.data.local.MoviesDatabase;
import com.minto.soft.moviesapp.data.local.MoviesLocalDataSource;
import com.minto.soft.moviesapp.data.remote.MoviesRemoteDataSource;
import com.minto.soft.moviesapp.data.remote.api.ApiClient;
import com.minto.soft.moviesapp.data.remote.api.MovieService;


public class Injection {

    /**
     * Creates an instance of MoviesRemoteDataSource
     */
    public static MoviesRemoteDataSource provideMoviesRemoteDataSource() {
        MovieService apiService = ApiClient.getInstance();
        AppExecutors executors = AppExecutors.getInstance();
        return MoviesRemoteDataSource.getInstance(apiService, executors);
    }

    /**
     * Creates an instance of MoviesRemoteDataSource
     */
    public static MoviesLocalDataSource provideMoviesLocalDataSource(Context context) {
        MoviesDatabase database = MoviesDatabase.getInstance(context.getApplicationContext());
        return MoviesLocalDataSource.getInstance(database);
    }

    /**
     * Creates an instance of MovieRepository
     */
    public static MovieRepository provideMovieRepository(Context context) {
        MoviesRemoteDataSource remoteDataSource = provideMoviesRemoteDataSource();
        MoviesLocalDataSource localDataSource = provideMoviesLocalDataSource(context);
        AppExecutors executors = AppExecutors.getInstance();
        return MovieRepository.getInstance(
                localDataSource,
                remoteDataSource,
                executors);
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        MovieRepository repository = provideMovieRepository(context);
        return ViewModelFactory.getInstance(repository);
    }
}
