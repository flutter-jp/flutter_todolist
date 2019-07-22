package com.example.orc_demo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity  {

    public abstract int getLayoutId();

    public abstract void initViews();

    public abstract void initListener();

    public abstract void initData();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
        initData();
        initListener();
    }

    /**
     * 跳转Activity
     *
     * @param cls 要跳转的Activity
     */
    public void nextActivity(Class cls) {
        nextActivity(cls, null);
    }

    /**
     * 带数据包的跳转
     *
     * @param cls 要跳转的Activity
     * @param bundle 数据包
     */
    public void nextActivity(Class cls, Bundle bundle) {
        Intent i = new Intent(this, cls);
        if (bundle != null) {
            i.putExtras(bundle);
        }
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}