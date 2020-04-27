package com.example.monica.timebased;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnstart,btnend,btnadd;
    EditText textstart,textend;
    private int mHour,mMinute,x,y,a,b,diff1;
            long diff2;
    String r;
   // BroadcastSilent bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnstart=(Button)findViewById(R.id.start);
        btnend=(Button)findViewById(R.id.end);
        btnadd=(Button)findViewById(R.id.add);
      //  bs=new BroadcastSilent(this);

        textstart=(EditText)findViewById(R.id.timestart);
        textend=(EditText)findViewById(R.id.timeend);

         btnstart.setOnClickListener(this);
        btnend.setOnClickListener(this);
        btnadd.setOnClickListener(this);

    }
    public void setAlarm(long time) {
        //getting the alarm manager
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        //creating a new intent specifying the broadcast receiver
        Intent i = new Intent(this,BroadcastSilent.class);
        i.putExtra("Extra_diff",r);

        //creating a pending intent using the intent
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);

        //setting the repeating alarm that will be fired every day
        am.setRepeating(AlarmManager.RTC, time, AlarmManager.INTERVAL_DAY, pi);
        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();
    }

   public void removeAlarm(long time)
    {

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        //creating a new intent specifying the broadcast receiver
        Intent i = new Intent(this,Broadcastringer.class);


        //creating a pending intent using the intent
        PendingIntent pi = PendingIntent.getBroadcast(this,1,i,0);

        //setting the repeating alarm that will be fired every day
        am.setRepeating(AlarmManager.RTC, time, AlarmManager.INTERVAL_DAY, pi);
        Toast.makeText(this, "Alarm is removed", Toast.LENGTH_SHORT).show();
    }


    @Override
   public void onClick(View v) {


        if(v==btnstart){
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            textstart.setText(hourOfDay + ":" + minute);
                            x=hourOfDay;
                            y=minute;
                            Log.d("MyAlarmBelal", String.valueOf(x));
                            Log.d("MyAlarmBelal", String.valueOf(y));
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();


        }

       if(v==btnend){
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {


                            textend.setText(hourOfDay + ":" + minute);
                            a=hourOfDay;
                            b=minute;
                            Log.d("MyAlarmBelal", String.valueOf(a));
                            Log.d("MyAlarmBelal", String.valueOf(b));
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }
        if(v==btnadd){
            diff2= (b-y)* DateUtils.MINUTE_IN_MILLIS;
             r=String.valueOf(diff2);
           Calendar calendar = Calendar.getInstance();
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                    x, y, 0);
            setAlarm(calendar.getTimeInMillis());
            Log.d("MyAlarmBelal", "after silent");




        }
    }


}
