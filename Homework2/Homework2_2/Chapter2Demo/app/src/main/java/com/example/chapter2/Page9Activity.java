package com.example.chapter2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Page9Activity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page9);
        Log.i(TAG, "Page1 onCreate");
        initView();
    }

    private void initView() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Page1 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Page1 onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Page1 onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Page1 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Page1 onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Page1 onDestroy");
    }

}