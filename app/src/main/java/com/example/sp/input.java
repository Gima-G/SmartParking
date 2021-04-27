package com.example.sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EditText mail = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText pass = (EditText) findViewById(R.id.editTextTextPassword);
        Button but = (Button) findViewById(R.id.button);
        View reg = (View) findViewById(R.id.textView);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mail.getText().toString().equals("") && pass.getText().toString().equals("")){
                    Intent intent = new Intent(input.this, map.class);
                    startActivity(intent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введеные данные не действительны", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(input.this, registration.class);
                startActivity(intent);
            }
        });
    }
}