package com.ohad.statusmykid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {

    private TextView lblLoginMain,lblSystemName, lblUserName, lblPassword, btnSinup;
    private EditText txtSystemName, txtUserName, txtPassword;
    private Button btnSigin;
    private String systemName, userName, password;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setView();

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void setView(){
        lblLoginMain = findViewById(R.id.lbl_login_main);
        lblSystemName = findViewById(R.id.lbl_system_name);
        txtSystemName = findViewById(R.id.txt_system_name);
        lblUserName = findViewById(R.id.lbl_user_name);
        txtUserName = findViewById(R.id.txt_user_name);
        lblPassword = findViewById(R.id.lbl_password);
        txtPassword = findViewById(R.id.txt_password);
        btnSigin = findViewById(R.id.btn_signin);
        btnSinup = findViewById(R.id.btn_sigup);

    }

    public void btnSignin(View view) {
        systemName = txtSystemName.getText().toString();
        userName= txtUserName.getText().toString();
        if(userName.isEmpty()){
            Toast.makeText(this, "אנא הקלד/י שם משתמש", Toast.LENGTH_SHORT).show();
            return;
        }
        password = txtPassword.getText().toString();
        if(password.isEmpty()) {
            Toast.makeText(this, "אנא הקלד/י סיסמה", Toast.LENGTH_SHORT).show();
            return;
        }else {
            progressDialog.setMessage("מתחבר לשרת...");
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if(task.isSuccessful()){
                        finish();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "אחד מהפרטים שהקשת שגוי", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void btnSignup(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
