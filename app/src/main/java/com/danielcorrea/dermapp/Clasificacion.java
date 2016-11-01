package com.danielcorrea.dermapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Clasificacion extends AppCompatActivity {


    int cali=0;
    TextView most;
    ImageView est1,est2,est3,est4,est5;
    Button uno,up,down;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private String[] opciones ;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();
        opciones = new String[] {getText(R.string.main).toString(),getText(R.string.main1).toString(),getText(R.string.main2).toString(),getText(R.string.main3).toString(),
                getText(R.string.main4).toString()};
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal2);
        listView = (ListView) findViewById(R.id.menuIzq2);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Fragment fragment = null;
                switch (i) {
                    case (0): //fragment = new SupermanFragment();
                        Intent intent2 = new Intent(Clasificacion.this, Main.class);


                        startActivity(intent2);

                        break;
                    case (1): //fragment = new BatmanFragment();
                        Intent intent = new Intent(Clasificacion.this, Perfil.class);

                        startActivity(intent);
                        break;

                    case (2): Intent intent1 = new Intent(Clasificacion.this, Valopre.class);

                        startActivity(intent1);

                        break;
                    case (3):
                        break;
                    case (4):
                        Intent intent3 = new Intent(Clasificacion.this, Loggin.class);
                        editor.putInt("var", -1);
                        editor.commit();

                        startActivity(intent3);
                        finish();
                        break;
                }
                if (i != 3) {
                    // FragmentManager fragmentManager = getSupportFragmentManager();
                    // fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

                }
                listView.setItemChecked(i, true);
                drawerLayout.closeDrawer(listView);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.abierto, R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);


        most = (TextView) findViewById(R.id.casi3);
        uno = (Button) findViewById(R.id.calis);
        est1 = (ImageView) findViewById(R.id.est1);
        est2 = (ImageView) findViewById(R.id.est2);
        est3 = (ImageView) findViewById(R.id.est3);
        est4 = (ImageView) findViewById(R.id.est4);
        est5 = (ImageView) findViewById(R.id.est5);

        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        est5.setImageResource(R.drawable.empty);
        est4.setImageResource(R.drawable.empty);
        est3.setImageResource(R.drawable.empty);
        est2.setImageResource(R.drawable.empty);
        est1.setImageResource(R.drawable.empty);

        most.setVisibility(View.INVISIBLE);

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    most.setVisibility(View.VISIBLE);


            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (cali){
                    case(0):cali++;
                        est1.setImageResource(R.drawable.half);
                        break;
                    case(1):cali++;
                        est1.setImageResource(R.drawable.full);
                        break;
                    case(2):cali++;
                        est2.setImageResource(R.drawable.half);
                        break;
                    case(3):cali++;
                        est2.setImageResource(R.drawable.full);
                        break;
                    case(4):cali++;
                        est3.setImageResource(R.drawable.half);
                        break;
                    case(5):cali++;
                        est3.setImageResource(R.drawable.full);
                        break;
                    case(6):cali++;
                        est4.setImageResource(R.drawable.half);
                        break;
                    case(7):cali++;
                        est4.setImageResource(R.drawable.full);
                        break;
                    case(8):cali++;
                        est5.setImageResource(R.drawable.half);
                        break;
                    case(9):cali++;
                        est5.setImageResource(R.drawable.full);
                        break;
                    case(10):break;

                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (cali){
                    case(10):cali--;
                        est5.setImageResource(R.drawable.half);
                        break;
                    case(9):cali--;
                        est5.setImageResource(R.drawable.empty);
                        break;
                    case(8):cali--;
                        est4.setImageResource(R.drawable.half);
                        break;
                    case(7):cali--;
                        est4.setImageResource(R.drawable.empty);
                        break;
                    case(6):cali--;
                        est3.setImageResource(R.drawable.half);
                        break;
                    case(5):cali--;
                        est3.setImageResource(R.drawable.empty);
                        break;
                    case(4):cali--;
                        est2.setImageResource(R.drawable.half);
                        break;
                    case(3):cali--;
                        est2.setImageResource(R.drawable.empty);
                        break;
                    case(2):cali--;
                        est1.setImageResource(R.drawable.half);
                        break;
                    case(1):cali--;
                        est1.setImageResource(R.drawable.empty);
                        break;
                    case(0):break;
                }
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.LEFT);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
