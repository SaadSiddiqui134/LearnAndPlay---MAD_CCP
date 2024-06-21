package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentPortal extends AppCompatActivity {

    Button Back,btnPlayShape,btnPlayNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);
        btnPlayShape=findViewById(R.id.buttonPlayShapeGame);
        btnPlayNumbers=findViewById(R.id.buttonPlayNumbersGame);

        Back=findViewById(R.id.BackButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentPortal.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnPlayShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(StudentPortal.this, ShapeGame.class);
                startActivity(intent);
            }
        });

        btnPlayNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NumberGame.class);
                startActivity(intent);
            }
        });
    }
}