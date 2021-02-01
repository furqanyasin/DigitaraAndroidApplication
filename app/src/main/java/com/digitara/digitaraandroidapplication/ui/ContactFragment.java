package com.digitara.digitaraandroidapplication.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.digitara.digitaraandroidapplication.R;
import com.google.android.material.card.MaterialCardView;

public class ContactFragment extends Fragment {
    MaterialCardView cvEmail;
    MaterialCardView cvLocation;
    MaterialCardView cvPhone;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        MaterialCardView materialCardView = (MaterialCardView) root.findViewById(R.id.cv_phone);
        cvPhone = materialCardView;
        materialCardView.setOnClickListener(v -> {
            //code here
            showDialer();
        });
        MaterialCardView materialCardView2 = (MaterialCardView) root.findViewById(R.id.cv_email);
        cvEmail = materialCardView2;
        materialCardView2.setOnClickListener(v -> {
            //code here
            showEmail();
        });
        MaterialCardView materialCardView3 = (MaterialCardView) root.findViewById(R.id.cv_location);
        this.cvLocation = materialCardView3;
        materialCardView3.setOnClickListener(v -> {
            //code here
            showGoogleMap();
        });
        return root;
    }


    private void showEmail() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Send Email ?");
        alertDialog.setView(getLayoutInflater().inflate(R.layout.confirm_layout, (ViewGroup) null));
        alertDialog.setIcon(R.drawable.ic_baseline_email_24);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("plain/text");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"hello@digitara.pk"});
                intent.setType("message/rfc822");
                ContactFragment.this.startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void showDialer() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Make a call ?");
        alertDialog.setView(getLayoutInflater().inflate(R.layout.confirm_layout, (ViewGroup) null));
        alertDialog.setIcon(R.drawable.ic_baseline_phone_24);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:+923327336635"));
                ContactFragment.this.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void showGoogleMap() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Open Google map ?");
        alertDialog.setView(getLayoutInflater().inflate(R.layout.confirm_layout, (ViewGroup) null));
        alertDialog.setIcon(R.drawable.ic_baseline_location_on_24);
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                FragmentTransaction fragmentTransaction = ContactFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.ContactFragment, new LocationFragment(), " ");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
          
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
