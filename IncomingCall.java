package com.example.monica.timebased;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;












import android.util.Log;

/**
 * Created by $DINESH on 21-06-2017.
 */

public class IncomingCall extends BroadcastReceiver {
    Context context;
    private AudioManager audioManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        this.context=context;

        try {
            // TELEPHONY MANAGER class object to register one listner
            TelephonyManager tmgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            //Create Listner
            MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

            // Register listener for LISTEN_CALL_STATE
            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }

    }

    private class MyPhoneStateListener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {

            Log.d("MyPhoneListener",state+"   incoming no:"+incomingNumber);

            boolean flag=false;
            for(int k=0;k<5;k++)
            {
                SharedPreferences shared=context.getSharedPreferences("Contact Details", Context.MODE_PRIVATE);
                //  Toast.makeText(context, shared.getString("Contact"+k,""), Toast.LENGTH_SHORT).show();
                //  Toast.makeText(context, shared.getString("Name"+k,""), Toast.LENGTH_SHORT).show();
                if((incomingNumber.contains(shared.getString("Contact"+k,"")) || shared.getString("Contact"+k,"").contains(incomingNumber))&&(!shared.getString("Contact"+k,"").equals(""))){
                    flag=true;
                }
            }

            if(flag)
            {
                audioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                audioManager.setStreamVolume(AudioManager.STREAM_RING,audioManager.getStreamMaxVolume(AudioManager.STREAM_RING),0);
            }





        }


    }
}
