package com.hackindroid.kyoto.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hackindroid.kyoto.R;
import com.hackindroid.kyoto.models.AdDetails;

import java.util.ArrayList;
import java.util.UUID;

public class SellActivity extends AppCompatActivity {
EditText etName,etYear,etBranch,etPhone,etTitle,etDesc,etPrice;
Button btnPublish;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        etBranch = findViewById(R.id.etBranch);
        etPhone = findViewById(R.id.etPhone);
        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDesc);
        etYear = findViewById(R.id.etYear);
        btnPublish = findViewById(R.id.btnPublish);
        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check() == true) {

                    initFirebase();
                    createAd();
                    finish();
                }
            }


        });

    }
    private Boolean check(){
        Boolean name = etName.getText().toString().equals("");
        Boolean price = etPrice.getText().toString().equals("");
        Boolean branch = etBranch.getText().toString().equals("");
        Boolean phone = etPhone.getText().toString().equals("");
        Boolean title = etTitle.getText().toString().equals("");
        Boolean year = etYear.getText().toString().equals("");


        if (name || price || branch || phone || title || year)
        {
            Toast.makeText(SellActivity.this,"Make Sure Every Field is Filled",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    private void initFirebase() {
        FirebaseApp.initializeApp(this);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference  = mFirebaseDatabase.getReference();
    }
    private void createAd() {
        AdDetails adDetails = new AdDetails(etName.getText().toString(),etYear.getText().toString(),etBranch.getText().toString()
        ,etPhone.getText().toString(),etTitle.getText().toString(),etDesc.getText().toString(),etPrice.getText().toString());
        mDatabaseReference.child("Ads").child(UUID.randomUUID().toString()).setValue(adDetails);
    }

}

