package com.djcanadastudio.demo_android.tabpanel;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import com.djcanadastudio.demo_android.R;
import com.djcanadastudio.demo_android.activities.ContactActivity;
import com.djcanadastudio.demo_android.activities.HomeActivity;

public class MyTabHostProvider extends TabHostProvider
{
	private Tab homeTab;
	private Tab contactTab;
	private Tab shareTab;
	private Tab moreTab;
	
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

		homeTab = new Tab(context, category);
		homeTab.setIcon(R.drawable.home_sel);
		homeTab.setIconSelected(R.drawable.home_sel);
		homeTab.setBtnText("Home");
		homeTab.setBtnTextColor(Color.WHITE);
		homeTab.setSelectedBtnTextColor(Color.BLACK);
//		homeTab.setBtnColor(Color.parseColor("#00000000"));
//		homeTab.setSelectedBtnColor(Color.parseColor("#0000FF"));
		homeTab.setBtnGradient(transGradientDrawable);
		homeTab.setSelectedBtnGradient(gradientDrawable);
		homeTab.setIntent(new Intent(context, HomeActivity.class));

		contactTab = new Tab(context, category);
		contactTab.setIcon(R.drawable.menu_sel);
		contactTab.setIconSelected(R.drawable.menu_sel);
		contactTab.setBtnText("Contact");
		contactTab.setBtnTextColor(Color.WHITE);
		contactTab.setSelectedBtnTextColor(Color.BLACK);
//		contactTab.setBtnColor(Color.parseColor("#00000000"));
//		contactTab.setSelectedBtnColor(Color.parseColor("#0000FF"));
		contactTab.setBtnGradient(transGradientDrawable);
		contactTab.setSelectedBtnGradient(gradientDrawable);
		contactTab.setIntent(new Intent(context, ContactActivity.class));


		tabView.addTab(homeTab);
		tabView.addTab(contactTab);

		return tabView;
	}
}