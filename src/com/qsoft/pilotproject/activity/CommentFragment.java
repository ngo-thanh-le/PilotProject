package com.qsoft.pilotproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.PilotProject.R;

/**
 * User: binhtv
 * Date: 10/17/13
 * Time: 2:20 PM
 */
public class CommentFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.program_comment,container,false);
        return view;
    }
}