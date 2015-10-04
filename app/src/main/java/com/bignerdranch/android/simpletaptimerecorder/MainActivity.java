package com.bignerdranch.android.simpletaptimerecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mItemsListArray = new ArrayList<String>();
    private ArrayAdapter<String> mItemsListAdapter;
    private Button mAddNewItemButton;
    private ListView mItemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemsListAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mItemsListArray);

        //get a reference to the ListView
        mItemsListView = (ListView) findViewById(R.id.items_list);
        mItemsListView.setAdapter(mItemsListAdapter);

        //get a reference to the Show Selected button
        mAddNewItemButton = (Button) findViewById(R.id.add_button);
        mAddNewItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date currentTime = new Date();
                String timeString = currentTime.toString();
                mItemsListArray.add(timeString);
                mItemsListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
