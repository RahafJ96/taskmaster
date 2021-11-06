package com.example.taskmaster.DAO;

import androidx.room.*;

import com.example.taskmaster.Entity.TaskEntity;
import com.example.taskmaster.Task;

import java.util.List;

@Dao
public interface TaskDAO {
    @Query("SELECT * FROM taskentity")
    List<TaskEntity> getAll();

    @Query("SELECT * FROM taskentity WHERE tid IN (:taskIds)")
    List<TaskEntity> loadAllByIds(int[] taskIds);

    @Insert
    public Long insert(TaskEntity taskModel);

}