package com.digitara.digitaraandroidapplication.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.digitara.digitaraandroidapplication.Helpers.GMailSender;
import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class GetQuoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    AutoCompleteTextView autoCompleteTextView;
    MaterialButton btnSubmit;
    EditText etComment;
    EditText etEmail;
    EditText etName;
    EditText etPhoneNumber;
    TextInputLayout inputLayoutComment;
    TextInputLayout inputLayoutEmail;
    TextInputLayout inputLayoutName;
    TextInputLayout inputLayoutPhoneNumber;
    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_quote);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        etComment = findViewById(R.id.et_comment);

        autoCompleteTextView = findViewById(R.id.actv);
        autoCompleteTextView.setOnItemSelectedListener(this);
        inputLayoutName = findViewById(R.id.inputLayoutName);
        inputLayoutEmail = findViewById(R.id.inputLayoutEmail);
        inputLayoutPhoneNumber = findViewById(R.id.inputLayoutPhone);
        inputLayoutComment = findViewById(R.id.inputLayoutComment);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(v -> {

            checkSendEmail();

        });
        autoCompleteTextView.setAdapter(new ArrayAdapter<>(this, R.layout.custom_list_item,
                 R.id.text_view_list_item, getResources().getStringArray(R.array.Services_list)));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), "Selected : "
                + ((String) adapterView.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void sendMessage() {
        final String spinnerSubject = autoCompleteTextView.getText().toString();
        final String Name = etName.getText().toString();
        final String Email = etEmail.getText().toString();
        final String PhoneNumber = etPhoneNumber.getText().toString();
        final String Comment = etComment.getText().toString();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        new Thread(() -> {
            try {
                new GMailSender("inquirydigitara.pk@gmail.com", "Kuki@pak1122")
                        .sendMail(spinnerSubject, "Name: " + Name + "\nEmail: " + Email + "\nPhone : "
                                + PhoneNumber + "\nServices: " + spinnerSubject + "\nComment: "
                                + Comment, "sender","hello@digitara.pk");
                dialog.dismiss();
                finish();
                Toast.makeText(this, "Email Send Successfully", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.e("mylog", "Error: " + e.getMessage());
            }
        }).start();
    }

    private void checkSendEmail() {
        String emailInput = etEmail.getText().toString();
        boolean isValid = true;
        if (etName.getText().toString().isEmpty()) {
            inputLayoutName.setError("Your name is mandatory");
            isValid = false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }
        if (etEmail.getText().toString().isEmpty()) {
            inputLayoutEmail.setError("Email is mandatory");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            inputLayoutEmail.setError("Please enter a valid email address");
            isValid = false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }
        if (etPhoneNumber.getText().toString().isEmpty()) {
            inputLayoutPhoneNumber.setError("Phone No must be +923001234567");
            isValid = false;
        } else {
            inputLayoutPhoneNumber.setErrorEnabled(false);
        }
        if (etComment.getText().toString().isEmpty()) {
            inputLayoutComment.setError("your message is here");
            isValid = false;
        } else {
            inputLayoutComment.setErrorEnabled(false);
        }
        if (isValid) {
            sendMessage();
        }
    }
}
