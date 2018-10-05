package com.ohad.statusmykid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddKidActivity extends Activity {

    Button btnAddNewKid;
    TextView lblTitle;
    EditText txtClassName, txtKidId, txtFirstName, txtLastName, txtParent01, txtParent01Phone01, txtParent01Phone02, txtParent02, txtParent02Phone01, txtParent02Phone02, txtEmail01;
    AutoCompleteTextView txtEmail02;
    String className, kidId, firstName, lastName, parent01, parent01Phone01, parent01Phone02, parent02, parent02Phone01, parent02Phone02, email01, email02;
    Boolean isPresent;
    String[] mail = {"gmail.com", "walla.co.il", "walla.com", "bezeqint.net", "yahoo.com"};
    boolean bKidId, bFirstName, bLastName, bParent01, bParentPhone01, bParentPhone02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frame);
        lblTitle = findViewById(R.id.lbl_main_frame);
        lblTitle.setText("הוסף ילד");
        findViewById(R.id.inc_add_kid).setVisibility(View.VISIBLE);
        findViews();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, mail);
        txtEmail02.setThreshold(2);
        txtEmail02.setAdapter(adapter);

    }

    public void btn_main(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void btnAdd(View view) {
        getText();
        Kid kid = new Kid(className, kidId,firstName,lastName,parent01,parent01Phone01,parent02,parent02Phone01,email01,isPresent);
        MainActivity.databaseReference.child("kids").child(className).child(kidId).setValue(kid);
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "פרטי הילד נוספו בהצלחה", Toast.LENGTH_SHORT).show();
    }

    public void btnCancel(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    private void findViews(){
        btnAddNewKid = findViewById(R.id.btn_add_new_kid);
        btnAddNewKid.setEnabled(false);
        txtClassName = findViewById(R.id.txt_class_name);
        txtKidId = findViewById(R.id.txt_kid_id);
        txtKidId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    bKidId = true;
                    if(bFirstName == true && bLastName == true && bParent01 == true && bParentPhone01 == true && bParentPhone02 == true)
                        btnAddNewKid.setEnabled(true);
                }else{
                    btnAddNewKid.setEnabled(false);
                }
            }
        });
        txtFirstName = findViewById(R.id.txt_first_name);
        txtFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    bFirstName = true;
                    if(bKidId == true && bLastName == true && bParent01 == true && bParentPhone01 == true && bParentPhone02 == true)
                        btnAddNewKid.setEnabled(true);
                }else{
                    btnAddNewKid.setEnabled(false);
                }
            }
        });
        txtLastName = findViewById(R.id.txt_last_name);
        txtLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    bLastName = true;
                    if(bKidId == true &&  bFirstName == true && bParent01 == true && bParentPhone01 == true && bParentPhone02 == true)
                        btnAddNewKid.setEnabled(true);
                }else {
                    btnAddNewKid.setEnabled(false);
                }
            }
        });
        txtParent01 = findViewById(R.id.txt_parent01_name);
        txtParent01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    bParent01 = true;
                    if(bKidId == true &&  bFirstName == true && bLastName == true && bParentPhone01 == true && bParentPhone02 == true)
                        btnAddNewKid.setEnabled(true);
                }else {
                    btnAddNewKid.setEnabled(false);
                }
            }
        });
        txtParent01Phone01 = findViewById(R.id.txt_parent01_phone01);
        txtParent01Phone01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 3){
                    bParentPhone01 = true;
                    if(bKidId == true &&  bFirstName == true && bLastName == true && bParent01 == true && bParentPhone02 == true)
                        btnAddNewKid.setEnabled(true);
                }else {
                    btnAddNewKid.setEnabled(false);
                }
            }
        });
        txtParent01Phone02 = findViewById(R.id.txt_parent01_phone02);
        txtParent01Phone02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() >= 7){
                    bParentPhone02 = true;
                    if(bKidId == true &&  bFirstName == true && bLastName == true && bParent01 == true && bParentPhone01 == true)
                        btnAddNewKid.setEnabled(true);
                }else {
                    btnAddNewKid.setEnabled(false);
                }
            }
        });
        txtParent02 = findViewById(R.id.txt_parent02_name);
        txtParent02Phone01 = findViewById(R.id.txt_parent02_phone01);
        txtParent02Phone02 = findViewById(R.id.txt_parent02_phone02);
        txtEmail01 = findViewById(R.id.txt_email01);
        txtEmail02 = findViewById(R.id.txt_email02);
    }

    private void getText(){
        className = txtClassName.getText().toString();
        kidId = txtKidId.getText().toString();
        firstName = txtFirstName.getText().toString();
        lastName = txtLastName.getText().toString();
        parent01 = txtParent01.getText().toString();
        parent01Phone01 = txtParent01Phone01.getText().toString();
        parent01Phone02 = txtParent01Phone02.getText().toString();
        parent01Phone01 += parent01Phone02;
        parent02 = txtParent02.getText().toString();
        if(parent02.isEmpty())
            parent02 = "";
        parent02Phone01 = txtParent02Phone01.getText().toString();
        parent02Phone02 = txtParent02Phone02.getText().toString();
        parent02Phone01 += parent02Phone02;
        if(parent02Phone01.isEmpty())
            parent02Phone01 = "";
        email01 = txtEmail01.getText().toString();
        email02 = txtEmail02.getText().toString();
        email01 += email02;
        if(email01.isEmpty())
            email01 = "";
    }

}
