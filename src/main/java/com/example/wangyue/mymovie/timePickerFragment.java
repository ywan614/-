package com.example.wangyue.mymovie;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class timePickerFragment extends Fragment implements View.OnClickListener {

    private Button time1;
    private Button time2;
    private Button time3;
    private Button time4;
    private Button checkOut;
    private EditText inputNumber;
    private movie m;
    private double price;
    private int id = 0;

    public timePickerFragment() {
        // Required empty public constructor
    }

    public void initTimePicker(movie m){
        this.m = m;
        price = Double.valueOf(m.getPrice());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time_picker,container,false);
        bindView(view);

        time1.setOnClickListener(this);
        time2.setOnClickListener(this);
        time3.setOnClickListener(this);
        time4.setOnClickListener(this);

        time1.setText("4:30pm");
        time2.setText("4:45pm");
        time3.setText("5:30pm");
        time4.setText("6:30pm");

        //set checkout button individually
        checkOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder
                        = new AlertDialog.Builder(getContext());
                //validate input
                if (!(time1.isSelected() || time2.isSelected() || time3.isSelected() || time4.isSelected())) {
                    builder.setTitle("Warning");
                    builder.setMessage("Please select a time");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                } else if (!TextUtils.isDigitsOnly(inputNumber.getText()) ||
                        Integer.parseInt(inputNumber.getText().toString()) > 10 ||
                        Integer.parseInt(inputNumber.getText().toString()) < 1) {
                    builder.setTitle("Warning");
                    builder.setMessage("Ticket must be digit and between 0 and 10");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }
                //check out
                else {
                    final String numberOfT = inputNumber.getText().toString();
                    final Double total = totalPrice(Integer.parseInt(numberOfT));

                    builder.setTitle("Check Out");
                    builder.setMessage(confirmMsg(id, Integer.parseInt(numberOfT),
                            total));
                    builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        //pass receipt information to next activity
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Bundle b = new Bundle();
                            b.putString("name",m.getName());
                            b.putString("ticket", numberOfT);
                            b.putString("price",String.valueOf(total));
                            b.putString("address",m.getAddress());
                            b.putString("orderNum",String.valueOf(System.currentTimeMillis()));
                            Intent intent = new Intent(getActivity(), Receipt.class);
                            intent.putExtras(b);
                            //intent.putExtra("receipt");
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("Cancel", null);
                    builder.show();
                }
            }
        });
        return view;

    }



    private void bindView(View view){
        time1 = (Button)view.findViewById(R.id.time1);
        time2 = (Button)view.findViewById(R.id.time2);
        time3 = (Button)view.findViewById(R.id.time3);
        time4 = (Button)view.findViewById(R.id.time4);
        checkOut = (Button)view.findViewById(R.id.checkoutBtn);
        inputNumber = (EditText)view.findViewById(R.id.inputNumber);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.time1:
                selected();
                time1.setSelected(true);
                id = R.id.time1;
                break;
            case R.id.time2:
                selected();
                time2.setSelected(true);
                id = R.id.time2;
                break;
            case R.id.time3:
                selected();
                time3.setSelected(true);
                id = R.id.time3;
                break;
            case R.id.time4:
                selected();
                time4.setSelected(true);
                id = R.id.time4;
                break;
        }






    }

    private void selected(){
        time1.setSelected(false);
        time2.setSelected(false);
        time3.setSelected(false);
        time4.setSelected(false);
    }

    private String confirmMsg(int id, int ticket,double p){
        String time = "";
        switch (id){
            case R.id.time1:
                time = "4:30 pm";
                break;
            case R.id.time2:
                time = "4:45 pm";
                break;
            case R.id.time3:
                time = "5:30 pm";
                break;
            case R.id.time4:
                time = "6:30 pm";
                break;
        }

        String s = "Do you wish to continue?\nTime: " + time + "\n Number of tickets: " + String.valueOf(ticket)
                +"\nPrice: $" + String.valueOf(p);
        return s;
    }

    private double totalPrice(int i){
        double p;
        p = i*price;
        return p;
    }




}
