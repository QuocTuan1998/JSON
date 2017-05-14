package com.example.quoctuan.json.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quoctuan.json.R;
import com.example.quoctuan.json.model.Account;

public class DetailAcountActivity extends AppCompatActivity {
    Account accountInfor;
    ImageView imgDetails;
    TextView tvDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acount);

        addControl();
    }

    private void addControl() {

    }
}
