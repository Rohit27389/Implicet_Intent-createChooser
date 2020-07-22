package com.example.implecit_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.b1);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Uri webpage=Uri.parse("http://www.google.com");
                Uri sms=Uri.parse("smsto:123");
                Intent intent=new Intent(Intent.ACTION_SENDTO,sms);
                Intent chooserIntent=Intent.createChooser(intent,"select the app...");
                if(chooserIntent.resolveActivity(getPackageManager())!=null)
                    startActivity(chooserIntent);
            }
        };
        button.setOnClickListener(listener);
    }
}