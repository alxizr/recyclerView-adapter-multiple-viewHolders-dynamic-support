package com.alxizr.recyclerviewmultipleviewholdersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.MultiRV;
import com.alxizr.recyclerviewmultipleviewholdersapp.R;
import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects.SingleItem1;
import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects.SingleItem2;
import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects.SingleItem3;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<SingleItem1> SI1AL;
    private ArrayList<SingleItem2> SI2AL;
    private ArrayList<SingleItem3> SI3AL;

    private MultiRV adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SI1AL = new ArrayList<>();
        SI2AL = new ArrayList<>();
        SI3AL = new ArrayList<>();

        for(int i=0; i < 10; i++){
            SI1AL.add(new SingleItem1());
            SI2AL.add(new SingleItem2());
            SI3AL.add(new SingleItem3());
        }//for

        ArrayList arrayList = new ArrayList();
        arrayList.addAll(SI1AL);
        arrayList.addAll(SI2AL);
        arrayList.addAll(SI3AL);
        arrayList.addAll(SI1AL);
        arrayList.addAll(SI2AL);
        arrayList.addAll(SI3AL);

        Collections.shuffle(arrayList);

        adapter = new MultiRV(this, arrayList);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setReverseLayout(false);
        recyclerView = findViewById(R.id.rv1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }//on create



}//main
