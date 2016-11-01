package com.danielcorrea.dermapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {
    Button atras;
    LinearLayout lau;
    TextView descrip;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();
        atras = (Button) findViewById(R.id.atras);
        lau= (LinearLayout) findViewById(R.id.lau);
        descrip = (TextView) findViewById(R.id.pDes);

        switch (prefs.getInt("val",-1)){
            case(0):break;
            case(5):lau.setBackgroundResource(R.drawable.nombre2);
                descrip.setText(R.string.infocon);
                break;
        }

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inten = new Intent(Informacion.this,Main.class);
                startActivity(inten);
            }
        });


    }
}
