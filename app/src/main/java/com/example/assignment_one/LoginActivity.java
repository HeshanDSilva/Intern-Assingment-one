package com.example.assignment_one;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public static final String PASSWORD = "com.examples.assignment_one.PASSWORD";
    public static final String USER_NAME = "com.examples.assignment_one.USER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){

        Intent intent = new Intent(this, DashBoardActivity.class);
        startActivity(intent);
        finish();

    }

}
