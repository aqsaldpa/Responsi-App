package com.paymu.app;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionLog {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context con;

    public SessionLog (Context context){
        this.con = context;
        pref = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setLoggedin(boolean loggedin){
        editor.putBoolean("Loggedinmode",loggedin);
        editor.commit();
    }
    public boolean loggedin(){return pref.getBoolean("Loggedinmode",false);}
}
