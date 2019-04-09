package com.example.shaliniverma.stackoverflow;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private static Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
    public void LoginButton(){
        login_button = (Button)findViewById(R.id.login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,UserInterestActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
