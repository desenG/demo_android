package com.djcanadastudio.demo_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.djcanadastudio.demo_android.activities.tabDemos.TabDemo1Activity;
import com.djcanadastudio.demo_android.facebook.FacebookHelper;
import com.djcanadastudio.demo_android.facebook.FacebookUtility;
import com.djcanadastudio.demo_android.utilities.DoneCallback;
import com.djcanadastudio.demo_android.utilities.Navigator;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ProgressBar prg_demo;
    private int progress;

//    private TextView facebookLogin;
    private TextView facebookLogout;
    private FacebookHelper facebookHelper;
    //context
    private MainActivity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUI();
        startProgressAnimation();
        facebookHelper=new FacebookHelper(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        if (FacebookSdk.isFacebookRequestCode(requestCode)) {
            facebookHelper.getFacebookUtility().onActivityResult(requestCode, responseCode, data);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initElements();
    }

    private void linkUI() {
        prg_demo = (ProgressBar) this.findViewById(R.id.prg_demo);
//        facebookLogin = (TextView) findViewById(R.id.facebooklogin);
        facebookLogout = (TextView) findViewById(R.id.facebooklogout);
    }

    private void startProgressAnimation() {
        Timer t;
        TimerTask task;
        t = new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if(progress>100)
                        {
                            progress=0;
                        }
                        else
                        {
                            progress++;
                        }
                        prg_demo.setProgress(progress);
                    }
                });
            }
        };
        t.schedule(task, 0, 1000);
    }

    private void initElements() {
        initFacebook();
    }

    private void initFacebook() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null && !accessToken.isExpired()){
            facebookLogout.setVisibility(View.VISIBLE);
//            facebookLogin.setVisibility(View.GONE);
        }
        facebookHelper.getFacebookUtility().setOnTokenChangeListener(new FacebookUtility.OnTokenChangeListener() {
            @Override
            public boolean onTokenUpdate(AccessToken oldAccessToken, AccessToken newAccessToken) {
                if (newAccessToken == null) {
//                    facebookLogin.setVisibility(View.VISIBLE);
                    facebookLogout.setVisibility(View.GONE);
                } else {
                    facebookLogout.setVisibility(View.VISIBLE);
//                    facebookLogin.setVisibility(View.GONE);
                    Navigator.navigate(context, TabDemo1Activity.class);
                }
                return false;
            }
        });
        facebookHelper.getFacebookUtility().startTrackingToken();
    }

    public void loginFacebook(View view) {
        DoneCallback<String> doneCallback=new DoneCallback<String>() {
            @Override
            public void done(final String result) {
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result.equals("FAIL")) {
                        }
                    }
                });
            }
        };
        facebookHelper.login(doneCallback);
    }

    public void logoutFacebook(View v) {
        facebookHelper.facebookLogout();
    }

}
