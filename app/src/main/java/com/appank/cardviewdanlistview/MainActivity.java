package com.appank.cardviewdanlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final  String TAG = "MainActivity";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        listView = (ListView) findViewById(R.id.listview);
        ArrayList<cards> list = new ArrayList<>();
        list.add(new cards("drawable://" + R.drawable.ic_launcher_background,"Beru","Marshal","Attack"));
        list.add(new cards("drawable://" + R.drawable.ic_launcher_background,"Igris","Knight","Attack"));
        list.add(new cards("drawable://" + R.drawable.ic_launcher_background,"Iron","Elite Knight","Taunt"));
        list.add(new cards("drawable://" + R.drawable.ic_launcher_background,"Kaisel","Knight","-"));
        list.add(new cards("drawable://" + R.drawable.ic_launcher_background,"Tank","Elite","Tank"));
        list.add(new cards("drawable://" + R.drawable.ic_launcher_background,"Tusk","Elite Knight","Magic"));
        CostumListAdapter  adapter =new CostumListAdapter(this,R.layout.activity_main,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Toast.makeText(MainActivity.this, "Beru", Toast.LENGTH_SHORT).show();
                }
                else if (position==1){
                    Toast.makeText(MainActivity.this, "Igris", Toast.LENGTH_SHORT).show();

                } else if (position==2){
                    Toast.makeText(MainActivity.this, "Iron", Toast.LENGTH_SHORT).show();

                } else if (position==3){
                    Toast.makeText(MainActivity.this, "Kaisel", Toast.LENGTH_SHORT).show();

                } else if (position==4){
                    Toast.makeText(MainActivity.this, "Tank", Toast.LENGTH_SHORT).show();

                } else if (position==5){
                    Toast.makeText(MainActivity.this, "Tusk", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}