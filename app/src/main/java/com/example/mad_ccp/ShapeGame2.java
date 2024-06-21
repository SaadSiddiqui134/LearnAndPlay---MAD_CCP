package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShapeGame2 extends AppCompatActivity {

    EditText shape2NameInput;
    Button submitButton_Sgame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_game2);

        shape2NameInput = findViewById(R.id.shape_name_input2);
        submitButton_Sgame2 = findViewById(R.id.submit_button2);


        submitButton_Sgame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredShape = shape2NameInput.getText().toString().trim();
                if (enteredShape.equalsIgnoreCase("circle")) {
                    // If the user enters "square", start ShapeGame2 activity
                    Intent intent = new Intent(ShapeGame2.this, ShapeGame3.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ShapeGame2.this, "incorrect answer Entered, RETRY", Toast.LENGTH_SHORT).show();
                    shape2NameInput.setText("");
                }
            }
        });

    }
}
