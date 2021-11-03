package com.example.taskmaster.Entity;

import androidx.room.*;

@Entity
public class EntityTask {
    @PrimaryKey(autoGenerate = true)
    public int tid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "body")
    public String body;

    @ColumnInfo(name = "status")
    public String status;

    public EntityTask(String title, String body, String status) {
        this.title = title;
        this.body = body;
        this.status = status;
    }
}
