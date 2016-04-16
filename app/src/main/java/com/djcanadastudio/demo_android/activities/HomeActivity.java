package com.djcanadastudio.demo_android.activities;

import android.app.Activity;
import android.os.Bundle;

import com.djcanadastudio.demo_android.R;
import com.djcanadastudio.demo_android.tabpanel.MyTabHostProvider;
import com.djcanadastudio.demo_android.tabpanel.TabHostProvider;
import com.djcanadastudio.demo_android.tabpanel.TabView;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHostProvider tabProvider = new MyTabHostProvider(HomeActivity.this);
        TabView tabView = tabProvider.getTabHost("Home");
        tabView.setCurrentView(R.layout.activity_home);
        setContentView(tabView.render(0));
    }
}