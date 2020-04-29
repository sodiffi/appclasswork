package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView editText;
    LinearLayout linearLayout;
    Random random = new Random();
    private LinearLayout.LayoutParams params;
    List<Integer> con = new ArrayList<>(), player;
    Toast toast;
    int a = 0, b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con.add(random.nextInt(9) + 1);
        for (int i = 1; i < 4; i++) {
            int temp = random.nextInt(10);

            if (con.indexOf(temp) == -1) {
                con.add(temp);
            } else {
                i--;
            }
        }

        for (int i : con) {
            System.out.print(i + "\t");
        }
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
        params.setMargins(0, 1, 0, 1);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        toast = new Toast(editText.getContext());
        linearLayout = findViewById(R.id.linerLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player = new ArrayList<>();
                String input = editText.getText().toString();
                String[] inputArray = input.split("");
                boolean check = true;
                if (input.length() == 4) {
                    try {
                        for (int i = 0; i < 4; i++) {
                            int temp = Integer.parseInt(inputArray[i]);
                            if (i != 0) {
                                if (player.indexOf(temp) != -1) {
                                    System.out.println("enter fore Not repeating number");
                                    toastHelper("enter fore Not repeating number");
                                    check = false;
                                    break;
                                }
                            } else {
                                if (temp == 0) {
                                    check = false;
                                    System.out.println("first number can't be zero");
                                    toastHelper("first number can't be zero");
                                    break;
                                }
                            }
                            player.add(temp);
                        }
                        if (check) {

                            for (int i = 0; i < 4; i++) {
                                int tocheck = con.indexOf(player.get(i));
                                if (tocheck != -1) {
                                    if (tocheck == i) {
                                        a++;
                                    } else {
                                        b++;
                                    }
                                }
                            }
                            if (a == 4) {
                                System.out.println("You Win");
                                addTextView("You Win");
                            } else {
                                System.out.printf("%d A\t%d B\nplease enter for no repeating number\n", a, b);
                                addTextView(String.format(input + "\t%d A\t%d B\n", a, b));
                                a = 0;
                                b = 0;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("enter fore number");
                        toastHelper("enter fore number");
                    }

                } else {
                    System.out.println("enter fore number");
                    toastHelper("enter fore number");
                }
                editText.setText("");
            }

        });
    }

    public void addTextView(String result) {
        TextView text = new TextView(linearLayout.getContext());
        text.setText(result);
        text.setTextSize(18);
        text.setGravity(Gravity.CENTER);
       // text.setLayoutParams(params);
        linearLayout.addView(text);

    }

    public void toastHelper(String info) {
       toast= Toast.makeText(editText.getContext(), info, Toast.LENGTH_LONG);

        toast.show();
    }
}
