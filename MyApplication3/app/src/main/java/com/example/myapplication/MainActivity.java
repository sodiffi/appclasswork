package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewa,textViewb,textViewResult;
    private Button button;
    int a ,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewa=findViewById(R.id.editText);
        textViewb=findViewById(R.id.editText2);
        textViewResult=findViewById(R.id.result);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               a=Integer.parseInt(textViewa.getText().toString());
                b=Integer.parseInt(textViewb.getText().toString());
                c=a%b;
                while(c!=0){
                    a=b;b=c;c=a%b;
                }
                textViewResult.setText("GCD is "+b);
            }
        });
    }
}
