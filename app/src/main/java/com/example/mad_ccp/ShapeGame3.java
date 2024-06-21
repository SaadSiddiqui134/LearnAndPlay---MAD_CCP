package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShapeGame3 extends AppCompatActivity {

    EditText shape3NameInput;
    Button submitButton_Sgame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_game3);

        shape3NameInput = findViewById(R.id.shape_name_input3);
        submitButton_Sgame3 = findViewById(R.id.submit_button3);


        submitButton_Sgame3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredShape = shape3NameInput.getText().toString().trim();
                if (enteredShape.equalsIgnoreCase("rectangle")) {
                    // If the user enters "square", start ShapeGame2 activity
                    Intent intent = new Intent(ShapeGame3.this, StudentPortal.class);
                    startActivity(intent);

                    //Start MusicService
                    startService(new Intent(ShapeGame3.this, MusicService.class));
                } else {
                    Toast.makeText(ShapeGame3.this, "incorrect answer Entered, RETRY", Toast.LENGTH_SHORT).show();
                    shape3NameInput.setText("");
                }
            }
        });

    }
}
