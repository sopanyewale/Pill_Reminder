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
import com.pill.reminder.adapters.AppointmentListAdapter;
import com.pill.reminder.adapters.DoctorListAdapter;
import com.pill.reminder.interfaces.ListItemClickListener;
import com.pill.reminder.models.Appointment;
import com.pill.reminder.models.Doctor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAppointmentsActivity extends AppCompatActivity implements ListItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView appointmentsListView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    List<Appointment> appointmentList;
    AppointmentListAdapter appointmentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointments);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("View Appointments");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        appointmentList = getDummyAppointmentList();
        appointmentListAdapter = new AppointmentListAdapter(this, appointmentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        appointmentsListView.setLayoutManager(layoutManager);
        appointmentsListView.setItemAnimator(new DefaultItemAnimator());
        appointmentsListView.setAdapter(appointmentListAdapter);
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        startActivity(new Intent(this, AddAppointmentActivity.class));
    }

    private List<Appointment> getDummyAppointmentList() {
        List<Appointment> appointmentList = new ArrayList<>();
        for(int i=1; i<8; i++){
            Appointment appointment = new Appointment("User "+i, "Doctor "+i, "ENT", "18-May-2018", "11:00 AM", true, "1 Hour");
            appointmentList.add(appointment);
        }
        return appointmentList;
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(new Intent(this, AddAppointmentActivity.class).putExtra("Appointment", appointmentList.get(position)));
    }
}

