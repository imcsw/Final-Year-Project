package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VerifyAttendanceActivity extends AppCompatActivity {

    TextView verifyAttendanceText;
    EditText tfaCodeTextBox;
    Button btnsubmitCode;
    ImageView tfaImage;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_attendance);

        verifyAttendanceText = (TextView) findViewById(R.id.verifyAttendanceText);
        tfaCodeTextBox = (EditText) findViewById(R.id.tfaCodeTextBox);
        btnsubmitCode = (Button) findViewById(R.id.btnsubmitCode);
        tfaImage = (ImageView) findViewById(R.id.tfaImage);
        DB = new DBHelper(this);

        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String sid = intent.getStringExtra("sid");

        verifyAttendanceText.setText("Please enter the 5-digit code that was sent to " + phoneNumber + ".");

        btnsubmitCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int code = Integer.parseInt(tfaCodeTextBox.getText().toString());

                if(code == 0)
                    Toast.makeText(VerifyAttendanceActivity.this, "Please enter the code", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCode = DB.checkCode(phoneNumber, code);

                    if(checkCode) {
                        Toast.makeText(VerifyAttendanceActivity.this, "Attendance recorded", Toast.LENGTH_SHORT).show();
                        Intent backPage = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(backPage);
                        DB.codeVerified(phoneNumber);
                    }
                    else
                        Toast.makeText(VerifyAttendanceActivity.this, "Invalid code, try again", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}