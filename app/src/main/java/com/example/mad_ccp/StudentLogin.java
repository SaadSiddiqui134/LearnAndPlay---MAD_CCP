package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends AppCompatActivity {

    EditText stdname;
    Button btnback, btnSigupStd, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        btnSigupStd = findViewById(R.id.stdsignupButton);
        stdname = findViewById(R.id.studentNameInput);
        btnLogin = findViewById(R.id.stdLoginButton);
        btnback = findViewById(R.id.BackButtonStdPortal);

        Database db = new Database(getApplicationContext());

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLogin.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentLogin = stdname.getText().toString().trim();

                if (studentLogin.isEmpty()) {
                    Toast.makeText(StudentLogin.this, "Please fill the field", Toast.LENGTH_SHORT).show();
                } else if (db.loginStd(studentLogin) == 1) {
                    Toast.makeText(StudentLogin.this, "Login success", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = getSharedPreferences("login_check", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("flag", true);
                    editor.apply();
                    startActivity(new Intent(StudentLogin.this, StudentPortal.class));
                } else {
                    Toast.makeText(StudentLogin.this, "Login failed. Student not found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSigupStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentLogin.this, StudentSignUp.class);
                startActivity(intent);
            }
        });
    }
}
