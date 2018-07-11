package org.akshanshgusain.sessionmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

//We will be storing LoginStatus, Name and Email in this Shared Preferences
public class SessionManager {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    private static final String PREF_NAME="loginPreference";
    public static final String KEY_NAME="name";
    public static final String KEY_EMAIL="email";
    public static final String IS_LOGIN="IsLoggedIn";

    //Constructor



    public SessionManager(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences=mContext.getSharedPreferences(PREF_NAME,0);
        mEditor=mSharedPreferences.edit();
    }
    //Creating a session
    public void createLoginSession(String name, String email){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_NAME,name);
        mEditor.putString(KEY_EMAIL,email);
        mEditor.commit();
    }
    //Get User Data
    public HashMap<String,String> getUserDetails()
    {
        HashMap<String,String> user=new HashMap<>();
        user.put(KEY_NAME,mSharedPreferences.getString(KEY_NAME,null));
        user.put(KEY_EMAIL,mSharedPreferences.getString(KEY_EMAIL,null));
        return user;
    }

    public boolean isLoggedIn(){
        return mSharedPreferences.getBoolean(IS_LOGIN, false);
    }
    //Check User Login Status
    public void checkLogin(){
        if(!this.isLoggedIn()){
                 Intent i=new Intent(mContext,LoginActivity.class);
                 //closing all activities
                 i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 // Add new Flag to start new Activity
                  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  mContext.startActivity(i);
        }
    }
     //Log out user
       public void logoutUser(){
               mEditor.clear();
               mEditor.commit();
               //Redirect USer to login screen
           Intent i=new Intent(mContext,LoginActivity.class);
           //closing all activities
           i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           // Add new Flag to start new Activity
           i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           mContext.startActivity(i);


       }

}
