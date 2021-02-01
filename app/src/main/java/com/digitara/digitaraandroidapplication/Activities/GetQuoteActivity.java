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
        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPhoneNumber = (EditText) findViewById(R.id.et_phone_number);
        etComment = (EditText) findViewById(R.id.et_comment);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.actv);
        autoCompleteTextView.setOnItemSelectedListener(this);
        inputLayoutName = (TextInputLayout) findViewById(R.id.inputLayoutName);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.inputLayoutEmail);
        inputLayoutPhoneNumber = (TextInputLayout) findViewById(R.id.inputLayoutPhone);
        inputLayoutComment = (TextInputLayout) findViewById(R.id.inputLayoutComment);
        btnSubmit = (MaterialButton) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(v -> {

            checkSendEmail();

        });


       autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
               android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Services_list)));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), "Selected : " + ((String) adapterView.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    private void sendMessage() {
        final String spinnerSubject = this.autoCompleteTextView.getText().toString();
        final String Name = this.etName.getText().toString();
        final String Email = this.etEmail.getText().toString();
        final String PhoneNumber = this.etPhoneNumber.getText().toString();
        final String Comment = this.etComment.getText().toString();
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        new Thread(new Runnable() {

            public void run() {
                try {
                    new GMailSender("inquirydigitara.pk@gmail.com", "Kuki@pak1122").sendMail(spinnerSubject, "Name: " + Name + "\nEmail: " + Email + "\nPhone : " + PhoneNumber + "\nServices: " + spinnerSubject + "\nComment: " + Comment, "sender", "hello@digitara.pk");
                    dialog.dismiss();
                    GetQuoteActivity.this.finish();
                    Toast.makeText(GetQuoteActivity.this, "Email Send Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("mylog", "Error: " + e.getMessage());
                }
            }
        }).start();
    }

    private void checkSendEmail() {
        String emailInput = this.etEmail.getText().toString();
        boolean isValid = true;
        if (this.etName.getText().toString().isEmpty()) {
            this.inputLayoutName.setError("Your name is mandatory");
            isValid = false;
        } else {
            this.inputLayoutName.setErrorEnabled(false);
        }
        if (this.etEmail.getText().toString().isEmpty()) {
            this.inputLayoutEmail.setError("Email is mandatory");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            this.inputLayoutEmail.setError("Please enter a valid email address");
            isValid = false;
        } else {
            this.inputLayoutEmail.setErrorEnabled(false);
        }
        if (this.etPhoneNumber.getText().toString().isEmpty()) {
            this.inputLayoutPhoneNumber.setError("Phone No must be +923001234567");
            isValid = false;
        } else {
            this.inputLayoutPhoneNumber.setErrorEnabled(false);
        }
        if (this.etComment.getText().toString().isEmpty()) {
            this.inputLayoutComment.setError("your message is here");
            isValid = false;
        } else {
            this.inputLayoutComment.setErrorEnabled(false);
        }
        if (isValid) {
            sendMessage();
        }
    }
}
