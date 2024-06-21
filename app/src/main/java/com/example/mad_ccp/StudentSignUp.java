package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentSignUp extends AppCompatActivity {

    Button btnBack,btnSignUp;
    EditText stdname, stdage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);

        btnBack=findViewById(R.id.BackButtonStdSignUp);
        btnSignUp=findViewById(R.id.stdsignupButton);
        stdname=findViewById(R.id.studentNameSignUp);
        stdage=findViewById(R.id.studentAgeSignUp);


        Database db = new Database(getApplicationContext());
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StdSignupName = stdname.getText().toString();
                String StdAgeSignup=stdage.getText().toString();

                if (StdSignupName.length() == 0 || StdAgeSignup.length() == 0) {
                    Toast.makeText(StudentSignUp.this, "Please fill all the Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent1 = new Intent();
                    db.registerStd(StdSignupName, Integer.parseInt(StdAgeSignup));
                    Toast.makeText(getApplicationContext(), "Account Created please Login to Continue", Toast.LENGTH_SHORT).show();
                    startActivity(intent1);

                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });


    }
}