package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PrimeActivity extends AppCompatActivity {
    private TextView textView, textViewResult;

    private Button button, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        textView = findViewById(R.id.editText);
        textViewResult = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrimeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(textView.getText().toString());
                int count = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                    if (count > 2) {
                        break;
                    }
                }
                if (count == 2) {
                   textViewResult.setText(i + " is prime");
                } else {
                    textViewResult.setText(i + " is not prime");
                }

            }
        });
    }

}
