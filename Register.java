package com.example.buspasssystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button button;
    Button clear;
    EditText fullName,age, prnreg,email,pwd,scl;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = findViewById(R.id.buttonAccount);
        clear =findViewById(R.id.clear_text);

        scl = findViewById(R.id.editsclclg);
        fullName = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        prnreg = findViewById(R.id.prnReg);
        email = findViewById(R.id.editEmail);
        pwd = findViewById(R.id.editPass);
        firebaseAuth=FirebaseAuth.getInstance();



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fullName.getText().clear();
                age.getText().clear();
                prnreg.getText().clear();
                email.getText().clear();
                pwd.getText().clear();
                scl.getText().clear();

            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String age1=age.getText().toString().trim();
                String em=email.getText().toString().trim();
                String fname=fullName.getText().toString().trim();
                String prn=prnreg.getText().toString().trim();
                String passwd=pwd.getText().toString().trim();
                String clg= scl.getText().toString().trim();

                //validation

                if (TextUtils.isEmpty(passwd)) {
                    Toast.makeText(getApplicationContext(), "Enter Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwd.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too Short, Enter Minimum 6 Characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(age1)) {
                    Toast.makeText(getApplicationContext(), "Enter Age!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(clg)) {
                    Toast.makeText(getApplicationContext(), "Enter College or School Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(fname)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Full Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(prn)) {
                    Toast.makeText(getApplicationContext(), "Enter PRN or Register Number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(em)) {
                    Toast.makeText(getApplicationContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(em,passwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Toast.makeText(Register.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                        // If sign-in fails, display a message to the user. If sign-in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Register.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_LONG).show();
                            Log.e("MyTag", task.getException().toString());
                        } else {

                            startActivity(new Intent(Register.this, Dashboard.class));
                            finish();
                        }

                    }
                });



                firebaseDatabase=FirebaseDatabase.getInstance();
                databaseReference= firebaseDatabase.getReference("Register");
                RegisterDetails registerDetails=new RegisterDetails(fname,clg,em,passwd,age1,prn);
                databaseReference.child(prn).setValue(registerDetails);
                Toast.makeText(Register.this, "Data Registered Successfully", Toast.LENGTH_SHORT).show();




            }
        });


    }


}