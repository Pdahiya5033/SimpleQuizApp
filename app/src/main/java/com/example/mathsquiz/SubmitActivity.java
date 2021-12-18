package com.example.mathsquiz;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SubmitActivity extends AppCompatActivity {
    private final String TAG_SUB = "SubmitActivity";
    private static final String ACT_KEY="ActKey";
    private static final String SUBMIT_KEY="RESULT";
    protected TextView mResult;
    private Button mTryButton,mQuitButton;
    public static Intent newSubmitIntent(Context context, int s){
        Intent intent = new Intent(context, SubmitActivity.class);
        intent.putExtra(SUBMIT_KEY,s);
        return intent;
    }
    private void setActivityRes(int flag){
        Intent setAct = new Intent();
        setAct.putExtra(ACT_KEY,flag);
        setResult(RESULT_OK,setAct);
    }
    public static int giveActRes(Intent act){
        return act.getIntExtra(ACT_KEY,10);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Log.d(TAG_SUB,"in submit activity");
        int s = getIntent().getIntExtra(SUBMIT_KEY,-100);
        Log.d(TAG_SUB,"received value "+s);
        mResult = (TextView) findViewById(R.id.marks);
        mResult.setText(String.valueOf(s));
        mTryButton = (Button) findViewById(R.id.TryAgain);
        mTryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityRes(1);
                Log.d(TAG_SUB,"try again pressed");
                Intent j = new Intent(SubmitActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
        mQuitButton = (Button) findViewById(R.id.quit);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActivityRes(0);
                Log.d(TAG_SUB,"quit pressed");
                finish();
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG_SUB,"in stop of submit");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG_SUB,"in resume of submit");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG_SUB,"in destroy of submit");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG_SUB,"in pause of submit");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG_SUB,"in start of submit");
    }
}