package com.dohieu19999.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvAge;
    private Button btnLogin;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        preferences= getSharedPreferences("SHARED_PREF",MODE_PRIVATE);
        String name=preferences.getString("Name","");
        tvName.setText(name);
        int age = preferences.getInt("Age",0);
        tvAge.setText(String.valueOf(age));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(AnotherActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
