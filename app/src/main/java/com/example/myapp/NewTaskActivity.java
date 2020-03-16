package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity for entering a Task.
 */

public class NewTaskActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.task.REPLY";
    public static final String EXTRA_REPLYDESC = "com.example.android.desc.REPLY";
    public static final String EXTRA_REPLYDEADL = "com.example.android.deadl.REPLY";

    private EditText mEditTaskViewTask;
    private EditText mEditTaskViewDesc;
    private EditText mEditTaskViewDeadl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        mEditTaskViewTask = findViewById(R.id.edit_task);
        mEditTaskViewDesc = findViewById(R.id.edit_desc);
        mEditTaskViewDeadl = findViewById(R.id.edit_deadl);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditTaskViewTask.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String task = mEditTaskViewTask.getText().toString();
                    String desc = mEditTaskViewDesc.getText().toString();
                    String deadl = mEditTaskViewDeadl.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, task);
                    replyIntent.putExtra(EXTRA_REPLYDESC, desc);
                    replyIntent.putExtra(EXTRA_REPLYDEADL, deadl);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}