package com.danielcorrea.dermapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consejos extends AppCompatActivity {
    Button atras1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);
        atras1 = (Button) findViewById(R.id.atras1);

        atras1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inten = new Intent(Consejos.this,Main.class);
                startActivity(inten);
            }
        });
    }
}
