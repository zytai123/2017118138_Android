package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class helloworld3 extends AppCompatActivity {
    public static final String TAG2="helloworld2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG2,"onCreate");
        setContentView(R.layout.helloworld3_layout);

        Button startHelloworld2Activity=(Button) findViewById(R.id.start_helloworld2_activity);
        startHelloworld2Activity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(helloworld3.this, helloworld2.class);
                startActivity(intent);
            }
        });

        Button startHelloworld1Activity=(Button) findViewById(R.id.start_helloworld1_activity);
        startHelloworld1Activity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(helloworld3.this, helloworld1.class);
                startActivity(intent);
            }
        });
    }


    protected void onStart(){
        super.onStart();
        Log.d(TAG2,"onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG2,"onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG2,"onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG2,"onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG2,"onDestroy");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG2,"onRestart");
    }

}
