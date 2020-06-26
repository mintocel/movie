package com.minto.soft.moviesapp.data.local;

import android.content.Context;

import com.minto.soft.moviesapp.data.local.dao.CastsDao;
import com.minto.soft.moviesapp.data.local.dao.MoviesDao;
import com.minto.soft.moviesapp.data.local.dao.ReviewsDao;
import com.minto.soft.moviesapp.data.local.dao.TrailersDao;
import com.minto.soft.moviesapp.data.local.model.Cast;
import com.minto.soft.moviesapp.data.local.model.Converters;
import com.minto.soft.moviesapp.data.local.model.Movie;
import com.minto.soft.moviesapp.data.local.model.Review;
import com.minto.soft.moviesapp.data.local.model.Trailer;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(
        entities = {Movie.class, Trailer.class, Cast.class, Review.class},
        version = 1,
        exportSchema = false)
@TypeConverters(Converters.class)
public abstract class MoviesDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "Movies.db";

    private static MoviesDatabase INSTANCE;

    private static final Object sLock = new Object();

    public abstract MoviesDao moviesDao();

    public abstract TrailersDao trailersDao();

    public abstract CastsDao castsDao();

    public abstract ReviewsDao reviewsDao();

    public static MoviesDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context);
            }
            return INSTANCE;
        }
    }

    private static MoviesDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                MoviesDatabase.class,
                DATABASE_NAME).build();
    }
}
