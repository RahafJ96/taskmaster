package com.example.taskmaster.Database;
import android.content.Context;

        import androidx.room.*;

        import com.example.taskmaster.DAO.TaskDAO;
        import com.example.taskmaster.Entity.TaskEntity;

@Database(entities = {TaskEntity.class}, version = 1,exportSchema = true)
public abstract class TaskDatabase extends RoomDatabase {
    public abstract TaskDAO taskDAO();
    private static TaskDatabase appDatabase;

    public TaskDatabase() {
    }
    public static TaskDatabase getInstance(Context context){
        if(appDatabase==null){
            appDatabase=Room.databaseBuilder(context,TaskDatabase.class,"tasks").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}