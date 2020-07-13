package com.bytedance.todolist.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import android.content.Intent;
import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.bytedance.todolist.R;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;
import android.os.Bundle;

import com.bytedance.todolist.database.TodoListDao;
import com.bytedance.todolist.database.TodoListDatabase;
import com.bytedance.todolist.database.TodoListEntity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.bytedance.todolist.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;

public class AddActivity extends AppCompatActivity {
    private EditText editText;
    private Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Take a note");


        editText = findViewById(R.id.edit_text);
        editText.setFocusable(true);
        editText.requestFocus();

        addBtn = findViewById(R.id.btn_add);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence content = editText.getText();
                if (TextUtils.isEmpty(content)) {
                    Toast.makeText(AddActivity.this,
                            "Nothing to add", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Toast.makeText(AddActivity.this,
                            "Note added", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent();
//                    Intent.putExtra("result", editText.getText().toString());
                    Intent intent = new Intent();
                    intent.putExtra("result", editText.getText().toString());
                    AddActivity.this.setResult(RESULT_OK, intent);
                }

                AddActivity.this.finish();
//                finish();
            }
        });
    }



}
