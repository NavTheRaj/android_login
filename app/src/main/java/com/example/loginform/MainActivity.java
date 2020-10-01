package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class MainActivity extends AppCompatActivity {
    final static String NAME="admin";
    final static String PASSWORD="admin";
    final static int REQUEST_CODE = 100;
    final static String USERNAME ="USERNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkLogin(View view){
        EditText editName,editPassword;
        String name,password;

        editName = (EditText) findViewById(R.id.name);
        editPassword = (EditText) findViewById(R.id.password);

        name = editName.getText().toString();
        password = editPassword.getText().toString();


        if(name.equals("") || name.equals(null)){
            editName.setError("Name cannot be empty!");
        }

        if(password.equals("") || password.equals(null)){
            editPassword.setError("Password cannot be empty!");
        }

        if(name.equals(NAME) && password.equals(PASSWORD)){
            Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
            intent.putExtra(WelcomeActivity.USERNAME,name);
            startActivityForResult(intent,REQUEST_CODE);

        }else{
            Toast.makeText(this,"Invalid Username or Password",Toast.LENGTH_SHORT).show();
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get result from the result intent.
                String result = data.getStringExtra(USERNAME);
                Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
            }
        }
    }
}