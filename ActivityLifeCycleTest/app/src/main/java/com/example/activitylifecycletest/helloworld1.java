package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class helloworld1 extends AppCompatActivity {
    public static final String TAG="helloworld1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.helloworld1_layout);
        Button startHelloworld2Activity=(Button) findViewById(R.id.start_helloworld2_activity);
        startHelloworld2Activity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(helloworld1.this, helloworld2.class);
                startActivity(intent);
            }
        });

        Button startHelloworld3Activity=(Button) findViewById(R.id.start_helloworld3_activity);
        startHelloworld3Activity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
             Intent intent=new Intent(helloworld1.this, helloworld3.class);
             startActivity(intent);
            }
        });

    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }




}
