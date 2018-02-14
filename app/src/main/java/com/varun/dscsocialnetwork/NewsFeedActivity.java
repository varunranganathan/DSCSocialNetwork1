package com.varun.dscsocialnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        final DatabaseReference d1  =
                FirebaseDatabase.getInstance().
                        getReference("posts");
        d1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Post p1 = dataSnapshot.getValue(Post.class);
                String messageToDisplay = p1.getUserName()+": "+p1.getPostText();
                dataSource.add(messageToDisplay);
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = e1.getEditableText().toString();
                String pid = d1.push().getKey();
                Post p1 = new Post(userName, message, pid);
                d1.child(pid).setValue(p1);
                e1.setText("");
            }
        });

    }
}
