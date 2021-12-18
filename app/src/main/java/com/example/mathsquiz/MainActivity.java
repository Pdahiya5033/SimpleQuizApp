package com.example.mathsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX="index";
    private static final int REQUEST_SUBMIT_CODE=0;
    private static final int REQUEST_CHEAT_CODE=1;
    private Button mTrueButton,mTrueButton2;
    private Button mFalseButton,mFalseButton2;
    private TextView mQuestionViewer1,mQuestionViewer2;
    private boolean mCheated;
    private Button mNextButton;
    private Button mCheatButton;
    private Button mSubmitButton;
    public int checkResume;
    Questions[] quest = new Questions[]{
            new Questions(R.string.question_text1,true),
            new Questions(R.string.question_text2,true),
            new Questions(R.string.question_text3,false),
            new Questions(R.string.question_text4,false),
            new Questions(R.string.question_text5,true),
            new Questions(R.string.question_text6,true),
    };
    private int index=0;
    private int final_result = 0;
    public void display_text()
    {
        if(index==5)
            index++;
        if(index%6==0)
            index=index%6;
        else
            index=index%6+1;
        mQuestionViewer1=(TextView) findViewById(R.id.ques_view1);
        int question1 = quest[index].getQues_id();
        mQuestionViewer1.setText(question1);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==true)
                {
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    final_result++;
                }

                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==false)
                {
                    Toast to=Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT);
                    to.show();
                    final_result++;
                }
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

            }
        });
        // 2nd question
        index=1+index%6;
        mQuestionViewer2=(TextView) findViewById(R.id.ques_view2);
        int question2=quest[index].getQues_id();
        mQuestionViewer2.setText(question2);
        mTrueButton2 = (Button) findViewById(R.id.true_button2);
        mTrueButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==true){
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    final_result++;
                }

                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton2 = (Button) findViewById(R.id.false_button2);
        mFalseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==false)
                {
                    Toast to=Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT);
                    to.show();
                    final_result++;
                }
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"in onCreate");
        mQuestionViewer1=(TextView) findViewById(R.id.ques_view1);
        if(savedInstanceState!=null){
            index=savedInstanceState.getInt(KEY_INDEX,0)-1;
        }
        int question1 = quest[index].getQues_id();
        mQuestionViewer1.setText(question1);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==true)
                {
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    final_result++;
                }

                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==false)
                {
                    Toast to=Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
                    to.show();
                    final_result++;
                }
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

            }
        });
        // 2nd question
        mQuestionViewer2=(TextView) findViewById(R.id.ques_view2);
        index=index+1;
        int question2 = quest[index].getQues_id();
        mQuestionViewer2.setText(question2);
        mTrueButton2 = (Button) findViewById(R.id.true_button2);
        mTrueButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==true)
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                final_result++;
            }
        });
        mFalseButton2 = (Button) findViewById(R.id.false_button2);
        mFalseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quest[index].getResult()==false)
                {
                    Toast to=Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
                    to.show();
                    final_result++;
                }
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

            }
        });

        mNextButton=(Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_text();

            }
        });
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"cheat pressed");
                Intent i = CheatActivity.newIntent(MainActivity.this,index);
//                startActivity(i);
                startActivityForResult(i,REQUEST_CHEAT_CODE);
            }
        });
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d(TAG,"submit pressed");
//                Intent s = new Intent(MainActivity.this,SubmitActivity.class);
                Intent s = SubmitActivity.newSubmitIntent(MainActivity.this,final_result);
                startActivityForResult(s,REQUEST_SUBMIT_CODE);
                // FOR opening webpage
//                Uri webpage = Uri.parse("https://www.android.com");
                // for location
//                Uri location=Uri.parse("https://www.google.com/maps/@28.9262533,76.8836775,13.46z");
//                Intent webIntent=new Intent(Intent.ACTION_VIEW,location);
//                startActivity(webIntent);
                //for opening contacts list
//                Uri number=Uri.parse("content://contacts/people/");
//                Intent callIntent=new Intent(Intent.ACTION_VIEW,number);
//                startActivity(callIntent);
                // for dialing number
                //Uri dial=Uri.parse("tel:123456");
//                Intent calendarIntent=new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
//                Calendar beginTime=Calendar.getInstance();
//                beginTime.set(2021,12,9,10,50);
//                Calendar endTime=Calendar.getInstance();
//                endTime.set(2021,12,9,12,30,10);
//                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis());
//                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime.getTimeInMillis());
//                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION,"Sehri");
//                calendarIntent.putExtra(CalendarContract.Events.TITLE,"App dev");
                // for checking if any suitable activity is present in target app or not
//                Uri contactList=Uri.parse("content://contacts/people");
//                Intent contactIntent=new Intent(Intent.ACTION_VIEW,contactList);
//                PackageManager packageManager=getPackageManager();
//                List<ResolveInfo> activities=packageManager.queryIntentActivities(contactIntent,0);
//                boolean isIntentSafe=activities.size()>0;
//                if(isIntentSafe){
//                    startActivity(contactIntent);
//                }
                // app chooser
//                Intent intent=new Intent(Intent.ACTION_SEND);
//                String title=getResources().getString(R.string.ans_text1);
//                Intent chooser=Intent.createChooser(intent,title);
//                if(intent.resolveActivity(getPackageManager())!=null){
//                    startActivity(chooser);
//                }
                String[] TO={"parteekdahiya263@gmail.com"};
                String[] CC={"pfffxy571@gmail.com"};
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("send image:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,TO);
                emailIntent.putExtra(Intent.EXTRA_CC,CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Email message goes here:");
                try{
                    startActivity(Intent.createChooser(emailIntent,"Send Mail...."));
                    finish();
                    Log.i(TAG,"finished sending mail");
                }catch(android.content.ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this,"there is no email client installed",Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CHEAT_CODE){
            if(data==null){
                return;
            }
            mCheated = CheatActivity.wasCheatShown(data);
        }
        if(requestCode==REQUEST_SUBMIT_CODE){

            if(data==null){
                return;
            }
            checkResume = SubmitActivity.giveActRes(data);
            if(checkResume==1){
                Log.d(TAG,"user want to restart quiz");

            }
            else if(checkResume==0){
                Log.d(TAG,"user wants to quit");
                finish();
            }
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"in onStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"in onResume");
        Log.d(TAG,"did you cheat? "+mCheated);
    }

        @Override
        public void onSaveInstanceState(Bundle savedInstanceState){
            super.onSaveInstanceState(savedInstanceState);
            Log.i(TAG,"inside onSaveInstance");
            savedInstanceState.putInt(KEY_INDEX,index);
        }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"in onDestroy");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"in onPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"in onStop");
    }

}