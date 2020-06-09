package com.dohieu19999.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtAge;
    private CheckBox btnCheck;
    private Button btnLogin;
    SharedPreferences sharedPreferences;
    boolean isRememebered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = (EditText) findViewById(R.id.edtName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        btnCheck = (CheckBox) findViewById(R.id.btnCheck);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        isRememebered = sharedPreferences.getBoolean("CHECKBOX",false);
        if (isRememebered){
            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            startActivity(intent);
            finish();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                Integer age = Integer.valueOf(edtAge.getText().toString().trim());
                boolean checked = btnCheck.isChecked();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name", name);
                editor.putInt("Age", age);
                editor.putBoolean("CHECKBOX", checked);
                editor.apply();
                Toast.makeText(MainActivity.this, "Infomation Saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
