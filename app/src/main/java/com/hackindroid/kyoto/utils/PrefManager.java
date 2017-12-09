package com.hackindroid.kyoto.utils;

/**
 * Created by Anirudh on 07-10-2017.
 */


import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "notesPref";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String USER_NAME= "UserName";
    private static final String USER_BRANCH= "UserBranch";
    private static final String USER_YEAR= "UserYear";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setUserName(String name){
        editor.putString(USER_NAME, name);
        editor.commit();
    }

    public String getUserName(){
        return  pref.getString(USER_NAME, null);
    }

    public void setBranch(int branch){
        editor.putInt(USER_BRANCH, branch);
        editor.commit();
    }

    public int getBranch(){
        return pref.getInt(USER_BRANCH, -1);
    }

    public void setYear(int year){
        editor.putInt(USER_YEAR, year);
        editor.commit();
    }

    public int getYear(){
        return pref.getInt(USER_YEAR, -1);
    }

}

