package com.varun.dscsocialnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        final String userName = getIntent().getStringExtra("user_name");

        Button b1 = (Button) findViewById(R.id.postMessageButton);
        final EditText e1 = (EditText) findViewById(R.id.userPostEditText);
        ListView l1 = (ListView) findViewById(R.id.listOfPostsListView);

        final ArrayList<String> dataSource = new ArrayList<>();

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (getApplicationContext(), android.R.layout.simple_list_item_1,
                        android.R.id.text1, dataSource);
        l1.setAdapter(myAdapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = e1.getEditableText().toString();
                message = userName + ": "+message;
                dataSource.add(message);
                myAdapter.notifyDataSetChanged();
                e1.setText("");
            }
        });

    }
}
