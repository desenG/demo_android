package com.djcanadastudio.demo_android.activities.tabDemos;

import android.app.Activity;
import android.os.Bundle;

import com.djcanadastudio.demo_android.R;
import com.djcanadastudio.demo_android.tabpanel.MyTabHostProvider;
import com.djcanadastudio.demo_android.tabpanel.TabHostProvider;
import com.djcanadastudio.demo_android.tabpanel.TabView;

public class TabDemo2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHostProvider tabProvider = new MyTabHostProvider(TabDemo2Activity.this);
        TabView tabView = tabProvider.getTabHost("TabDemo2");
        tabView.setCurrentView(R.layout.activity_tab_demo2);
        setContentView(tabView.render(1));
    }
}
