package com.pill.reminder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.pill.reminder.R;
import com.pill.reminder.adapters.DoseListAdapter;
import com.pill.reminder.adapters.MedicineListAdapter;
import com.pill.reminder.models.Dose;
import com.pill.reminder.models.Medicine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<Dose> morningDoseList, afternoonDoseList, nightDoseList;
    DoseListAdapter morningDoseListAdapter, afternoonDoseListAdapter, nightDoseListAdapter;

    @BindView(R.id.rv_morning)
    RecyclerView morningListView;
    @BindView(R.id.rv_afternoon)
    RecyclerView afternoonListView;
    @BindView(R.id.rv_night)
    RecyclerView nightListView;
    @BindView(R.id.txt_morning_no_tablet_text)
    TextView txtMorningNoTabletText;
    @BindView(R.id.txt_afternoon_no_tablet_text)
    TextView txtAfternoonNoTabletText;
    @BindView(R.id.txt_night_no_tablet_text)
    TextView txtNightNoTabletText;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ButterKnife.bind(this);

        morningDoseList = new ArrayList<Dose>();
        //loop for demo
        for (int i=1; i < 4; i++){
            morningDoseList.add(new Dose("Crocin", "Pill", i, true, "8.00 AM", true, "User "+i, "2", "3" ));
        }
        afternoonDoseList = new ArrayList<Dose>();
        //loop for demo
        for (int i=1; i < 3; i++){
            afternoonDoseList.add(new Dose("Crocin", "Pill", i, true, "8.00 AM", true, "User "+i, "2", "3" ));
        }
        nightDoseList = new ArrayList<Dose>();
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getApplicationContext());
        morningDoseListAdapter = new DoseListAdapter(this, morningDoseList);
        afternoonDoseListAdapter = new DoseListAdapter(this, afternoonDoseList);
        nightDoseListAdapter = new DoseListAdapter(this, nightDoseList);

        morningListView.setLayoutManager(layoutManager1);
        morningListView.setItemAnimator(new DefaultItemAnimator());
        morningListView.setAdapter(morningDoseListAdapter);

        if(morningDoseList.size() > 0) {
            morningListView.setVisibility(View.VISIBLE);
            txtMorningNoTabletText.setVisibility(View.GONE);
        }else{
            morningListView.setVisibility(View.GONE);
            txtMorningNoTabletText.setVisibility(View.VISIBLE);
        }

        afternoonListView.setLayoutManager(layoutManager2);
        afternoonListView.setItemAnimator(new DefaultItemAnimator());
        afternoonListView.setAdapter(afternoonDoseListAdapter);

        if(afternoonDoseList.size() > 0) {
            afternoonListView.setVisibility(View.VISIBLE);
            txtAfternoonNoTabletText.setVisibility(View.GONE);

        }else{
            afternoonListView.setVisibility(View.GONE);
            txtAfternoonNoTabletText.setVisibility(View.VISIBLE);
        }

        nightListView.setLayoutManager(layoutManager3);
        nightListView.setItemAnimator(new DefaultItemAnimator());
        nightListView.setAdapter(nightDoseListAdapter);

        if(nightDoseList.size() > 0) {
            nightListView.setVisibility(View.VISIBLE);
            txtNightNoTabletText.setVisibility(View.GONE);

        }else{
            nightListView.setVisibility(View.GONE);
            txtNightNoTabletText.setVisibility(View.VISIBLE);
        }


        //SpinnerAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.users, R.layout.user_spinner_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.user_spinner_item, getResources().getStringArray(R.array.users));
        adapter.setDropDownViewResource(R.layout.user_spinner_dropdown_item);
        final Spinner navigationSpinner = new Spinner(getSupportActionBar().getThemedContext());

        navigationSpinner.setAdapter(adapter);
        toolbar.addView(navigationSpinner, 0);

        navigationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Selected " + navigationSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(MainActivity.this, AddMedicineActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

        int id = item.getItemId();
        switch (id) {
            case R.id.nav_users:
                startActivity(new Intent(MainActivity.this, ViewUsersActivity.class));
                break;
            case R.id.nav_today:
                break;
            case R.id.nav_dosage:
                startActivity(new Intent(MainActivity.this, ViewMedicinesActivity.class));
                break;
            case R.id.nav_appointments:
                startActivity(new Intent(MainActivity.this, ViewAppointmentsActivity.class));
                break;
            case R.id.nav_doctors:
                startActivity(new Intent(MainActivity.this, ViewDoctorActivity.class));
                break;
            case R.id.nav_measurements:
                startActivity(new Intent(MainActivity.this, ViewMeasurementActivity.class));
                break;
            case R.id.nav_settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;
            case R.id.nav_rate_us:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigationView.setCheckedItem(R.id.nav_today);
    }
}
