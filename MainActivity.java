package com.example.luke.myproject;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;


import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;




import java.util.concurrent.TimeUnit;


//server information Server API Key help AIzaSyAUEbUpOdwMFFmanTz6lmRx9lpolTIKODI Sender ID: help  17098695400
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("newApi")
public class MainActivity extends Activity {

    Button button_1, button_2, button_3, button_4,  mNextButton, leave_room;
    TextView mQuestionTextView, mTextViewTime;
    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(bundle) called");
        setContentView(R.layout.activity_main);




        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        mNextButton = (Button) findViewById(R.id.next_button);
        leave_room = (Button) findViewById(R.id.leave_room);
        mTextViewTime = (TextView) findViewById(R.id.textViewTime);


        final CounterClass timer = new CounterClass(20000, 1000);
        timer.start();
        button_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonEffectButton1(button_1);
                clearbutton(button_1);

                //  showAnswer(button_1);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonEffectButton2(button_2);
                clearbutton(button_2);

                //showAnswer(button_2);
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonEffectButton3(button_3);
                clearbutton(button_3);

               // showAnswer(button_3);
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonEffectButton4(button_4);
                clearbutton(button_4);

                //showAnswer(button_4);
            }
        });



        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nextButtonEffect();
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                timer.start();

            }
        });

        leave_room.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });



        updateQuestion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    http://stackoverflow.com/questions/7175873/click-effect-on-button-in-android
public static void buttonEffectButton1(View button) {
    button.setOnTouchListener(new View.OnTouchListener() {

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                    v.invalidate();
                    break;
                }

            }

            return false;
        }
    });
    }

    public static void buttonEffectButton2(View button) {
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }

                }

                return false;
            }
        });
    }

    public static void buttonEffectButton3(View button) {
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }

                }

                return false;
            }
        });
    }

    public static void buttonEffectButton4(View button) {
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();

                        break;
                    }

                }

                return false;
            }
        });
    }


    public void nextButtonEffect() {
        button_1.getBackground().clearColorFilter();
        button_2.getBackground().clearColorFilter();
        button_3.getBackground().clearColorFilter();
        button_4.getBackground().clearColorFilter();
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        button_4.setEnabled(true);
    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("newApi")
    public class CounterClass extends CountDownTimer {

                public CounterClass(long millisInFuture, long countDownInterval) {
                    super(millisInFuture, countDownInterval);
                }

                @SuppressLint("newApi")
                @TargetApi(Build.VERSION_CODES.GINGERBREAD)
                @Override
                public void onTick(long millisUntilFinished) {

                    long millis = millisUntilFinished;
                    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                    System.out.println(hms);
                    mTextViewTime.setText(hms);


                }

                @Override
                public void onFinish() {

                       mTextViewTime.setText("completed.");
                       button_1.setEnabled(false);
                       button_2.setEnabled(false);
                       button_3.setEnabled(false);
                       button_4.setEnabled(false);
                }


            }


            private TrueFalse[] mQuestionBank = new TrueFalse[]{
                    new TrueFalse(R.string.question_1, true),
                    new TrueFalse(R.string.question_2, true),
                    new TrueFalse(R.string.question_3, true),

            };

            private int mCurrentIndex = 0;


            private void updateQuestion() {
                    int question = mQuestionBank[mCurrentIndex].getQuestion();
                    mQuestionTextView.setText(question);

            }

            //private void showAnswer(View button) {

              //  int messageResID = 0;

                //if (button == button_1) {
                  //  messageResID = R.string.option_1;
               // } else if (button == button_2) {
                 //   messageResID = R.string.option_2;
                //}
                //else if (button == button_3) {
                  //  messageResID = R.string.option_3;
                //}
                //else
                //{
                 //   messageResID = R.string.option_4;
                //}

                //Toast.makeText(this, messageResID, Toast.LENGTH_SHORT).show();
            //}

            public void clearbutton(View button) {

                if(button == button_1) {
                    button_2.getBackground().clearColorFilter();
                    button_3.getBackground().clearColorFilter();
                    button_4.getBackground().clearColorFilter();
                }
                else if(button == button_2) {
                    button_1.getBackground().clearColorFilter();
                    button_3.getBackground().clearColorFilter();
                    button_4.getBackground().clearColorFilter();
                }
                else if(button == button_3) {
                    button_1.getBackground().clearColorFilter();
                    button_2.getBackground().clearColorFilter();
                    button_4.getBackground().clearColorFilter();
                }
                else {
                    button_1.getBackground().clearColorFilter();
                    button_2.getBackground().clearColorFilter();
                    button_3.getBackground().clearColorFilter();
                }



            }

        }