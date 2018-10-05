package com.ohad.statusmykid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class UsersActivity extends Activity {

    TextView lblTitle;
    EditText txtNewUserName, txtNewPassword, txtNewPassowrd02;
    String newUserName, newPassword, newPassword02;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frame);
        lblTitle = findViewById(R.id.lbl_main_frame);
        lblTitle.setText("ניהול משתמשים");
        findViewById(R.id.inc_users).setVisibility(View.VISIBLE);

        findViews();

    }

    public void btn_main(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    private void findViews() {
        txtNewUserName = findViewById(R.id.txt_new_user_name);
        txtNewPassword = findViewById(R.id.txt_new_password);
        txtNewPassowrd02 = findViewById(R.id.txt_new_password02);
    }

    public void btnCreateUser(View view) throws FirebaseAuthException {
        newUserName = txtNewUserName.getText().toString();
        newPassword = txtNewPassword.getText().toString();
        newPassword02 = txtNewPassowrd02.getText().toString();
        progressDialog = new ProgressDialog(this);
        if(newUserName.isEmpty() || newPassword.isEmpty() || newPassword02.isEmpty()){
            Toast.makeText(this, "אנא הכנס/י שם משתמש וסיסמאות תואמות", Toast.LENGTH_SHORT).show();
            return;
        }else if(newPassword.equals(newPassword02)) {
            progressDialog.setMessage("יוצר משתמש...");
            progressDialog.show();
            MainActivity.firebaseAuth.createUserWithEmailAndPassword(newUserName, newPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                txtNewUserName.setText("");
                                txtNewPassword.setText("");
                                txtNewPassowrd02.setText("");
                                Toast.makeText(UsersActivity.this, "המשתמש נוצר בהצלחה", Toast.LENGTH_SHORT).show();
                            } else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(UsersActivity.this, "אימייל קיים במערכת", Toast.LENGTH_SHORT).show();
                            } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(UsersActivity.this, "הפרטים לא הוכנסו כראוי. אנא הכנס/י אימייל חוקי וסיסמה בת 6 ספרות.", Toast.LENGTH_LONG).show();
                            }
                        progressDialog.dismiss();
                        }
                    })
            .addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UsersActivity.this, "שגיאה ביצירת משתמש", Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            Toast.makeText(UsersActivity.this, "הסיסמאות אינן תואמות", Toast.LENGTH_SHORT).show();
        }
    }



}