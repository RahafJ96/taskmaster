package com.example.taskmaster.DAO;

import androidx.room.*;

import com.example.taskmaster.Entity.EntityTask;

import java.util.List;

@Dao
public interface DAOTask {
    @Query("SELECT * FROM taskentity")
    List<EntityTask> getAll();

    @Query("SELECT * FROM taskentity WHERE tid IN (:taskIds)")
    List<EntityTask> loadAllByIds(int[] taskIds);

    @Insert
    public Long insert(EntityTask taskModel);

}