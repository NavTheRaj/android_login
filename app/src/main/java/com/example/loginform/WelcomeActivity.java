package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        String gender;

        editMessage = (EditText)findViewById(R.id.message);

        gender = getSelecetedGender();

        message = editMessage.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainActivity.USERNAME,message+"|"+gender);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

    public String getSelecetedGender(){
        RadioGroup radioGroup;
        RadioButton radioButton;
        radioGroup = (RadioGroup) findViewById(R.id.gender);

        int selectedId = radioGroup.getCheckedRadioButtonId();

        radioButton = (RadioButton) findViewById(selectedId);

        return radioButton.getText().toString();

    }
}
