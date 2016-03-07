package com.example.sajidmacpro.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btnSumit;
    EditText edtInput;
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        edtInput=(EditText)findViewById(R.id.input);
        btnSumit=(Button)findViewById(R.id.btnSubmit);

        //Comparator comparator=Collections.reverseOrder();

       //Collections.sort(list,comparator);


        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        btnSumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=edtInput.getText().toString();
                list.add(input);
                edtInput.setText("");

                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);

            }
        });

        //final String[] studenList={"Sajid","Tajmul","Sami","Farook","Shohel","Rakin","Mohini","Prince","Totini"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

//        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String clickedItem=studenList[position];
                String clickedItem=list.get(position);
                Toast.makeText(getApplicationContext(),clickedItem+" Position= "+position,Toast.LENGTH_LONG).show();
            }
        });




    }
}
