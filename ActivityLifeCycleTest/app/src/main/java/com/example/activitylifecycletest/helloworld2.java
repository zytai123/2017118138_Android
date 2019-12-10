package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class helloworld2 extends AppCompatActivity {
    public static final String TAG3="helloworld3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG3,"onCreate");
        setContentView(R.layout.helloworld2_layout);

        Button startHelloworld3Activity=(Button) findViewById(R.id.start_helloworld3_activity);
        startHelloworld3Activity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(helloworld2.this, helloworld3.class);
                startActivity(intent);
            }
        });

        Button startHelloworld1Activity=(Button) findViewById(R.id.start_helloworld1_activity);
        startHelloworld1Activity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(helloworld2.this, helloworld1.class);
                startActivity(intent);
            }
        });
    }


    protected void onStart(){
        super.onStart();
        Log.d(TAG3,"onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG3,"onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG3,"onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG3,"onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG3,"onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG3,"onRestart");
    }


}
