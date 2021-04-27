package com.example.sp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText mail = (EditText) findViewById(R.id.editTextTextEmailAddress4);
        EditText pass = (EditText) findViewById(R.id.editTextTextPassword4);
        EditText pass2 = (EditText) findViewById(R.id.editTextTextPassword5);
        Button but = (Button) findViewById(R.id.button4);
        View input = (View) findViewById(R.id.textView4);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().equals(pass2.getText().toString())){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Аккаунт успешно создан!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(registration.this, input.class);
                    startActivity(intent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Пароли не совпадают!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this, input.class);
                startActivity(intent);
            }
        });
    }
}