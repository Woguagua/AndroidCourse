package com.bytedance.todolist.activity;

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
import android.content.Intent;
import android.util.Log;
import android.widget.ImageButton;


import com.bytedance.todolist.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;
import android.os.Handler;

public class TodoListActivity extends AppCompatActivity {

    private TodoListAdapter mAdapter;
    private FloatingActionButton mFab;
    private boolean run = false;
    private final Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_list_activity_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TodoListAdapter();
        recyclerView.setAdapter(mAdapter);
        Log.i("Debug","000");
        mFab = findViewById(R.id.fab);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO

                Log.i("Debug","111");
                startActivityForResult(new Intent(TodoListActivity.this, AddActivity.class), 1);
                Log.i("Debug","222");
//                dao.addTodo(new TodoListEntity(, new Date(System.currentTimeMillis())));
            }
        });

//        mFab.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                new Thread() {
//                    @Override
//                    public void run() {
//                        TodoListDao dao = TodoListDatabase.inst(TodoListActivity.this).todoListDao();
//                        dao.deleteAll();
//                        for (int i = 0; i < 20; ++i) {
//                            dao.addTodo(new TodoListEntity("This is " + i + " item", new Date(System.currentTimeMillis())));
//                        }
//                        Snackbar.make(mFab, R.string.hint_insert_complete, Snackbar.LENGTH_SHORT).show();
//                    }
//                }.start();
//                return true;
//            }
//        });
        loadFromDatabase();

        run = true;
        handler.postDelayed(task, 500);

    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (run) {
                loadFromDatabase();
                handler.postDelayed(this, 1000);
            }
        }
    };

    private void loadFromDatabase() {
        new Thread() {
            @Override
            public void run() {
                TodoListDao dao = TodoListDatabase.inst(TodoListActivity.this).todoListDao();
                final List<TodoListEntity> entityList = dao.loadAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setData(entityList);
                    }
                });
            }
        }.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){

            final String result = data.getExtras().getString("result");//得到新Activity 关闭后返回的数据
//            dao.addTodo(new TodoListEntity(result, new Date(System.currentTimeMillis())));
            Log.i("Debug","333");
            new Thread() {
                    @Override
                    public void run() {
                        TodoListDao dao = TodoListDatabase.inst(TodoListActivity.this).todoListDao();
//                        dao.deleteAll();
                        dao.addTodo(new TodoListEntity(result, new Date(System.currentTimeMillis())));
                        Snackbar.make(mFab, R.string.hint_insert_complete, Snackbar.LENGTH_SHORT).show();
                        loadFromDatabase();
                    }

                }.start();

//            loadFromDatabase();
        }


    }
}
