package com.zou.alm;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.zou.alm.MyApp.activityCount;


public class B_SingleTopActivity extends AppCompatActivity implements View.OnClickListener {


    private Intent intent;
    private int mStackID;
    private TextView detail;
    private int numActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
    }

    private void init() {
        mStackID = getTaskId();
        ActivityManager mManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        numActivities = mManager.getRunningTasks(1).get(0).numActivities;
        Log.e("tag", "onCreate: Activity Name：" + getClass().getSimpleName() + "  Stack ID:" + mStackID + "==>Stack has " + activityCount++ + " Activity");

    }

    @Override
    protected void onStart() {
        Log.e("tag", "onStart: " + getClass().getSimpleName());
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("tag", "onResume: " + getClass().getSimpleName());
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("tag", "onPause: " + getClass().getSimpleName());
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("tag", "onStop: " + getClass().getSimpleName());
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("tag", "onDestroy: " + getClass().getSimpleName() + "==>All stacks have " + (--activityCount - 1) + " Activities");
        super.onDestroy();
    }


    private void initView() {
        Button button1 = (Button) findViewById(R.id.btn1);
        Button button2 = (Button) findViewById(R.id.btn2);
        Button button3 = (Button) findViewById(R.id.btn3);
        Button button4 = (Button) findViewById(R.id.btn4);
        Button button5 = (Button) findViewById(R.id.btn5);
        Button print = (Button) findViewById(R.id.btn_print_stack_activity);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        print.setOnClickListener(this);
        detail = (TextView) findViewById(R.id.tv_detail);
        ((TextView) findViewById(R.id.tv_title)).setText(getString(R.string.modeB));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                intent = new Intent(this, A1_StandardActivity.class);
            }
            break;
            case R.id.btn2: {
                intent = new Intent(this, A2_StandardActivity.class);
            }
            break;
            case R.id.btn3: {
                intent = new Intent(this, B_SingleTopActivity.class);
            }
            break;
            case R.id.btn4: {
                intent = new Intent(this, C_SingleTaskActivity.class);
            }
            break;
            case R.id.btn5: {
                intent = new Intent(this, D_SingleInstanceActivity.class);
            }
            break;
            case R.id.btn_print_stack_activity: {
                detail.setText("Stack(ID:" + mStackID + ") has " + numActivities + " Activities");
            }
            return;
        }
        startActivity(intent);
    }
}
