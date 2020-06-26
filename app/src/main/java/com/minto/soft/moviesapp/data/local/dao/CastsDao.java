package com.minto.soft.moviesapp.data.local.dao;

import com.minto.soft.moviesapp.data.local.model.Cast;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;


@Dao
public interface CastsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllCasts(List<Cast> castList);

}
