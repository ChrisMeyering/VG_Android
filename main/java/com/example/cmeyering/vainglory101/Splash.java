package com.example.cmeyering.vainglory101;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Splash extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final GridView gridview = (GridView) findViewById(R.id.myGV);
        gridview.setAdapter(new ImageAdapter(this, getList("names.txt")));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Splash.this, "" + gridview.getItemAtPosition(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public List<String> getList(String fileName)
    {
        AssetManager am = this.getAssets();
        BufferedReader in = null;
        List<String> list = new ArrayList<String>();
        try {
            in = new BufferedReader(new InputStreamReader(am.open(fileName)));
            String str;
            while((str = in.readLine()) != null)
            {
                list.add(str.toLowerCase());
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println("file not found");
        }
        catch(IOException e){
        System.out.println("ioexception");
        }
        return list;
    }

}
