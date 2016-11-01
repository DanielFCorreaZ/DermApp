package com.danielcorrea.dermapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ValpreFragment extends Fragment {
    public ValpreFragment(int a) {
        this.a = a;
    }

    public ValpreFragment() {
        // Required empty public constructor
    }
int a=1;
    TextView valo;
    Button empe;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflatedView = inflater.inflate(R.layout.fragment_valpre, container, false);

        valo=(TextView) myInflatedView.findViewById(R.id.valor);
        empe=(Button) myInflatedView.findViewById(R.id.empe);

        switch (a){
            case(1):valo.setText(R.string.valor1);
                break;
            case(2):valo.setText(R.string.valorasi2);
                break;
            case(3):valo.setText(R.string.valor3);
                break;
        }

        empe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                switch (a){
                    case(1):// Intent intent = new Intent(getActivity(), Main.class);
                       // ValpreFragment.this.startActivity(intent);
                        break;
                    case(2): Intent intent1 = new Intent(getActivity(), ValBraden.class);
                        ValpreFragment.this.startActivity(intent1);
                        break;
                    case(3):// Intent intent2 = new Intent(getActivity(), Clasificacion.class);
                       // ValpreFragment.this.startActivity(intent2);
                        break;
                }


            }
        });


        return myInflatedView;
    }

}
