package com.example.mathsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private final String TAG = "CheatActivity";
    private static final String CHEAT_KEY="CHEAT_INDEX";
    private static final String IS_CHEATED="IS_CHEATED";
    private boolean isCheated = false;
    public static Intent newIntent(Context context, int i){
        Intent intent = new Intent(context,CheatActivity.class);
        intent.putExtra(CHEAT_KEY,i);
        return intent;
    }
    protected TextView mAnsViewer1,mAnsViewer2;
    Answers[] answ = new Answers[]{
            new Answers(R.string.sol1),
            new Answers(R.string.sol2),
            new Answers(R.string.sol3),
            new Answers(R.string.sol4),
            new Answers(R.string.sol5),
            new Answers(R.string.sol6),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Log.d(TAG,"in cheat activity");
        int i = getIntent().getIntExtra(CHEAT_KEY,-100);
        Log.d(TAG,"received value:"+i);
        int ans1=0;
        mAnsViewer1=(TextView) findViewById(R.id.ans1);
        ans1 = answ[i-1].getAns_id();
        mAnsViewer1.setText(ans1);
        mAnsViewer2  = (TextView) findViewById(R.id.ans2);
        ans1=answ[i].getAns_id();
        mAnsViewer2.setText(ans1);
        if(i>0){
            isCheated=true;
        }
        setAnswerRes(isCheated);
    }
    private void setAnswerRes(boolean b){
        Intent i = new Intent();
        i.putExtra(IS_CHEATED,b);
        setResult(RESULT_OK,i);
    }
    public static boolean wasCheatShown(Intent i){
        return i.getBooleanExtra(IS_CHEATED,false);
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"in stop of cheat");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"in resume of cheat");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"in destroy of cheat");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"in pause of cheat");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"in start of cheat");
    }
}