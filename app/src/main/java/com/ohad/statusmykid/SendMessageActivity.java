package com.ohad.statusmykid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SendMessageActivity extends Activity {

    TextView lblTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frame);
        lblTitle = findViewById(R.id.lbl_main_frame);
        lblTitle.setText("שליחת הודעות");
        findViewById(R.id.inc_send_message).setVisibility(View.VISIBLE);


    }

    public void btn_main(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}