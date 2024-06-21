package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button studentPortalButton, ParentPortalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        startService(new Intent(HomePage.this, ConnectivityReciever.class));

        studentPortalButton = findViewById(R.id.buttonStudentPortal);
        ParentPortalButton=findViewById(R.id.buttonParentPortal);
        studentPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, StudentLogin.class);
                startActivity(intent);
            }
        });

        ParentPortalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, ParentLogin.class);
                startActivity(intent);
            }
        });
    }
}
