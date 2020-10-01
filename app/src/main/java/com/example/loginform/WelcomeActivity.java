package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    final static String USERNAME ="USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String username = getIntent().getStringExtra(USERNAME);

        Toast.makeText(this,"Hello "+username,Toast.LENGTH_LONG).show();
    }

    public void messagePass(View view){
        EditText editMessage;
        String message;

        editMessage = (EditText)findViewById(R.id.message);

        message = editMessage.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainActivity.USERNAME,message);
        setResult(RESULT_OK,resultIntent);
        finish();
    }
}
