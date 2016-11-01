package com.danielcorrea.dermapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValBraden extends AppCompatActivity {

    RadioButton radio01,radio11,radio21,radio31;
    RadioButton radio02,radio12,radio22,radio32;
    RadioButton radio03,radio13,radio23,radio33;
    RadioButton radio04,radio14,radio24,radio34;
    RadioButton radio05,radio15,radio25;
    RadioButton radio06,radio16,radio26,radio36;
Button guia,calcu;

    EditText nomb, eda;
    int aux1=0,aux2=0,aux3=0,aux4=0,aux5=0,aux6=0,fin=0,l;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String currentTimeStamp, nombre, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_val_braden);
        radio01 = (RadioButton) findViewById(R.id.radio01);
        radio11 = (RadioButton) findViewById(R.id.radio11);
        radio21 = (RadioButton) findViewById(R.id.radio21);
        radio31 = (RadioButton) findViewById(R.id.radio31);

        radio02 = (RadioButton) findViewById(R.id.radio02);
        radio12 = (RadioButton) findViewById(R.id.radio12);
        radio22 = (RadioButton) findViewById(R.id.radio22);
        radio32 = (RadioButton) findViewById(R.id.radio32);

        radio03 = (RadioButton) findViewById(R.id.radio03);
        radio13 = (RadioButton) findViewById(R.id.radio13);
        radio23 = (RadioButton) findViewById(R.id.radio23);
        radio33 = (RadioButton) findViewById(R.id.radio33);

        radio04 = (RadioButton) findViewById(R.id.radio04);
        radio14 = (RadioButton) findViewById(R.id.radio14);
        radio24 = (RadioButton) findViewById(R.id.radio24);
        radio34 = (RadioButton) findViewById(R.id.radio34);

        radio05 = (RadioButton) findViewById(R.id.radio05);
        radio15 = (RadioButton) findViewById(R.id.radio15);
        radio25 = (RadioButton) findViewById(R.id.radio25);


        radio06 = (RadioButton) findViewById(R.id.radio06);
        radio16 = (RadioButton) findViewById(R.id.radio16);
        radio26 = (RadioButton) findViewById(R.id.radio26);
        radio36 = (RadioButton) findViewById(R.id.radio36);

        guia = (Button) findViewById(R.id.guias);

        nomb = (EditText) findViewById(R.id.nomval);
        eda = (EditText) findViewById(R.id.edadval);

        calcu = (Button) findViewById(R.id.calcu);
        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();





        guia.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                Intent intent1= new Intent(ValBraden.this, Guia.class);
                startActivity(intent1);


            }
        });

        calcu.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                nombre=nomb.getText().toString();
                edad=eda.getText().toString();
                if(TextUtils.isEmpty(nombre)) {
                    Toast.makeText(getApplicationContext(), R.string.calcu1 ,Toast.LENGTH_SHORT).show();
                }else{if(TextUtils.isEmpty(edad)) {
                    Toast.makeText(getApplicationContext(), R.string.calcu2 ,Toast.LENGTH_SHORT).show();
                }else{
                if (aux1==0||aux2==0||aux3==0||aux4==0||aux5==0||aux6==0){
                    Toast.makeText(getApplicationContext(), R.string.val1 ,Toast.LENGTH_SHORT).show();

                }else {


                    l=Integer.parseInt(edad);

                    fin=aux1+aux2+aux3+aux4+aux5+aux6;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    currentTimeStamp = dateFormat.format(new Date());

                    editor.putInt("result",fin);
                    editor.putInt("edad",l);
                    editor.putString("nombresito",nombre);
                    editor.putString("fecha", currentTimeStamp);
                    editor.commit();
                    Intent intent1 = new Intent(ValBraden.this,ResultadoBraden.class);
                    startActivity(intent1);
                }

            }}}
        });



    }



    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio01:
                if (marcado) {
                    aux1 = 1;
                }
                break;
            case R.id.radio11:
                if (marcado) {
                    aux1 = 2;
                }
                break;
            case R.id.radio21:
                if (marcado) {
                    aux1 = 3;
                }
                break;
            case R.id.radio31:
                if (marcado) {
                    aux1 = 4;
                }
                break;


            case R.id.radio02:
                if (marcado) {
                    aux2 = 1;
                }
                break;
            case R.id.radio12:
                if (marcado) {
                    aux2 = 2;
                }
                break;
            case R.id.radio22:
                if (marcado) {
                    aux2 = 3;
                }
                break;
            case R.id.radio32:
                if (marcado) {
                    aux2 = 4;
                }
                break;

            case R.id.radio03:
                if (marcado) {
                    aux3 = 1;
                }
                break;
            case R.id.radio13:
                if (marcado) {
                    aux3 = 2;
                }
                break;
            case R.id.radio23:
                if (marcado) {
                    aux3 = 3;
                }
                break;
            case R.id.radio33:
                if (marcado) {
                    aux3 = 4;
                }
                break;

            case R.id.radio04:
                if (marcado) {
                    aux4 = 1;
                }
                break;
            case R.id.radio14:
                if (marcado) {
                    aux4 = 2;
                }
                break;
            case R.id.radio24:
                if (marcado) {
                    aux4 = 3;
                }
                break;
            case R.id.radio34:
                if (marcado) {
                    aux4 = 4;
                }
                break;

            case R.id.radio05:
                if (marcado) {
                    aux5 = 1;
                }
                break;
            case R.id.radio15:
                if (marcado) {
                    aux5 = 2;
                }
                break;
            case R.id.radio25:
                if (marcado) {
                    aux5 = 3;
                }
                break;


            case R.id.radio06:
                if (marcado) {
                    aux6 = 1;
                }
                break;
            case R.id.radio16:
                if (marcado) {
                    aux6 = 2;
                }
                break;
            case R.id.radio26:
                if (marcado) {
                    aux6 = 3;
                }
                break;
            case R.id.radio36:
                if (marcado) {
                    aux6 = 4;
                }
                break;


        }
    }

}
