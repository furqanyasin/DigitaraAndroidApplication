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

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_quote);
        this.etName = (EditText) findViewById(R.id.et_name);
        this.etEmail = (EditText) findViewById(R.id.et_email);
        this.etPhoneNumber = (EditText) findViewById(R.id.et_phone_number);
        this.etComment = (EditText) findViewById(R.id.et_comment);
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.actv);
        this.autoCompleteTextView = autoCompleteTextView2;
        autoCompleteTextView2.setOnItemSelectedListener(this);
        this.inputLayoutName = (TextInputLayout) findViewById(R.id.inputLayoutName);
        this.inputLayoutEmail = (TextInputLayout) findViewById(R.id.inputLayoutEmail);
        this.inputLayoutPhoneNumber = (TextInputLayout) findViewById(R.id.inputLayoutPhone);
        this.inputLayoutComment = (TextInputLayout) findViewById(R.id.inputLayoutComment);
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.btn_submit);
        this.btnSubmit = materialButton;
        materialButton.setOnClickListener(new View.OnClickListener() {
            /* class com.digitara.digitara.Activities.$$Lambda$GetQuoteActivity$d5kv3D3WuFp5oXLnMylypZskxwY */

            public final void onClick(View view) {
                GetQuoteActivity.this.lambda$onCreate$0$GetQuoteActivity(view);
            }
        });
        this.autoCompleteTextView.setAdapter(new ArrayAdapter<>(this, (int) R.layout.custom_list_item, (int) R.id.text_view_list_item, getResources().getStringArray(R.array.Services_list)));
    }

    public /* synthetic */ void lambda$onCreate$0$GetQuoteActivity(View view) {
        checkSendEmail();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), "Selected : " + ((String) adapterView.getItemAtPosition(position)), 0).show();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
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
            /* class com.digitara.digitara.Activities.GetQuoteActivity.AnonymousClass1 */

            public void run() {
                try {
                    new GMailSender("inquirydigitara.pk@gmail.com", "Kuki@pak1122").sendMail(spinnerSubject, "Name: " + Name + "\nEmail: " + Email + "\nPhone : " + PhoneNumber + "\nServices: " + spinnerSubject + "\nComment: " + Comment, "sender", "hello@digitara.pk");
                    dialog.dismiss();
                    GetQuoteActivity.this.finish();
                    Toast.makeText(GetQuoteActivity.this, "Email Send Successfully", 0).show();
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
