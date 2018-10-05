package com.ohad.statusmykid;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class DialogChooseClass extends DialogFragment {

    View view;
    TextView lblChooseClass;
    Spinner spnChooseClass;
    Button btnChooseOk, btnChooseCancel;
    String[] spnClass = {"תינוקייה", "צעירים", "בוגרים"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.choose_class_dialog, container, false);
        findView();
        spnSet();
        return view;
    }
    
    private void findView(){
        lblChooseClass = view.findViewById(R.id.lbl_choose_class);
        spnChooseClass = view.findViewById(R.id.spn_coose_class);
        btnChooseOk = view.findViewById(R.id.btn_choose_ok);
        btnChooseCancel = view.findViewById(R.id.btn_choose_cancel);
    }

    private void spnSet(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, spnClass);
        spnChooseClass.setAdapter(adapter);

    }

}
