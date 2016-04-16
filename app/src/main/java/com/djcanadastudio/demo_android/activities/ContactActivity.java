package com.djcanadastudio.demo_android.activities;

import android.app.Activity;
import android.os.Bundle;

import com.djcanadastudio.demo_android.R;
import com.djcanadastudio.demo_android.tabpanel.MyTabHostProvider;
import com.djcanadastudio.demo_android.tabpanel.TabHostProvider;
import com.djcanadastudio.demo_android.tabpanel.TabView;

public class ContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHostProvider tabProvider = new MyTabHostProvider(ContactActivity.this);
        TabView tabView = tabProvider.getTabHost("Contact");
        tabView.setCurrentView(R.layout.activity_contact);
        setContentView(tabView.render(1));
    }

}
