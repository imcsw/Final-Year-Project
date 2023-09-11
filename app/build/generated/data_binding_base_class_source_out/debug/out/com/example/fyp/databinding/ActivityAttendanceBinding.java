// Generated by view binder compiler. Do not edit!
package com.example.fyp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.fyp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAttendanceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView attendanceTitle;

  @NonNull
  public final FloatingActionButton btnback;

  @NonNull
  public final Button btnsubmit;

  @NonNull
  public final EditText classroomNo;

  @NonNull
  public final ImageView imperiumLogo;

  @NonNull
  public final EditText phoneNo;

  @NonNull
  public final EditText studentID;

  @NonNull
  public final EditText subjectCode;

  @NonNull
  public final TextView warningAttendance;

  private ActivityAttendanceBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView attendanceTitle, @NonNull FloatingActionButton btnback,
      @NonNull Button btnsubmit, @NonNull EditText classroomNo, @NonNull ImageView imperiumLogo,
      @NonNull EditText phoneNo, @NonNull EditText studentID, @NonNull EditText subjectCode,
      @NonNull TextView warningAttendance) {
    this.rootView = rootView;
    this.attendanceTitle = attendanceTitle;
    this.btnback = btnback;
    this.btnsubmit = btnsubmit;
    this.classroomNo = classroomNo;
    this.imperiumLogo = imperiumLogo;
    this.phoneNo = phoneNo;
    this.studentID = studentID;
    this.subjectCode = subjectCode;
    this.warningAttendance = warningAttendance;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAttendanceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAttendanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_attendance, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAttendanceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.attendanceTitle;
      TextView attendanceTitle = ViewBindings.findChildViewById(rootView, id);
      if (attendanceTitle == null) {
        break missingId;
      }

      id = R.id.btnback;
      FloatingActionButton btnback = ViewBindings.findChildViewById(rootView, id);
      if (btnback == null) {
        break missingId;
      }

      id = R.id.btnsubmit;
      Button btnsubmit = ViewBindings.findChildViewById(rootView, id);
      if (btnsubmit == null) {
        break missingId;
      }

      id = R.id.classroomNo;
      EditText classroomNo = ViewBindings.findChildViewById(rootView, id);
      if (classroomNo == null) {
        break missingId;
      }

      id = R.id.imperiumLogo;
      ImageView imperiumLogo = ViewBindings.findChildViewById(rootView, id);
      if (imperiumLogo == null) {
        break missingId;
      }

      id = R.id.phoneNo;
      EditText phoneNo = ViewBindings.findChildViewById(rootView, id);
      if (phoneNo == null) {
        break missingId;
      }

      id = R.id.studentID;
      EditText studentID = ViewBindings.findChildViewById(rootView, id);
      if (studentID == null) {
        break missingId;
      }

      id = R.id.subjectCode;
      EditText subjectCode = ViewBindings.findChildViewById(rootView, id);
      if (subjectCode == null) {
        break missingId;
      }

      id = R.id.warningAttendance;
      TextView warningAttendance = ViewBindings.findChildViewById(rootView, id);
      if (warningAttendance == null) {
        break missingId;
      }

      return new ActivityAttendanceBinding((ConstraintLayout) rootView, attendanceTitle, btnback,
          btnsubmit, classroomNo, imperiumLogo, phoneNo, studentID, subjectCode, warningAttendance);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
