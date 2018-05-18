package com.pill.reminder.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.pill.reminder.R;
import com.pill.reminder.models.Doctor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddDoctorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_doctor_name)
    EditText edtDoctorName;
    @BindView(R.id.edt_contact_number)
    EditText edtContactNo;
    @BindView(R.id.edt_speciality)
    EditText edtSpeciality;
    @BindView(R.id.edt_address1)
    EditText edtAddress1;
    @BindView(R.id.edt_address2)
    EditText edtAddress2;
    @BindView(R.id.edt_email)
    EditText edtEmail;

    Doctor doctor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);
        ButterKnife.bind(this);

        Bundle b = getIntent().getExtras();
        if(b != null){
            doctor = (Doctor) b.get("Doctor");
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Doctor's Details");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if(doctor != null){
            edtDoctorName.setText(doctor.getName());
            edtContactNo.setText(doctor.getContactNumber()+"");
            edtAddress1.setText(doctor.getAddress1());
            edtAddress2.setText(doctor.getAddress2());
            edtSpeciality.setText(doctor.getSpeciality());
            edtEmail.setText(doctor.getEmail());
        }
    }
}
