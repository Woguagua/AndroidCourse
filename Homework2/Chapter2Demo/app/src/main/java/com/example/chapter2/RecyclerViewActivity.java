package com.example.chapter2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chapter2.recycler.LinearItemDecoration;
import com.example.chapter2.recycler.MyAdapter;
import com.example.chapter2.recycler.TestData;
import com.example.chapter2.recycler.TestDataSet;
//import com.example.chapter2.recycler.MyAdapter2;
//import com.example.chapter2.recycler.TestData2;
//import com.example.chapter2.recycler.TestDataSet2;



public class RecyclerViewActivity extends AppCompatActivity implements MyAdapter.IOnItemClickListener {

    private static final String TAG = "TAG";

    private RecyclerView recyclerView;
//    private RecyclerView recyclerView2;
    private MyAdapter mAdapter;
//    private MyAdapter2 mAdapter2;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        Log.i(TAG, "RecyclerViewActivity onCreate");
        initView();
    }

    private void initView() {

        recyclerView = findViewById(R.id.recycler);
//        recyclerView2 = findViewById(R.id.recycler2);

        recyclerView.setHasFixedSize(true);
//        recyclerView2.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
//        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView2.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(TestDataSet.getData());
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);

//        mAdapter2 = new MyAdapter2(TestDataSet2.getData());
//        mAdapter2.setOnItemClickListener(this);
//        recyclerView2.setAdapter(mAdapter2);

        LinearItemDecoration itemDecoration = new LinearItemDecoration(Color.BLUE);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        DefaultItemAnimator animator = new DefaultItemAnimator();
//        animator.setAddDuration(3000);
//        recyclerView.setItemAnimator(animator);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "RecyclerViewActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "RecyclerViewActivity onResume");
    }


    @Override
    public void onItemCLick(int position, TestData data) {
//        Toast.makeText(RecyclerViewActivity.this, "点击了第" + position + "条", Toast.LENGTH_SHORT).show();
//        mAdapter.addData(position + 1, new TestData("新增头条", "0w"));
        switch (position) {
            case 0:
                Intent intent = new Intent(this, Page1Activity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(this, Page2Activity.class);
                startActivity(intent2);
                break;
            case 2:
                Intent intent3 = new Intent(this, Page3Activity.class);
                startActivity(intent3);
                break;
            case 3:
                Intent intent4 = new Intent(this, Page4Activity.class);
                startActivity(intent4);
                break;
            case 4:
                Intent intent5 = new Intent(this, Page5Activity.class);
                startActivity(intent5);
                break;
            case 5:
                Intent intent6 = new Intent(this, Page6Activity.class);
                startActivity(intent6);
                break;
            case 6:
                Intent intent7 = new Intent(this, Page7Activity.class);
                startActivity(intent7);
                break;
            case 7:
                Intent intent8 = new Intent(this, Page8Activity.class);
                startActivity(intent8);
                break;
            case 8:
                Intent intent9 = new Intent(this, Page9Activity.class);
                startActivity(intent9);
                break;
            case 9:
                Intent intent10 = new Intent(this, Page10Activity.class);
                startActivity(intent10);
                break;
            case 10:
                Intent intent11 = new Intent(this, Page11Activity.class);
                startActivity(intent11);
                break;
//            case 3:
//                Intent implicitIntent = new Intent();
////               implicitIntent.setAction("layout.activity");
//                implicitIntent.setAction(Intent.ACTION_DIAL);
//                startActivity(implicitIntent);
//                break;
//            case 4:
//                Intent intent4 = new Intent(this, UIActivity.class);
//                startActivity(intent4);
//                break;
//            case 5:
//                Intent intent5 = new Intent(this, RecyclerViewActivity.class);
//                startActivity(intent5);
//                break;
        }
    }

    @Override
    public void onItemLongCLick(int position, TestData data) {
        Toast.makeText(RecyclerViewActivity.this, "长按了第" + position + "条", Toast.LENGTH_SHORT).show();
        mAdapter.removeData(position);
    }
}