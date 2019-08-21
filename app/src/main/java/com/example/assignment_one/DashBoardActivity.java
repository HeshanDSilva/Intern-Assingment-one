package com.example.assignment_one;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class DashBoardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


    }

    public void changeFragmenbt(View view){
        Fragment fragment1;
        Fragment fragment2;
        if(view == findViewById(R.id.hotels)) {
            fragment1 = new Hotels();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.dashboard , fragment1);
            ft.commit();

            Toast.makeText(this, "I'm dashboard",
                    Toast.LENGTH_SHORT).show();
        }
        if(view == findViewById(R.id.dash)){
            fragment2 = new DashBoardFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.dashboard , fragment2);
            ft.commit();
            Toast.makeText(this, "I'm hotel",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
