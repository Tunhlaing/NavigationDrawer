package com.example.navigationdrawer;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class SettingFragment extends Fragment {
    Button btYellow, btBlue, btGreen;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        btYellow =v.findViewById(R.id.btYellow);
        btBlue = v.findViewById(R.id.btBlue);
        btGreen = v.findViewById(R.id.btGreen);

        btYellow.setBackgroundColor(Color.YELLOW);
        btBlue.setBackgroundColor(Color.BLUE);
        btGreen.setBackgroundColor(Color.GREEN);




        return  v;


    }
}