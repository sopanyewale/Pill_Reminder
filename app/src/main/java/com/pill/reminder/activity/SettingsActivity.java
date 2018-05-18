package com.pill.reminder.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pill.reminder.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.ll_about_us)
    LinearLayout llAboutUs;
    @BindView(R.id.ll_profile)
    LinearLayout llProfile;
    @BindView(R.id.ll_account_settings)
    LinearLayout llAccountSettings;
    @BindView(R.id.ll_app_version)
    LinearLayout llAppVersion;
    @BindView(R.id.ll_privacy_policy)
    LinearLayout llPrivacyPolicy;
    @BindView(R.id.ll_upgrade_to_premium)
    LinearLayout llUpgradeToPremium;
    @BindView(R.id.ll_faq)
    LinearLayout llFaq;
    @BindView(R.id.ll_suggest_an_idea)
    LinearLayout llSuggestAnIdea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Settings");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //getSupportFragmentManager().beginTransaction().add()
    }

    @OnClick(R.id.ll_about_us)
    public void onAboutUsClicked(){
        launchActivity(AboutUsActivity.class);
    }

    @OnClick(R.id.ll_profile)
    public void onProfileClicked(){
        launchActivity(UserProfileActivity.class);
    }

    @OnClick(R.id.ll_account_settings)
    public void onAccountSettingsClicked(){
        launchActivity(AccountSettingsActivity.class);
    }

    @OnClick(R.id.ll_app_version)
    public void onAppVersionClicked(){
        showAppVersionPopUp();
    }

    @OnClick(R.id.ll_privacy_policy)
    public void onPrivacyPolicyClicked(){
        launchActivity(PrivacyPolicyActivity.class);
    }

    @OnClick(R.id.ll_upgrade_to_premium)
    public void onUpgradePremiumClicked(){

    }

    @OnClick(R.id.ll_faq)
    public void onFaqClicked(){
        launchActivity(FaqActivity.class);
    }

    @OnClick(R.id.ll_suggest_an_idea)
    public void onSuggestIdeaClicked(){
        launchActivity(SuggestIdeaActivity.class);
    }

    public void launchActivity(java.lang.Class activity){
        startActivity(new Intent(SettingsActivity.this, activity));
    }

    public void showAppVersionPopUp(){
        String appVersion = "";
        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setCancelable(true);
        dialogBuilder.setTitle(getString(R.string.app_name));
        View view = getLayoutInflater().inflate(R.layout.view_app_version_dialog, null);
        TextView txtVersionText = view.findViewById(R.id.txt_app_version_text);
        txtVersionText.setText(" :  "+appVersion);
        dialogBuilder.setView(view);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
