package com.examplcoue.mazen.thanwya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

public class AddDrsActivity extends AppCompatActivity implements AsyncCallback<Droos> {

    EditText drsName,drsInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drs);
        drsName=findViewById(R.id.drsName);
        drsInfo=findViewById(R.id.drsInfo);

    }

    public void addDrs(View view) {
        Droos droos=new Droos();
        droos.setName(drsName.getText().toString());
        droos.setInfo(drsInfo.getText().toString());
        droos.saveAsync(this);

    }

    @Override
    public void handleResponse(Droos response) {
        drsName.setText("");
        drsInfo.setText("");
        Toast.makeText(this, "Dasrs has been saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleFault(BackendlessFault fault) {
        Toast.makeText(this, "Error has been occurred", Toast.LENGTH_SHORT).show();


    }

    public void show(View view) {
        Intent intent=new Intent(this,ListDroosActivity.class);
        startActivity(intent);
    }
}
