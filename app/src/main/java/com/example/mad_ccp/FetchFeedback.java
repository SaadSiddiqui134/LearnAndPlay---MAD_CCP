package com.example.mad_ccp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FetchFeedback extends AppCompatActivity {
    Button btnFetch;
    ArrayAdapter feedbackAA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_feedback);
        btnFetch=findViewById(R.id.viewButton);
        ListView list = findViewById(R.id.list);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database dbHelper = new Database(FetchFeedback.this);
                List<RewardModal> display = new ArrayList<RewardModal>();

//                Toast.makeText(FetchFeedback.this, "", Toast.LENGTH_SHORT).show();

                feedbackAA = new ArrayAdapter<RewardModal>(FetchFeedback.this, android.R.layout.simple_list_item_1);
                list.setAdapter(feedbackAA);
            }
        });
    }
}