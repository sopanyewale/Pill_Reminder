package com.pill.reminder.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.pill.reminder.R;
import com.pill.reminder.models.Measurement;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMeasurementActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_value)
    EditText edtValue;
    Measurement measurement = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_measurement);
        ButterKnife.bind(this);

        Bundle b = getIntent().getExtras();
        if(b != null){
            measurement = (Measurement) b.get("Measurement");
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Measurement");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if(measurement != null){
            edtValue.setText(measurement.getValue()+"");
        }
    }
}
