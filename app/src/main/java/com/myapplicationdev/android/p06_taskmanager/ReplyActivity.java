package com.myapplicationdev.android.p06_taskmanager;

import android.content.Intent;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class ReplyActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        DBHelper db = new DBHelper(this);

        CharSequence reply = null;
        Intent intent = getIntent();
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null){
            reply = remoteInput.getCharSequence("status");
        }


        if(reply != null){
            if (reply.toString().equalsIgnoreCase("Completed")) {
                Task task = (Task)intent.getSerializableExtra("task");
                db.deleteNote(task.getId());

            }
        }
    }
}
