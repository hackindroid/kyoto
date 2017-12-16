package com.hackindroid.kyoto.api;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hackindroid.kyoto.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sushila on 12/15/2017.
 */

public class DownloadFile extends AsyncTask<String,String,String> {
String finalRes = "";
Context context;
    public DownloadFile(Context context) {
        this.context = context;
    }

    protected String doInBackground(String... strings) {
        Log.e("Test", "DOINBG Working..");
        String storageUrl = "https://firebasestorage.googleapis.com/v0/b/kyoto-e42c4.appspot.com/o/Ads%2Fanubhav.json?alt=media&token=04e212c1-a379-46dd-8276-40b51a307547";
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference reference = firebaseStorage.getReferenceFromUrl(storageUrl);
        final File localFile;
        try {
            localFile = File.createTempFile("anubhav", "json");
            reference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    //Toast.makeText(, "File downloaded successfully.", Toast.LENGTH_SHORT).show();
                    try {
                        InputStream inputStream= new FileInputStream(localFile);
                        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder result = new StringBuilder();
                        String line = null;
                        while((line.concat(String.valueOf(br.read()))) != null){
                            Log.e("Test", "Result - "+ result);
                            result.append(line);
                        }
                        finalRes.concat(result.toString());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("Test", "Failed");
                   // Toast.makeText(getContext(), "File downloading failed.", Toast.LENGTH_LONG).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Log.e("Test", "String Downloaded- "+finalRes);
        return finalRes;
    }

    protected void onPostExecute(String result) {
        Log.e("Test", "onPostExecute Working.."+"\nString in onPostExecute Method-" +result);
        //progressDialog.dismiss();
        List<String> data = new ArrayList<>();
        ///progressDialog.dismiss();
        try{
           /* JSONArray jsonArray = new JSONArray(result);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jObject = jsonArray.getJSONObject(i);
                data.add(jObject.getString("ipl_image"));*/
           JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.get("title");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }

        }
        catch (Exception e){
           // Toast.makeText(this,e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
