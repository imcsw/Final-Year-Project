package com.example.fyp;

import java.util.concurrent.ThreadLocalRandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AttendanceActivity extends AppCompatActivity {

    int min = 10000;
    int max = 99999;
    int tfaCode = 0;

    ImageView imperiumLogo;
    TextView attendanceTitle, warningAttendance;
    EditText studentID, classroomNo, subjectCode, phoneNo;
    Button btnsubmit;
    FloatingActionButton btnback;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        setTitle("Attendance");

        imperiumLogo = (ImageView) findViewById(R.id.imperiumLogo);
        attendanceTitle = (TextView) findViewById(R.id.attendanceTitle);
        warningAttendance = (TextView) findViewById(R.id.warningAttendance);
        studentID = (EditText) findViewById(R.id.studentID);
        classroomNo = (EditText) findViewById(R.id.classroomNo);
        subjectCode = (EditText) findViewById(R.id.subjectCode);
        phoneNo = (EditText) findViewById(R.id.phoneNo);
        btnsubmit = (Button) findViewById(R.id.btnsubmit);
        btnback = (FloatingActionButton) findViewById(R.id.btnback);
        DB = new DBHelper(this);

        btnsubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String sid = studentID.getText().toString();
                String subCode = subjectCode.getText().toString();
                int classroom = Integer.parseInt(classroomNo.getText().toString());
                String phoneNumber = phoneNo.getText().toString();

                tfaCode = ThreadLocalRandom.current().nextInt(min, max);

                if(sid.equals("")||subCode.equals("")||classroom == 0||phoneNumber.equals(""))
                    Toast.makeText(AttendanceActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkSID = DB.checkID(sid);
                    Boolean checkPhoneNo = DB.checkPhoneNo(phoneNumber);

                    if(checkSID||checkPhoneNo)
                        Toast.makeText(AttendanceActivity.this, "Phone number or student ID is in use", Toast.LENGTH_SHORT).show();
                    else{
                        //Toast.makeText(AttendanceActivity.this, "Attendance submitted", Toast.LENGTH_SHORT).show();
                        DB.insertAttendanceData(sid, subCode, classroom, phoneNumber, tfaCode);
                        Intent intent  = new Intent(AttendanceActivity.this, VerifyAttendanceActivity.class);
                        intent.putExtra("phoneNumber", phoneNumber);
                        intent.putExtra("studentID", sid);
                        startActivity(intent);

                        if(checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                        {
                            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
                        }
                        else {
                            sendSMS(phoneNumber, tfaCode);
                        }

                        //sendSMS(phoneNumber, tfaCode);
                    }
                }
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

    public void sendSMS(String phoneNo, int code)
    {
        String message = "Your code is " + code +". Please enter this code on the attendance app.";

        try
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);

            Toast.makeText(this, "Message sent to " + phoneNo + ".", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Message failed to send.", Toast.LENGTH_SHORT).show();
        }
    }
}