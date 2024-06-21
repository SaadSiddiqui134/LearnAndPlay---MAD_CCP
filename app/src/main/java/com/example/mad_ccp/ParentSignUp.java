package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParentSignUp extends AppCompatActivity {

    Button btnBack_Parent, btnSignUpParent;
    EditText parentName, parentEmail, parentStdId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_sign_up); // Ensure this layout file exists and has the correct IDs

        btnBack_Parent = findViewById(R.id.BackButton_ParentSignup);
        btnSignUpParent = findViewById(R.id.signupButton_Parent);
        parentName = findViewById(R.id.parentName_SignUp);
        parentEmail = findViewById(R.id.ParentEmail_SignUp);
        parentStdId = findViewById(R.id.ParentSignUp_stdID);

        Database db = new Database(getApplicationContext());

        btnSignUpParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String parentSignupName = parentName.getText().toString();
                String parentEmailSignup = parentEmail.getText().toString();
                String parentStdIdSignup = parentStdId.getText().toString();

                if (parentSignupName.isEmpty() || parentEmailSignup.isEmpty() || parentStdIdSignup.isEmpty()) {
                    Toast.makeText(ParentSignUp.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    db.registerParent(parentSignupName, parentEmailSignup, Integer.parseInt(parentStdIdSignup));
                    Toast.makeText(getApplicationContext(), "Account created, please login to continue", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ParentSignUp.this, ParentLogin.class); // Ensure ParentLogin activity exists
                    startActivity(intent);
                }
            }
        });

        btnBack_Parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentSignUp.this, HomePage.class); // Ensure HomePage activity exists
                startActivity(intent);
            }
        });
    }
}
