package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ab,gcd,range,prime ;
    private Button[] buttons={range,prime};
Class[] content={RangeActivity.class,PrimeActivity.class};
int [] parms={R.id.range,R.id.prime};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       range=findViewById(R.id.range);
       prime=findViewById(R.id.prime);
       ab=findViewById(R.id.ab);
       gcd=findViewById(R.id.gcd);
       range.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,RangeActivity.class);
               startActivity(intent);
               finish();
           }
       });
       gcd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,GcdActivity.class);
               startActivity(intent);
               finish();
           }
       });
        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PrimeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AbActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}
