package com.example.taskmaster.Database;

import android.content.Context;
import androidx.room.*;
import com.example.taskmaster.DAO.DAOTask;
import com.example.taskmaster.Entity.EntityTask;


@Database(entities = {EntityTask.class}, version = 1,exportSchema = true)
public abstract class DatabaseTask extends RoomDatabase {
    public abstract DAOTask taskDAO();
    private static DatabaseTask appDatabase;

    public DatabaseTask() {
    }
    public static DatabaseTask getInstance(Context context){
        if(appDatabase==null){
            appDatabase=Room.databaseBuilder(context,DatabaseTask.class,"tasks").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
