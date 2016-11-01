package com.danielcorrea.dermapp;

import android.content.ContentValues;
import android.content.res.Resources;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.R.string;
public class Main extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    ContentValues dataBD;
    SQLiteDatabase dbContactos,dbProductos;
    Productos[] datos;



    ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs=getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor=prefs.edit();


         String[] opciones =  getResources().getStringArray(R.array.posiciones);


         datos=
                new Productos[]{
                        new Productos(R.drawable.logo1,getText(R.string.ayuda2).toString(),getText(R.string.ayuda).toString(),getText(R.string.ayuda1).toString()),
                        new Productos(R.drawable.consejos_opt,getText(R.string.main6).toString(),getText(R.string.main7).toString(),getText(R.string.main8).toString()),
                        new Productos(R.drawable.vlo_opt,getText(R.string.ayuda2).toString(),getText(R.string.main9).toString(),getText(R.string.main10).toString()),
                        new Productos(R.drawable.lupa_opt,getText(R.string.main11).toString(),getText(R.string.main12).toString(),getText(R.string.main13).toString()),
                        new Productos(R.drawable.cuid_opt,getText(R.string.main6).toString(),getText(R.string.main14).toString(),getText(R.string.main15).toString()),
                        new Productos(R.drawable.cont_opt,getText(R.string.main16).toString(),getText(R.string.main17).toString(),getText(R.string.main18).toString()),

                };


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
                android.R.layout.simple_list_item_1, opciones));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case(0):

                        break;
                    case(1):
                         Intent intent= new Intent(Main.this, Perfil.class);
                         startActivity(intent);
                        break;
                    case(2):
                        Intent intent1= new Intent(Main.this, Valopre.class);
                        startActivity(intent1);
                        break;
                    case(3):
                        Intent intent2= new Intent(Main.this, Clasificacion.class);
                         startActivity(intent2);

                        break;
                    case(4):
                        Intent intent3= new Intent(Main.this, Loggin.class);
                        editor.putInt("var",-1);
                        editor.commit();
                        startActivity(intent3);
                        finish();
                        break;
                }
                if (i != 3) {
                    // FragmentManager fragmentManager = getSupportFragmentManager();
                    // fragmentManager.beginTransaction().replace(R.id.contenedorFrame, fragment).commit();

                }
                listView.setItemChecked(i,true);
                drawerLayout.closeDrawer(listView);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.abierto, R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);








        Adapter adaptador = new Adapter(this,datos);
        list= (ListView) findViewById(R.id.list);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case(0):editor.putInt("val",0);
                        Intent intent4= new Intent(Main.this, Informacion.class);
                        startActivity(intent4);
                        break;
                    case(1):
                        Intent intent6= new Intent(Main.this, Consejos.class);
                        startActivity(intent6);

                        break;
                    case(2):editor.putInt("val",2);
                        Intent intent7= new Intent(Main.this, Aseguir.class);
                        startActivity(intent7);
                        break;
                    case(3):editor.putInt("val",3);
                        Intent intent81= new Intent(Main.this, Guia.class);
                        startActivity(intent81);

                        break;
                    case(4):editor.putInt("val",4);
                        Intent intent8= new Intent(Main.this, Aseguir.class);
                        startActivity(intent8);
                        break;
                    case(5):editor.putInt("val",5);
                        Intent intent5= new Intent(Main.this, Informacion.class);
                        startActivity(intent5);
                        break;

                } editor.commit();
               // Intent intent4= new Intent(Main.this, prom.class);
               // startActivity(intent4);

            }
        });
    }


    class Adapter extends ArrayAdapter<Productos>{

        public Adapter(Context context,Productos[] datos) {
            super(context,R.layout.layout_item,datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater= LayoutInflater.from(getContext());
            View item= inflater.inflate(R.layout.layout_item,null);



            TextView nombre=(TextView) item.findViewById(R.id.nompro);
            nombre.setText(datos[position].getNombre());

            TextView descrip=(TextView) item.findViewById(R.id.descpro);
            descrip.setText(datos[position].getDescripcion());

            TextView prec=(TextView) item.findViewById(R.id.prepro);
            prec.setText(datos[position].getPrecio());


            ImageView imagen=(ImageView) item.findViewById(R.id.imapro);
            imagen.setImageResource(datos[position].getIdima());


            return (item);
        }
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
