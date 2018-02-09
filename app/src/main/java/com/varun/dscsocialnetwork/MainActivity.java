package com.varun.dscsocialnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.loginButton);
        final EditText e1 = (EditText) findViewById(R.id.userName);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e1.getEditableText().toString();
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            }
        });








    }
}
