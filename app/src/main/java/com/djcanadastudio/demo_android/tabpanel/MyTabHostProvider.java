package com.djcanadastudio.demo_android.tabpanel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import com.djcanadastudio.demo_android.R;
import com.djcanadastudio.demo_android.activities.tabDemos.TabDemo1Activity;
import com.djcanadastudio.demo_android.activities.tabDemos.TabDemo2Activity;

public class MyTabHostProvider extends TabHostProvider
{
	private Tab demo1Tab;
	private Tab demo2Tab;
	
	private TabView tabView;
	private GradientDrawable gradientDrawable, transGradientDrawable;

	public MyTabHostProvider(Activity context) {
		super(context);
	}

	@Override
	public TabView getTabHost(String category) 
	{
		tabView = new TabView(context);
		tabView.setOrientation(TabView.Orientation.BOTTOM);
		tabView.setBackgroundID(R.drawable.tab_background_gradient);
		
		gradientDrawable = new GradientDrawable(
	            GradientDrawable.Orientation.TOP_BOTTOM,
	            new int[] {0xFFB2DA1D, 0xFF85A315});
	    gradientDrawable.setCornerRadius(0f);
	    gradientDrawable.setDither(true);
	    
	    transGradientDrawable = new GradientDrawable(
	            GradientDrawable.Orientation.TOP_BOTTOM,
	            new int[] {0x00000000, 0x00000000});
	    transGradientDrawable.setCornerRadius(0f);
	    transGradientDrawable.setDither(true);

		demo1Tab = new Tab(context, category);
		demo1Tab.setIcon(R.drawable.home_sel);
		demo1Tab.setIconSelected(R.drawable.home_sel);
		demo1Tab.setBtnText("Demo1");
		demo1Tab.setBtnTextColor(Color.WHITE);
		demo1Tab.setSelectedBtnTextColor(Color.BLACK);
//		demo1Tab.setBtnColor(Color.parseColor("#00000000"));
//		demo1Tab.setSelectedBtnColor(Color.parseColor("#0000FF"));
		demo1Tab.setBtnGradient(transGradientDrawable);
		demo1Tab.setSelectedBtnGradient(gradientDrawable);
		demo1Tab.setIntent(new Intent(context, TabDemo1Activity.class));

		demo2Tab = new Tab(context, category);
		demo2Tab.setIcon(R.drawable.home_sel);
		demo2Tab.setIconSelected(R.drawable.home_sel);
		demo2Tab.setBtnText("Demo2");
		demo2Tab.setBtnTextColor(Color.WHITE);
		demo2Tab.setSelectedBtnTextColor(Color.BLACK);
//		demo2Tab.setBtnColor(Color.parseColor("#00000000"));
//		demo2Tab.setSelectedBtnColor(Color.parseColor("#0000FF"));
		demo2Tab.setBtnGradient(transGradientDrawable);
		demo2Tab.setSelectedBtnGradient(gradientDrawable);
		demo2Tab.setIntent(new Intent(context, TabDemo2Activity.class));


		tabView.addTab(demo1Tab);
		tabView.addTab(demo2Tab);

		return tabView;
	}
}