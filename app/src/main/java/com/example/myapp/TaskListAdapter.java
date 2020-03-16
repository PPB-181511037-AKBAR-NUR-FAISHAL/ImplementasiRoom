package com.example.myapp;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {

    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final TextView TaskItemViewTask;
        private final TextView TaskItemViewDesc;
        private final TextView TaskItemViewDeadl;

        private TaskViewHolder(View itemView) {
            super(itemView);
            TaskItemViewTask = itemView.findViewById(R.id.textTask);
            TaskItemViewDesc = itemView.findViewById(R.id.textDesc);
            TaskItemViewDeadl = itemView.findViewById(R.id.textDeadl);

        }
    }

    private final LayoutInflater mInflater;
    private List<Task> mTasks; // Cached copy of Tasks

    TaskListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        if (mTasks != null) {
            Task current = mTasks.get(position);
            holder.TaskItemViewTask.setText(current.getTask());
            holder.TaskItemViewDesc.setText(current.getDesc());
            holder.TaskItemViewDeadl.setText(current.getDeadl());
        } else {
            // Covers the case of data not being ready yet.
            holder.TaskItemViewTask.setText("No Task");
            holder.TaskItemViewDesc.setText(" ");
            holder.TaskItemViewDeadl.setText(" ");
        }
    }

    void setTasks(List<Task> tasks) {
        mTasks = tasks;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mTasks has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mTasks != null)
            return mTasks.size();
        else return 0;
    }
}


