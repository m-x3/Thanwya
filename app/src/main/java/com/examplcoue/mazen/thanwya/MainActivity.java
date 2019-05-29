package com.examplcoue.mazen.thanwya;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainActivity extends AppCompatActivity implements AsyncCallback<BackendlessUser> {
    EditText passText,mailText;
    TextView regText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passText=findViewById(R.id.passText);
        mailText=findViewById(R.id.nameText);
        regText=findViewById(R.id.regText);
    }

    public void loginBtn(View view) {
        Backendless.UserService.login(mailText.getText().toString(),passText.getText().toString(),this);


    }

    public void register(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);

    }

    @Override
    public void handleResponse(BackendlessUser response) {

        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        SharedPreferences preferences=this.getSharedPreferences("myPref",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("mail",mailText.getText().toString());
        editor.apply();

        Intent intent=new Intent(MainActivity.this,AddDrsActivity.class);
        startActivity(intent);
    }

    @Override
    public void handleFault(BackendlessFault fault) {
        if (fault.getCode().equals("3003"))
            Toast.makeText(this, "Invalid Data", Toast.LENGTH_SHORT).show();
        else
        Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show();


    }
}
