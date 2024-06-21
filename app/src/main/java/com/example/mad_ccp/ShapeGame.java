package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShapeGame extends AppCompatActivity {

    EditText shapeNameInput;
    Button submitButton, quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_game);

        shapeNameInput = findViewById(R.id.shape_name_input);
        submitButton = findViewById(R.id.submit_button);
        quitButton = findViewById(R.id.next_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredShape = shapeNameInput.getText().toString().trim();
                if (enteredShape.equals("square")) {
                    // If the user enters "square", start ShapeGame2 activity
                    Intent intent = new Intent(ShapeGame.this, ShapeGame2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ShapeGame.this, "incorrect answer Entered, RETRY", Toast.LENGTH_SHORT).show();
                    shapeNameInput.setText("");
                }
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShapeGame2.class);
                startActivity(intent);
            }
        });
    }
}
