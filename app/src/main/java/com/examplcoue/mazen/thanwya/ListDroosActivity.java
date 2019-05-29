package com.examplcoue.mazen.thanwya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class ListDroosActivity extends AppCompatActivity implements AsyncCallback<List<Droos>> {
    ListView droosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_droos);
        droosList=findViewById(R.id.droosList);
        DataQueryBuilder queryBuilder=DataQueryBuilder.create();
        Backendless.Data.of(Droos.class).find(queryBuilder,this);
    }

    @Override
    public void handleResponse(List<Droos> response) {
        ArrayList <String> dros=new ArrayList<>();
        for (Droos droos : response) {
            dros.add(droos.getName());
        }
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,dros);
        droosList.setAdapter(adapter);

    }

    @Override
    public void handleFault(BackendlessFault fault) {

    }
}
