package com.pill.reminder.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.pill.reminder.R;
import com.pill.reminder.models.Appointment;
import com.pill.reminder.models.Dose;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class AddAppointmentActivity extends AppCompatActivity {

    @BindView(R.id.tb)
    Toolbar toolbar;
    @BindView(R.id.spn_user)
    Spinner spnUser;
    @BindView(R.id.spn_doctor)
    Spinner spnDoctor;
    @BindView(R.id.spn_reminder)
    Spinner spnReminder;
    @BindView(R.id.switch_reminder)
    Switch switchReminder;
    @BindView(R.id.edt_speciality)
    EditText edtSpeciality;
    @BindView(R.id.edt_datetime)
    EditText edtDateTime;

    Appointment appointment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Appointment");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Bundle b = getIntent().getExtras();
        if(b != null){
            appointment = (Appointment) b.get("Appointment");
        }

        if(appointment != null){
            edtSpeciality.setText(appointment.getDoctorSpeciality());
            edtDateTime.setText(appointment.getDate()+" "+appointment.getTime());
        }

        spnDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //change value of speciality based on selected doctor
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        switchReminder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    spnReminder.setVisibility(View.VISIBLE);
                else
                    spnReminder.setVisibility(View.GONE);
            }
        });
    }


}
