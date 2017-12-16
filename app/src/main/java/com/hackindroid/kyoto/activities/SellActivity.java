package com.hackindroid.kyoto.activities;

import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hackindroid.kyoto.R;
import com.hackindroid.kyoto.api.DownloadFile;
import com.hackindroid.kyoto.models.APIService;
import com.hackindroid.kyoto.models.SellDetails;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class SellActivity extends AppCompatActivity {
    ArrayList<SellDetails> sellDetails = new ArrayList<>();
    private StorageReference storageReference;
EditText etName,etYear,etBranch,etPhone,etTitle,etDesc;
Button btnPublish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        etName = findViewById(R.id.etName);
        storageReference = FirebaseStorage.getInstance().getReference();
        etYear = findViewById(R.id.etYear);
        btnPublish = findViewById(R.id.btnPublish);
        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                       /* setName();
                        createJSONFolder();
                        CompositionJso obj = new CompositionJso();*/
                       JSONObject obj;
                        obj = makeJSONObject("hi", "hi", "hi", "hi");

                        try {
                            //Writer output = null;
                            //File file = new File(getFilesDir(),"anubhav.json");
                           // output = new BufferedWriter(new FileWriter(file));
                            //output.write(obj.toString());
                            //output.close();
                           // Toast.makeText(getApplicationContext(), "Composition saved", Toast.LENGTH_LONG).show();
                            //readfile();
                            //retrieveData();
                            //uploadjson();
                            //testing();
                           /* APIService.getApi().getDetails().enqueue(new Callback<ArrayList<SellDetails>>() {
                                @Override
                                public void onResponse(retrofit2.Call<ArrayList<SellDetails>> call, Response<ArrayList<SellDetails>> response) {
                                    int x = response.body().size();
                                    String y = response.body().get(0).getDesc();
                                    Toast.makeText(SellActivity.this,x+y,Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onFailure(retrofit2.Call<ArrayList<SellDetails>> call, Throwable t) {

                                }
                            });*/
                            new DownloadFile(SellActivity.this).execute("hi");

                        } catch (Exception e) {
                            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }

                        //finish();
            }
        });

    }
    void testing(){

    }
    void uploadjson(){
        StorageReference pathReference = storageReference.child("Ads/53637183.jpg");

    }
    void readfile() throws IOException {
        //Toast.makeText(getApplicationContext(),retrieveData(),Toast.LENGTH_LONG).show();

    }
    public JSONObject makeJSONObject (String title, String desc, String imgPath, String imgView) {

        JSONObject obj = new JSONObject() ;

        try {
            obj.put("title", title);
            obj.put("desc", desc);
            obj.put("imgPath", imgPath);
            obj.put("imgViewPath", imgView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }
    void retrieveData () throws IOException {

        File f = new File(getFilesDir(), "anubhav.json");
        //f.toURI();
        Uri uri = Uri.fromFile(f);
        StorageReference filePath = storageReference.child("Ads").child(uri.getLastPathSegment());
        filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
           //Toast.makeText(SellActivity.this,downloadUrl.toString(),Toast.LENGTH_LONG).show();

            }
        });
        //FileInputStream fis = new FileInputStream(f);
/*
        String buf = "";
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        while (buf != null) {
            sb.append(buf + "\n");
            buf = br.readLine();
        }

        return sb.toString();*/


    }
}

