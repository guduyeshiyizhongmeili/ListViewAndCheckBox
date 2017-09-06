package com.baway.listviewandcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 全选
     */
    private Button mBtAll;
    /**
     * 反选
     */
    private Button mBtReverse;
    /**
     * 取消选择
     */
    private Button mBtCancle;
    private ListView mLv;
    private List<Bean> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i = 0; i < 50; i++) {
            Bean bean = new Bean(false, "item" + i);
            list.add(bean);
        }
        adapter = new MyAdapter(list, this);
        mLv.setAdapter(adapter);
    }

    private void initView() {
        mBtAll = (Button) findViewById(R.id.bt_all);
        mBtAll.setOnClickListener(this);
        mBtReverse = (Button) findViewById(R.id.bt_reverse);
        mBtReverse.setOnClickListener(this);
        mBtCancle = (Button) findViewById(R.id.bt_cancle);
        mBtCancle.setOnClickListener(this);
        mLv = (ListView) findViewById(R.id.lv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_all:
                //全选
                adapter.all();
                break;
            case R.id.bt_reverse:
                adapter.reverse();
                break;
            case R.id.bt_cancle:
                adapter.cancel();
                break;
        }
    }
}
