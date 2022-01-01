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
            new Answers(LauncherActivity.mQuestions.get(0).getResult()),
            new Answers(LauncherActivity.mQuestions.get(1).getResult()),
            new Answers(LauncherActivity.mQuestions.get(2).getResult()),
            new Answers(LauncherActivity.mQuestions.get(3).getResult()),
            new Answers(LauncherActivity.mQuestions.get(4).getResult()),
            new Answers(LauncherActivity.mQuestions.get(5).getResult()),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Log.d(TAG,"in cheat activity");
        int i = getIntent().getIntExtra(CHEAT_KEY,-100);
        Log.d(TAG,"received value:"+i);
        boolean ans1=true;
        boolean ans2=true;
        mAnsViewer1=(TextView) findViewById(R.id.ans1);
        ans1 = answ[i-1].getAns();
        if(ans1==true){
            mAnsViewer1.setText(R.string.ans_true);
        }
        else{
            mAnsViewer1.setText(R.string.ans_false);
        }

        mAnsViewer2  = (TextView) findViewById(R.id.ans2);
        ans2=answ[i].getAns();
        if(ans2==true){
            mAnsViewer1.setText(R.string.ans_true);
            Log.i(TAG,"given 2nd answer");
        }
        else{
            mAnsViewer1.setText(R.string.ans_false);
            Log.i(TAG,"given 2nd answer");
        }
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