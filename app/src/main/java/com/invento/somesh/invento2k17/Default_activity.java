package com.invento.somesh.invento2k17;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Default_activity extends AppCompatActivity {

    private ImageButton imageButtonEvents;
    private ImageButton imageButtonSch;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    public final static String MESSAGE_KEY ="androidbelieve.message_key";
    public String d = "TabFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_activity);

        imageButtonEvents = (ImageButton) findViewById(R.id.eventsButton);
        imageButtonSch = (ImageButton) findViewById(R.id.scheduleButton) ;

        imageButtonSch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d="ScheduleFragment";
                Intent intent = new Intent(Default_activity.this,MainActivity.class);
                intent.putExtra(MESSAGE_KEY,d);
                startActivity(intent);

            }
        });

        imageButtonEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d="TabFr";
                Intent intent = new Intent(Default_activity.this,MainActivity.class);
                intent.putExtra(MESSAGE_KEY,d);
                startActivity(intent);
            }
        });


    }
}
