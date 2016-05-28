package com.irekasoft.irslidingmenu.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.irekasoft.irslidingmenu.R;
import com.irekasoft.irslidingmenu.fragment.MainFragment;
import com.irekasoft.irslidingmenu.fragment.MenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

  private Toolbar toolbar;
  MainFragment mainFragment;

  @Override
  public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //set menu view for sliding menu in this activity
    setBehindView();

    SlidingMenu sm = getSlidingMenu();

    sm.setMode(SlidingMenu.LEFT);
    sm.setShadowWidth(1);
    sm.setBehindOffset(120);
    sm.setFadeDegree(0.35f);
    sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);


    toolbar = (Toolbar)findViewById(R.id.tool_bar);
    toolbar.setNavigationIcon(R.drawable.ico_burger);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        toggle();
      }
    });

    mainFragment = new MainFragment();
    transactionFragments(mainFragment,R.id.container);

  }


  /**
   * Replace fragment by fragment transaction
   * @param fragment
   * @param viewResource
   */
  public void transactionFragments(Fragment fragment, int viewResource) {
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(viewResource, fragment);
    ft.commit();
    toggle();
  }


  private void setBehindView() {

    setBehindContentView(R.layout.menu_slide);
    //transaction fragment to sliding menu
    transactionFragments(MenuFragment.newInstance(), R.id.menu_slide);
  }

  // ACTIONS

  public void showFragment(String message){


    mainFragment.setMessage(message);

    transactionFragments(mainFragment,R.id.container);

  }
}
