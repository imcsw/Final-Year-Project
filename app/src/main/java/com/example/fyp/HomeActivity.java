package com.example.fyp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.net.Uri;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeText;
    Button btnattendance, btnnews;
    ImageButton imperiumLogo;
    FloatingActionButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Imperium International College");

        welcomeText = (TextView) findViewById(R.id.welcomeText);
        btnattendance = (Button) findViewById(R.id.btnattendance);
        btnnews = (Button) findViewById(R.id.btnnews);
        imperiumLogo = (ImageButton) findViewById(R.id.imperiumLogoURL);
        logout = (FloatingActionButton) findViewById(R.id.logout);

        btnattendance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AttendanceActivity.class);
                startActivity(intent);
            }
        });

        btnnews.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);
            }
        });

        imperiumLogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Uri url = Uri.parse("https://imperium.edu.my");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
        }
        });

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "You have successfully logged out.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}