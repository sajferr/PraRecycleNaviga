package com.example.m.prarecyclenaviga;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBarDrawerToggle toogle;
    String[] strings;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    RecyclerView.Adapter adapter;
    ArrayList<String> arrayList = new ArrayList<String>();
    RecyclerView.LayoutManager maanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        strings = getResources().getStringArray(R.array.tematy);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        maanager = new LinearLayoutManager(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toogle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        recyclerView.setLayoutManager(maanager);
        for (String name : strings) {
            arrayList.add(name);

        }

        RecyclerVievAdapter adapter = new RecyclerVievAdapter(arrayList, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 1) {
                    Toast.makeText(getApplicationContext(), "siema stary", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        drawerLayout.addDrawerListener(toogle);
    }


    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toogle.syncState();
    }




}





