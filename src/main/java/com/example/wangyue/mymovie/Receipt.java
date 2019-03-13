package com.example.wangyue.mymovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {
    TextView price;
    TextView name;
    TextView address;
    TextView orderNum;
    TextView ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        bindView();
        price.setText("$ " +b.getString("price"));
        name.setText(b.getString("name"));
        address.setText(b.getString("address"));
        orderNum.setText(b.getString("orderNum"));
        ticket.setText(b.getString("ticket"));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void bindView(){
        price = (TextView)findViewById(R.id.priceTxt);
        name = (TextView)findViewById(R.id.nameReceiptTxt);
        address = (TextView)findViewById(R.id.addressReceiptTxt);
        orderNum = (TextView)findViewById(R.id.orderReceiptTxt);
        ticket = (TextView)findViewById(R.id.ticketReceiptTxt);
    }
}
