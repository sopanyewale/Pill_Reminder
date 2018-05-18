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
import com.pill.reminder.adapters.MeasurementListAdapter;
import com.pill.reminder.interfaces.ListItemClickListener;
import com.pill.reminder.models.Doctor;
import com.pill.reminder.models.Measurement;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewMeasurementActivity extends AppCompatActivity implements ListItemClickListener{

    @BindView(R.id.recyclerview)
    RecyclerView measurementListView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    List<Measurement> measurementList;
    MeasurementListAdapter measurementListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_measurement);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("View Measurement");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        measurementList = getDummyMeasurementList();
        measurementListAdapter = new MeasurementListAdapter(this, measurementList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        measurementListView.setLayoutManager(layoutManager);
        measurementListView.setItemAnimator(new DefaultItemAnimator());
        measurementListView.setAdapter(measurementListAdapter);
    }

    private List<Measurement> getDummyMeasurementList() {
        List<Measurement> measurementList = new ArrayList<>();
        for(int i = 1; i < 11; i++){
            Measurement measurement = new Measurement(65+i, "Weight", "Kg", "12-Dec-2017 12:00 PM");
            measurementList.add(measurement);
        }
        return measurementList;
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        startActivity(new Intent(this, AddMeasurementActivity.class));
    }

    @Override
    public void onItemClicked(int position) {
        startActivity(new Intent(this, AddMeasurementActivity.class).putExtra("Measurement", measurementList.get(position)));
    }
}
