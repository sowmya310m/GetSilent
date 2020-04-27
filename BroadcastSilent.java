package com.example.monica.timebased;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Monica on 23-10-2017.
 */

public class BroadcastSilent extends BroadcastReceiver {

    //the method will be fired when the alarm is triggerred
    private AudioManager audioManager;
    Context mContext;



    public void onReceive(final Context context, Intent intent) {
        long time;

        //you can check the log that it is fired
        //Here we are actually not doing anything
        //but you can do any task here that you want to be done at a specific time everyday

        audioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        Bundle extras = intent.getExtras();

        if(extras != null){

            String t= intent.getStringExtra("Extra_diff");
            time=Long.parseLong(t);
           // na = extras.getString("name");
            final Handler handler=new Handler();
             handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    audioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }
            },time);
        }
        Log.d("MyAlarmBelal", "Alarm just fired");

    }

}

