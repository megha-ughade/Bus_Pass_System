package com.example.buspasssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class
StudentPass extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton daily,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_pass);
        radioGroup=findViewById(R.id.radioGroup);
        daily=findViewById(R.id.radioDaily);
        month=findViewById(R.id.radioMonth);
        year=findViewById(R.id.radioYearly);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioDaily:
                        Toast.makeText(StudentPass.this, "You Choose Daily Pass!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentPass.this,DailyPass.class));
                        break;
                    case R.id.radioMonth:
                        Toast.makeText(StudentPass.this, "You Choose Monthly Pass!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentPass.this,MonthlyPass.class));
                        break;
                    case R.id.radioYearly:
                        Toast.makeText(StudentPass.this, "You Choose Yearly Pass!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentPass.this,YearlyPass.class));
                        break;
                }
            }
        });
    }
}