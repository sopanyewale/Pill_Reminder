package com.pill.reminder.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pill.reminder.R;
import com.pill.reminder.adapters.DoctorListAdapter;
import com.pill.reminder.adapters.MedicineListAdapter;
import com.pill.reminder.interfaces.ListItemClickListener;
import com.pill.reminder.models.Doctor;
import com.pill.reminder.models.Dose;
import com.pill.reminder.models.Medicine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewMedicinesActivity extends AppCompatActivity implements ListItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView medicinesListView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    List<Dose> medicineList;
    MedicineListAdapter MedicineListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_medicines);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("View Medicines");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        medicineList = getDummyMedicineList();
        MedicineListAdapter = new MedicineListAdapter(this, medicineList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        medicinesListView.setLayoutManager(layoutManager);
        medicinesListView.setItemAnimator(new DefaultItemAnimator());
        medicinesListView.setAdapter(MedicineListAdapter);
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        startActivity(new Intent(this, AddMedicineActivity.class));
    }

    public List<Dose> getDummyMedicineList(){
        List<Dose> medicineList = new ArrayList<>();
        for (int i = 1; i < 4; i++){
            Dose dose = new Dose("Crocin "+i,"" ,2, true, "9.00 AM", true, "User "+1, "", "" );
            medicineList.add(dose);
        }
        return medicineList;
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(new Intent(this, AddMedicineActivity.class).putExtra("Dose", medicineList.get(position)));
    }
}
