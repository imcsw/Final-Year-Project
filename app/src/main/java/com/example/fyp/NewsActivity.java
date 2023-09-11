package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsActivity extends AppCompatActivity {

    Dialog calendarDialog;
    TextView noticeText;
    ImageView imperiumLogo;
    Button academicCalendar, timetable, examTimetable;
    FloatingActionButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle("Notices and Announcements");

        calendarDialog = new Dialog(this);
        noticeText = (TextView) findViewById(R.id.noticeText);
        imperiumLogo = (ImageView) findViewById(R.id.imperiumLogo);
        academicCalendar = (Button) findViewById(R.id.academicCalendar);
        timetable = (Button) findViewById(R.id.timetable);
        btnback = (FloatingActionButton) findViewById(R.id.btnback);
        examTimetable = (Button) findViewById(R.id.examTimetable);

        academicCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("http://bit.ly/3TtvcrT");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
            }
        });

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("http://bit.ly/3LFa6EV");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
            }
        });

        examTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri url = Uri.parse("http://bit.ly/3JXzQeo");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}