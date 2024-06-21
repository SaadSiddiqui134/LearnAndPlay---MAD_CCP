package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParentPortal extends AppCompatActivity {
    Button btnFeed,btnReview,btnBackPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_portal);

        btnFeed=findViewById(R.id.buttonFeedback);
        btnReview=findViewById(R.id.buttonCheckReward);
        btnBackPP=findViewById(R.id.BackButtonPP);



        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentPortal.this,Feedback.class);
                startActivity(intent);
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentPortal.this,ChildReward.class);
                startActivity(intent);
            }
        });

        btnBackPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentPortal.this, ParentLogin.class);
                startActivity(intent);
            }
        });








    }
}