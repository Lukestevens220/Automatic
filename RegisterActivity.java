package com.example.luke.myproject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    String valid_name = null, valid_nationalNumber = null,
            valid_password = null, valid_re_password = null, valid_nation = null;
    Button register, cancel;
    EditText username, password, re_password, nationalNumber;
    Spinner nation;
    private static final String TAG = "RegisterActivity";
    private ActionBar actionBar;
    DatabaseHandler dbHandler = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(bundle) called");
        setContentView(R.layout.activity_register);
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle("  Week Assignment one  ");
        actionBar.setDisplayUseLogoEnabled(false);


        register = (Button) findViewById(R.id.register);
        cancel = (Button) findViewById(R.id.cancel);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        nation = (Spinner) findViewById(R.id.nation);
        nationalNumber = (EditText) findViewById(R.id.nationalNumber);
        re_password = (EditText) findViewById(R.id.re_password);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("")
                        || (nationalNumber.getText().toString().equals(""))
                        || (password.getText().toString().equals("")
                        || (re_password.getText().toString().equals("")

                ))) {
                    Toast.makeText(RegisterActivity.this,
                            "Please complete all mandatory fields", Toast.LENGTH_LONG).show();
                } else if (!(password.getText().toString().equals(re_password.getText().toString()))) {
                    Toast.makeText(RegisterActivity.this,
                            "Passwords do not match", Toast.LENGTH_LONG).show();
                } else {
                    // TODO Auto-generated method stub
                    // check the value state is null or not
		/*if (valid_name != null &&  valid_name.length() != 0*/
                    valid_name = username.getText().toString();
                    valid_nationalNumber = nationalNumber.getText().toString();
                    valid_password = password.getText().toString();
                    valid_re_password = re_password.getText().toString();
                    valid_nation = nation.getSelectedItem().toString();

                    dbHandler.Add_Contact(new Contact(valid_name, valid_nationalNumber,  valid_password, valid_re_password, valid_nation));
                    Context context = getApplicationContext();
                    CharSequence text = "Data submitted";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                    Log.d("person", dbHandler.Get_Contacts().toString());
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    Toast.makeText(RegisterActivity.this,
                            "Account has been registered", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
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


}

