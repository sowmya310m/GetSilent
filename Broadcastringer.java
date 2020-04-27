package com.example.monica.timebased;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

/**
 * Created by Monica on 23-10-2017.
 */

public class Broadcastringer extends BroadcastReceiver {

    private AudioManager audioManager1;
    private int  SNOOZE_MIN=1;

    public void snooze() {
      /*  Log.d("MyAlarmBelal", "Alarm just stopped");
        Calendar calendar = Calendar.getInstance();
        int snoozeTime = mMinute + SNOOZE_MIN;
        calendar.add(Calendar.MINUTE, SNOOZE_MIN); //SNOOZE_MIN = 1;
        long snoozeTime = calendar.getTimeInMillis();
        //Build Intent and Pending Intent to Set Snooze Alarm

        PendingIntent Sender = PendingIntent.getBroadcast(SnoozeActivity.this, req_code, AlarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlmMgr.set(AlarmManager.RTC_WAKEUP, snoozeTime, Sender);
        timer.cancel();
        //MediaPlayer mediaPlayer= MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        //mediaPlayer.start();
      //  audioManager1=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
       // audioManager1.setRingerMode(AudioManager.RINGER_MODE_NORMAL);*/
    }

    @Override
    public void onReceive(Context context, Intent intent) {
     /*   Log.d("MyAlarmBelal", "Alarm just stopped");
        Calendar calendar = Calendar.getInstance();
        int snoozeTime = mMinute + SNOOZE_MIN;
        calendar.add(Calendar.MINUTE, SNOOZE_MIN); //SNOOZE_MIN = 1;
        long snoozeTime = calendar.getTimeInMillis();
        //Build Intent and Pending Intent to Set Snooze Alarm

        PendingIntent Sender = PendingIntent.getBroadcast(SnoozeActivity.this, req_code, AlarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlmMgr.set(AlarmManager.RTC_WAKEUP, snoozeTime, Sender);
        timer.cancel();
        //MediaPlayer mediaPlayer= MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        //mediaPlayer.start();
        //  audioManager1=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
        // audioManager1.setRingerMode(AudioManager.RINGER_MODE_NORMAL);*/

    }
}
