package com.irekasoft.irslidingmenu.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irekasoft.irslidingmenu.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

  TextView lbl_msg;

  private String message;

  public void setMessage(String message){

    lbl_msg.setText(message);

  }

  public MainFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    lbl_msg = (TextView)view.findViewById(R.id.lbl_msg);

    return view;
  }

}
