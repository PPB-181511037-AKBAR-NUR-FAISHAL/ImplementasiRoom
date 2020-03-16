package com.example.myapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Query("SELECT * from task_table ORDER BY mTask ASC")
    LiveData<List<Task>> getAlphabetizedTasks();



    @Query("DELETE FROM task_table")
    void deleteAll();
}
