package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey
    @NonNull
    private String mTask;
    private String mDesc;
    private String mDeadl;

    public Task(@NonNull String task, String desc, String deadl) {
        this.mTask = task;
        this.mDesc = desc;
        this.mDeadl = deadl;
    }

    public String getTask(){return this.mTask;}
    public String getDesc(){return this.mDesc;}
    public String getDeadl(){return this.mDeadl;}
}
