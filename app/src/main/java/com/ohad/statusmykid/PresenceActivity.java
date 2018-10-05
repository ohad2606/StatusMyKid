package com.ohad.statusmykid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PresenceActivity extends Activity{

    List<Kid> kids = new ArrayList<>();
    ListView lstKids;
    KidPresenceAdapter lstAdapter;
    TextView lblTitle;

    public String className, kidId, firstName, lastName, parent01, parentPhone01, parent02, parentPhone02, email;
    public Boolean isPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frame);
        lblTitle = findViewById(R.id.lbl_main_frame);
        lblTitle.setText("מסך נוכחות");
        findViewById(R.id.inc_presence).setVisibility(View.VISIBLE);

        lstKids = findViewById(R.id.lst_presence);

        FirebaseDatabase.getInstance().getReference()
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            className = snapshot.child("kids").getValue().toString();
                            Toast.makeText(PresenceActivity.this, className , Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

        //DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("kids");
        //className = rootRef.child("className");
        //Toast.makeText(this, className, Toast.LENGTH_SHORT).show();

    }

    private void getKidsList(){
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("kids");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                className = (String) dataSnapshot.child("className").getValue();
                firstName = (String) dataSnapshot.child("firstName").getValue();
                lastName = (String) dataSnapshot.child("lastName").getValue();
                Kid kid = new Kid(className, kidId, firstName, lastName, parent01, parentPhone01, parent02, parentPhone02, email, isPresent);
                kid.setClassName(className);
                kid.setFirstName(firstName);
                kid.setLastName(lastName);
                kids.add(kid);
                Toast.makeText(PresenceActivity.this, className, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        rootRef.addListenerForSingleValueEvent(eventListener);
    }

    public void btn_main(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void btnRefresh(View view) {
        Toast.makeText(this, className, Toast.LENGTH_SHORT).show();
    }
}
