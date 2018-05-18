package com.pill.reminder.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.pill.reminder.R;
import com.pill.reminder.models.Dose;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMedicineActivity extends AppCompatActivity {

    @BindView(R.id.tb)
    Toolbar toolbar;
    @BindView(R.id.edt_medicine_title)
    EditText medicineTitle;
    @BindView(R.id.switch_status)
    Switch switchStatus;
    Dose dose = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Medicine");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Bundle b = getIntent().getExtras();
        if(b != null){
            dose = (Dose) b.get("Dose");
        }

        if(dose != null){
            medicineTitle.setText(dose.getMedicine_name());
            switchStatus.setChecked(dose.isShouldRemind());
        }
    }
}
