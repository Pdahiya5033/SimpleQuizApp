package com.example.mathsquiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

public class ErrorFragment extends Fragment {
    private FrameLayout frameLayout;
    private static final String TAG="errorFragment";
    public static ErrorFragment createErrorFragment(){
        return new ErrorFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LauncherActivity.mLinearLayout.setVisibility(View.INVISIBLE);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.show_error,container,false);
        Log.i(TAG,"inflated fragment");


        return view;
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        LauncherActivity.mLinearLayout.setVisibility(View.VISIBLE);
    }
}
