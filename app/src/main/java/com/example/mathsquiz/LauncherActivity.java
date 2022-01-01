package com.example.mathsquiz;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class LauncherActivity extends AppCompatActivity {
    private static final String TAG="LauncherActivity";
    private String code="100";
    private Button mButton;
    private CheckBox mCheckBox[]=new CheckBox[12];
    public static List<Questions> mQuestions=new ArrayList<>();
    private int questSize=0;
    public static LinearLayout mLinearLayout;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_choice);

        mButton=(Button) findViewById(R.id.start_quiz);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questSize==0){
                    mLinearLayout=(LinearLayout) findViewById(R.id.checkboxes);
                    FragmentManager fragment=getSupportFragmentManager();
                    Fragment fm=ErrorFragment.createErrorFragment();
                    fragment.findFragmentById(R.id.initial_fragment_choice);
                    fragment.beginTransaction().add(R.id.initial_fragment_choice,fm).addToBackStack(null).setReorderingAllowed(true)
                            .commit();

                }
                else{
                    Intent intent=new Intent(LauncherActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });
        mCheckBox[0]=(CheckBox) findViewById(R.id.movies_checkbox);
        mCheckBox[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="11";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[1]=(CheckBox) findViewById(R.id.gk_checkbox);
        mCheckBox[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="9";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[2]=(CheckBox) findViewById(R.id.sports_checkbox);
        mCheckBox[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="21";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[3]=(CheckBox) findViewById(R.id.comp_checkbox);
        mCheckBox[3].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="18";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[4]=(CheckBox) findViewById(R.id.comics_checkbox);
        mCheckBox[4].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="29";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[5]=(CheckBox) findViewById(R.id.manga_checkbox);
        mCheckBox[5].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="31";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[6]=(CheckBox) findViewById(R.id.video_checkbox);
        mCheckBox[6].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="15";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[7]=(CheckBox) findViewById(R.id.books10_checkbox);
        mCheckBox[7].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="10";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[8]=(CheckBox) findViewById(R.id.tv14_checkbox);
        mCheckBox[8].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="14";
                    new FetchQuestions().execute();
                }
            }
        });

        mCheckBox[9]=(CheckBox) findViewById(R.id.nature17_checkbox);
        mCheckBox[9].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="17";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[10]=(CheckBox) findViewById(R.id.theatres13_checkbox);
        mCheckBox[10].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="13";
                    new FetchQuestions().execute();
                }
            }
        });
        mCheckBox[11]=(CheckBox) findViewById(R.id.history23_checkbox);
        mCheckBox[11].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    code="23";
                    new FetchQuestions().execute();
                }
            }
        });
    }
    private class FetchQuestions extends AsyncTask<Void,Integer, List<Questions>> {
        @Override
        protected void onPreExecute(){
            Log.i(TAG,"downloading data");
        }
        @Override
        protected List<Questions> doInBackground(Void... voids) {
//            publishProgress(1,2,3,4,5,6);
            return new TriviaFetcher().fetchItems(code);
        }
//        @Override
//        protected void onProgressUpdate(Integer... progress){
//            setProgressPercent(progress[0]);
//            Log.i(TAG,"inside onProgressUpdate");
//        }
        @Override
        protected void onPostExecute(List<Questions> questions){
            LauncherActivity.mQuestions=questions;
            questSize=LauncherActivity.mQuestions.size();
            Log.i(TAG,"got "+LauncherActivity.mQuestions.size()+" questions");

        }
    }
//    public  void setmFrameLayout(){
//        mFrameLayout=(FrameLayout) findViewById(R.id.initial_fragment_choice);
//        int isVisible=mFrameLayout.getVisibility();
//        if(isVisible==View.VISIBLE){
//            mFrameLayout.setVisibility(View.INVISIBLE);
//        }
//        else{
//            mFrameLayout.setVisibility(View.VISIBLE);
//        }
//    }
//    public void setProgressPercent(int percentage){
//        String str="123456";
//        mButton=(Button) findViewById(R.id.start_quiz);
//        mButton.setVisibility(buttonText);
//        Log.i(TAG,"inside setProgressPercent");
//        buttonText=View.INVISIBLE;
//    }
}
