package com.examplcoue.mazen.thanwya;

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

public class RegisterActivity extends AppCompatActivity implements AsyncCallback<BackendlessUser> {
    EditText nameText,passText,mailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameText=findViewById(R.id.nameText);
        passText=findViewById(R.id.passText);
        mailText=findViewById(R.id.mailText);
    }

    public void regBtn(View view) {
        BackendlessUser user = new BackendlessUser();
        user.setEmail(mailText.getText().toString());
        user.setPassword(passText.getText().toString());
        user.setProperty("name",nameText.getText().toString());
        Backendless.UserService.register(user,this);
    }

    @Override
    public void handleResponse(BackendlessUser response) {
        Toast.makeText(this, "User has been registered", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleFault(BackendlessFault fault) {
        Toast.makeText(this, "An error has been occurred", Toast.LENGTH_SHORT).show();

    }
}
