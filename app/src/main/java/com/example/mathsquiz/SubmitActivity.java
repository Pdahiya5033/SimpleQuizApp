package com.example.mathsquiz;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class SubmitActivity extends AppCompatActivity {
    private final String TAG_SUB = "SubmitActivity";
    private static final String ACT_KEY="ActKey";
    private static final String SUBMIT_KEY="RESULT";
    protected TextView mResult;
    private static int final_result;
    private Button mTryButton,mQuitButton,mShareButton;
    public static Intent newSubmitIntent(Context context, int s,boolean b){
        Intent intent = new Intent(context, SubmitActivity.class);
        if(b==true){
            intent.putExtra(SUBMIT_KEY,s-2);
        }
        else{
            intent.putExtra(SUBMIT_KEY,s);
        }
        final_result=intent.getIntExtra(SUBMIT_KEY,0);
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
        mShareButton=(Button) findViewById(R.id.share_button);
        mShareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String[] TO={"parteekdahiya263@gmail.com"};
                String[] CC={"pfffxy571@gmail.com"};
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("send image:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
                emailIntent.putExtra(Intent.EXTRA_CC,CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Marks obtained are: "+SubmitActivity.final_result);
                try{
                    startActivity(Intent.createChooser(emailIntent,"Send Mail...."));
                    finish();
                    Log.i(TAG_SUB,"finished sending mail");
                }catch(android.content.ActivityNotFoundException e){
                    Toast.makeText(SubmitActivity.this,"there is no email client installed",Toast.LENGTH_SHORT)
                            .show();
                }
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