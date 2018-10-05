package com.ohad.statusmykid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {

    public static FirebaseAuth firebaseAuth;
    public static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    TextView lblUserDate;
//להוסיף דיווח להורים על זמני האכלה והחלפת טיטולים!*******************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        lblUserDate = findViewById(R.id.lbl_user_date);
        lblUserDate.setText(user.getEmail());
    }

    public void btnAddNewKid(View view) {
        startActivity(new Intent(this, AddKidActivity.class));

    }

    public void btnCheck(View view) {
        DialogChooseClass chooseClass = new DialogChooseClass();

    }

    public void btnPresenceScreen(View view) {
        startActivity(new Intent(this, PresenceActivity.class));
    }

    public void btnSendMessageScreen(View view) {
        startActivity(new Intent(this, SendMessageActivity.class));
    }

    public void btnSettings(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void btnLogoff(View view) {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }
}
