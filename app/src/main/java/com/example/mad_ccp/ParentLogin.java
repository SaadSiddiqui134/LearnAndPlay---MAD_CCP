package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParentLogin extends AppCompatActivity {

    EditText ParentName,Parent_stdID;
    Button btnbacktoHome, btnSigupParent, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        btnSigupParent = findViewById(R.id.signupButtonParent);
        ParentName = findViewById(R.id.ParentNameInput2);
        Parent_stdID=findViewById(R.id.studentIDInput_Parent);
        btnLogin = findViewById(R.id.loginButtonParent);
        btnbacktoHome= findViewById(R.id.BackButtontoHomepage_Parent);

        Database db = new Database(getApplicationContext());

        btnbacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentLogin.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ParentLogin = ParentName.getText().toString().trim();
                String Parent_studentID = Parent_stdID.getText().toString().trim();

                if (ParentLogin.isEmpty()) {
                    Toast.makeText(ParentLogin.this, "Please fill the field", Toast.LENGTH_SHORT).show();
                } else if (db.loginParent(ParentLogin,Parent_studentID) == 1) {
                    Toast.makeText(ParentLogin.this, "Login success", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = getSharedPreferences("login_check", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putBoolean("flag", true);
                    editor.apply();
                    startActivity(new Intent(ParentLogin.this, ParentPortal.class));
                } else {
                    Toast.makeText(ParentLogin.this, "Login failed. Parent not found.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSigupParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentLogin.this, ParentSignUp.class);
                startActivity(intent);
            }
        });
    }
}
