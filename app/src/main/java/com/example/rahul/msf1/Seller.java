package com.example.rahul.msf1;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Seller extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editName,editAddress,editPayment;
    Button btnAddData;
    Button btnViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        myDB = new DatabaseHelper(this);

        editName = findViewById(R.id.edit_name);
        editAddress = findViewById(R.id.edit_address);
        editPayment = findViewById(R.id.edit_payment);
        btnAddData = findViewById(R.id.button_add);
        btnViewAll = findViewById(R.id.button_view);
        AddData();
        ViewAll();
    }

    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertDataSeller(editName.getText().toString(),
                                editAddress.getText().toString(),
                                editPayment.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(Seller.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Seller.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void ViewAll(){
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDB.getAllDataSeller();
                        if(res.getCount() == 0){
                            // show message
                            showMessage("Error","Nothind Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("ID :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Address :"+ res.getString(2)+"\n");
                            buffer.append("Payment Method :"+ res.getString(3)+"\n\n");
                        }

                        //show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
