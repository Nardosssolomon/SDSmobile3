package com.example.sdsmobile3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> historyList = new ArrayList<>();  // Historia tallennetaan tähän

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String name = getIntent().getStringExtra("username");
        TextView greetingTextView = findViewById(R.id.greetingTextView);
        if (name != null && !name.isEmpty()) {
            greetingTextView.setText("Hello " + name + "!");
        }

        Button addButton = (Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText)findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText)findViewById(R.id.secondNumEditText);
                TextView ResultTextView = (TextView)findViewById(R.id.ResultTextView);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;

                ResultTextView.setText(result + "");
                historyList.add(num1 + " + " + num2 + " = " + result);

                // Antaa värit luvuille
                if (result > 0) {
                    ResultTextView.setTextColor(Color.GREEN);// jos pos, väri vihreä
                } else if (result < 0) {
                    ResultTextView.setTextColor(Color.RED);// jos neg, väri punainen
                } else {
                    ResultTextView.setTextColor(Color.BLACK);
                }
            }
        });

        Button minusButton = (Button)findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView ResultTextView = (TextView) findViewById(R.id.ResultTextView);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 - num2;

                ResultTextView.setText(result + "");
                historyList.add(num1 + " - " + num2 + " = " + result);

                // Antaa värit luvuille
                if (result > 0) {
                    ResultTextView.setTextColor(Color.GREEN);// jos pos, väri vihreä
                } else if (result < 0) {
                    ResultTextView.setTextColor(Color.RED);// jos neg, väri punainen
                } else {
                    ResultTextView.setTextColor(Color.BLACK);
                }
            }
        });

        Button multiButton = (Button)findViewById(R.id.multiButton);
        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText)findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText)findViewById(R.id.secondNumEditText);
                TextView ResultTextView = (TextView)findViewById(R.id.ResultTextView);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 * num2;

                ResultTextView.setText(result + "");
                historyList.add(num1 + " * " + num2 + " = " + result);
                // Antaa värit luvuille
                if (result > 0) {
                    ResultTextView.setTextColor(Color.GREEN);// jos pos, väri vihreä
                } else if (result < 0) {
                    ResultTextView.setTextColor(Color.RED);// jos neg, väri punainen
                } else {
                    ResultTextView.setTextColor(Color.BLACK);
                }
            }
        });

        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText)findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText)findViewById(R.id.secondNumEditText);
                TextView ResultTextView = (TextView)findViewById(R.id.ResultTextView);

                double num1 = Double.parseDouble(firstNumEditText.getText().toString());
                double num2 = Double.parseDouble(secondNumEditText.getText().toString());

                if (num2 != 0) {
                    double result = num1 / num2;
                    ResultTextView.setText(String.valueOf(result));
                    historyList.add(num1 + " / " + num2 + " = " + result);
                    // Antaa värit luvuille
                    if (result > 0) {
                        ResultTextView.setTextColor(Color.GREEN);// jos pos, väri vihreä
                    } else if (result < 0) {
                        ResultTextView.setTextColor(Color.RED);// jos neg, väri punainen
                    } else {
                        ResultTextView.setTextColor(Color.BLACK);
                    }
                } else {
                    ResultTextView.setText("Error: divide by 0");
                    historyList.add(num1 + " / " + num2 + " = " + " = Error: divide by 0");
                }
            }
        });


        Button NextPageButton = (Button)findViewById(R.id.NextPageButton);
        NextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity2.class);
                startIntent.putStringArrayListExtra("history", historyList);  // siirretään historia
                //käytin apuna tämän ymmärtämiseen AI sekä tätä sivustoa https://stackoverflow.com/questions/4030115/how-to-pass-arraylist-using-putstringarraylistextra
                startActivity(startIntent);
            }
        });

        Button BackButton2 = (Button)findViewById(R.id.BackButton2);
        BackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), FirstPageMainActivity3.class);
                startActivity(startIntent);
            }
        });



    }
}