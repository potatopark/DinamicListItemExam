package com.example.user.a6_dinamiclistitemexam;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.a6_dinamiclistitemexam.adapter.ItemAdapter;
import com.example.user.a6_dinamiclistitemexam.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, View.OnClickListener{

    public static int NUM = 0;

    List<Item> list;
    ItemAdapter adapter;
    ListView listView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Item>();
        adapter = new ItemAdapter(this,R.layout.list_item,list);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        listView.setOnItemClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = editText.getText().toString().trim();
        NUM++;

        Item item = new Item(NUM,input);
        adapter.insert(item,0);

        editText.setText("");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = adapter.getItem(position);
        String output = item.getNum() + " / " + item.getName();
        Toast.makeText(this,output,Toast.LENGTH_SHORT).show();
    }
}
