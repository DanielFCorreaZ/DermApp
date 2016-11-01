package com.danielcorrea.dermapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BradenFragment extends Fragment {

    public BradenFragment(int a) {
        this.a = a;
    }

    public BradenFragment() {
        // Required empty public constructor
    }
    TextView braden;
    ImageView brad1,brad2,brad3,brad4,brad5,brad6,brad7,brad8,brad9,brad10,brad11,brad12,brad15;
int a;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myInflatedView = inflater.inflate(R.layout.fragment_braden, container, false);

        braden=(TextView) myInflatedView.findViewById(R.id.bradentext);
        brad1=(ImageView) myInflatedView.findViewById(R.id.bradenima1);
        brad2=(ImageView) myInflatedView.findViewById(R.id.bradenima2);
        brad3=(ImageView) myInflatedView.findViewById(R.id.bradenima3);
        brad4=(ImageView) myInflatedView.findViewById(R.id.bradenima4);
        brad5=(ImageView) myInflatedView.findViewById(R.id.bradenima5);
        brad6=(ImageView) myInflatedView.findViewById(R.id.bradenima6);
        brad7=(ImageView) myInflatedView.findViewById(R.id.bradenima7);
        brad8=(ImageView) myInflatedView.findViewById(R.id.bradenima8);
        brad9=(ImageView) myInflatedView.findViewById(R.id.bradenima9);
        brad10=(ImageView) myInflatedView.findViewById(R.id.bradenima10);
        brad11=(ImageView) myInflatedView.findViewById(R.id.bradenima11);
        brad12=(ImageView) myInflatedView.findViewById(R.id.bradenima12);
        brad15=(ImageView) myInflatedView.findViewById(R.id.bradenima15);

        if (a==1) {

            brad3.setVisibility(View.INVISIBLE);
            brad4.setVisibility(View.INVISIBLE);
            brad5.setVisibility(View.INVISIBLE);
            brad6.setVisibility(View.INVISIBLE);
            brad7.setVisibility(View.INVISIBLE);
            brad8.setVisibility(View.INVISIBLE);
            brad9.setVisibility(View.INVISIBLE);
            brad10.setVisibility(View.INVISIBLE);
            brad11.setVisibility(View.INVISIBLE);
            brad12.setVisibility(View.INVISIBLE);
            brad15.setVisibility(View.INVISIBLE);

        }else {
            braden.setText(R.string.valorax2);
            brad1.setImageResource(R.drawable.braden13_opt);
            brad2.setImageResource(R.drawable.braden14_opt);
        }





        // Inflate the layout for this fragment
        return myInflatedView;
    }

}
