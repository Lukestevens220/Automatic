package com.example.luke.myproject;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// http://www.tutorialspoint.com/android/android_login_screen.htm
public class LoginActivity extends FragmentActivity {
    Button submit, register;
    EditText username, password;
    private ActionBar actionBar;


    TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("    Welcome to Smart Poll     ");
        actionBar.setDisplayUseLogoEnabled(false);


        submit = (Button) findViewById(R.id.submit);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        register = (Button) findViewById(R.id.register);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin")  &&

                        password.getText().toString().equals("admin")) {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));}
                else if (username.getText().toString().equals("admin") && (!(password.getText().toString().equals("admin")))) {
                    password.setError(getString(R.string.error_incorrect_password));
                }
                else {
                    username.setError(getString(R.string.error_invalid_username));
                }


            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}