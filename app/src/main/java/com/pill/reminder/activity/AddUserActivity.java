package com.pill.reminder.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.pill.reminder.R;
import com.pill.reminder.models.User;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddUserActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edt_user_name)
    EditText edtUserName;
    @BindView(R.id.spn_gender)
    Spinner spnGender;
    @BindView(R.id.edt_dob)
    EditText edtUserDob;

    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            user = (User) bundle.get("User");
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add User");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if(user != null){
            edtUserName.setText(user.getUserName());
            edtUserDob.setText(user.getDateOfBirth());
            spnGender.setSelection(user.getGender().ordinal());
            getSupportActionBar().setTitle("Update User");
        }
    }
}
