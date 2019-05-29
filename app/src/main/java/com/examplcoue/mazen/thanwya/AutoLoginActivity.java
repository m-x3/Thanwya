package com.examplcoue.mazen.thanwya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.backendless.Backendless;

public class AutoLoginActivity extends AppCompatActivity {

    TextView seeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_login);
        seeText=findViewById(R.id.seeText);
        Backendless.initApp(this,"6737D1A5-FC13-C7B1-FFE1-B657C2B51300","6AA2BFE2-9A33-B4EF-FF8D-E69DEAC45700");

        SharedPreferences preferences = this.getSharedPreferences("myPref", 0);
        String mail = preferences.getString("mail", null);
        if (mail!=null){

            Intent intent=new Intent(this,ListDroosActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);

        }
    }
}
