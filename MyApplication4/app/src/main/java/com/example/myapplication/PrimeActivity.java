package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class PrimeActivity extends AppCompatActivity {
private TextView textView,textViewResult;
int a,l,r,password;
private Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        textView=findViewById(R.id.editText);
        textViewResult=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        Random random=new Random();
        l=1;
        r=99;
        password=random.nextInt(97);
        password+=2;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int a=Integer.parseInt(textView.getText().toString());



                if(a<password)
                    l=a;
                else r=a;

                String result=("please enter in range of "+l+" and "+r);
                if(a==password){
                    result="You win";
                }
                textViewResult.setText(result);

            }
        });
    }

}
