package com.example.buspasssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Forgotpwd extends AppCompatActivity {

    Button fpsearch;
    EditText ep,cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpwd);
        fpsearch=findViewById(R.id.fpsearch);
        ep=findViewById(R.id.editTextEP);
        cp=findViewById(R.id.editTextCP);

        fpsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ep.setEnabled(true);
                cp.setEnabled(true);

            }
        });

    }
}