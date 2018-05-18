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
import com.pill.reminder.adapters.UserListAdapter;
import com.pill.reminder.interfaces.ListItemClickListener;
import com.pill.reminder.models.Doctor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDoctorActivity extends AppCompatActivity implements ListItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView doctorListView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    List<Doctor> doctorList;
    DoctorListAdapter doctorListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("View Doctors");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        doctorList = getDummyDoctorList();
        doctorListAdapter = new DoctorListAdapter(this, doctorList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        doctorListView.setLayoutManager(layoutManager);
        doctorListView.setItemAnimator(new DefaultItemAnimator());
        doctorListView.setAdapter(doctorListAdapter);
    }

    private List<Doctor> getDummyDoctorList() {
        List<Doctor> doctorList = new ArrayList<>();
        for(int i = 1; i < 5; i++){
            Doctor doctor = new Doctor("Doctor "+i, 1234567890L, "ENT", "Pune", "Maharashtra", "doctor@hospital.com");
            doctorList.add(doctor);
        }
        return doctorList;
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        startActivity(new Intent(this, AddDoctorActivity.class));
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(new Intent(this, AddDoctorActivity.class).putExtra("Doctor", doctorList.get(position)));
    }
}
