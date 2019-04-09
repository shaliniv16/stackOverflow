package com.example.shaliniverma.stackoverflow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserInterestActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    TextView itemSelected;
    String[] listItem;
    Button submit;
    String showText = "";
    int counter = 0;
    ArrayList<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest);
        listView = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);
        itemSelected = (TextView) findViewById(R.id.item_selected);
        submit = (Button)findViewById(R.id.submit);
        listItem = getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // TODO Auto-generated method stub
                    if (counter >= 4) {
                        Toast.makeText(getApplicationContext(), "Click submit button to proceed", Toast.LENGTH_SHORT).show();
                    } else {
                        String value = adapter.getItem(position);
                        if(arrayList.contains(value)){
                            Toast.makeText(getApplicationContext(), "Already Selected", Toast.LENGTH_SHORT).show();
                        } else {
                            arrayList.add(value);
                            showText += value + " ";
                            itemSelected.setText(showText);
                            counter++;
                        }
                    }
                }
            });
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(counter == 4) {
                        Intent intent = new Intent(UserInterestActivity.this,MainActivity.class);
                        intent.putExtra("Selected Items",arrayList);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Please select four options", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
