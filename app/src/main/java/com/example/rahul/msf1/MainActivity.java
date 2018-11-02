package com.example.rahul.msf1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buyer(View v){
        startActivity(new Intent(MainActivity.this,Buyer.class));
    }

    public void seller(View v){
        startActivity(new Intent(MainActivity.this,Seller.class));
    }

    public void chemical(View v){
        startActivity(new Intent(MainActivity.this,chemical.class));
    }

    public void product(View v){
        startActivity(new Intent(MainActivity.this,product.class));
    }
}
