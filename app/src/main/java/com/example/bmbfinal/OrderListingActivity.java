package com.example.bmbfinal;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmbfinal.Adapter.RecycleViewAdapter;
import com.example.bmbfinal.Model.OrderModel;

import java.util.ArrayList;

public class OrderListingActivity extends Activity {

    ArrayList<OrderModel> orderModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_row);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.orderListRecyclerView);

        // Create adapter passing in the sample user data
        RecycleViewAdapter adapter = new RecycleViewAdapter(this,null);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }

    RecyclerView recyclerView;
    public OrderListingActivity() {


    }
}
