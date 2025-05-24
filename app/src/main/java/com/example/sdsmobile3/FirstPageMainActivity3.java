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

public class FirstPageMainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_page_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText nameEditText = (EditText)findViewById(R.id.nameEditText);
        TextView welcomeTextView = (TextView)findViewById(R.id.welcomeTextView);
        Button nameButton = (Button)findViewById(R.id.nameButton);
        nameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                if (!name.isEmpty()) {
                    welcomeTextView.setText("Welcome " + name + "!\nIn this application you will be calculating :)\n Click 'next' to continue.");
                } else {
                    welcomeTextView.setText("Welcome!\nIn this application you will be calculating :)\n Click 'next' to continue.");

                }
            }
        });

        Button nextpageButton2 = (Button)findViewById(R.id.nextpageButton2);
        nextpageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);

            }
        });


    }
}