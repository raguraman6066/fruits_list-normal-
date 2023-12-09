package com.example.fruitslistnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] bowl;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listview);
        //create data
        createData();
        //populate data in listview
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bowl);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(MainActivity.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show());
      lv.setOnItemClickListener((adapterView, view, i, l) -> {
          Toast.makeText(MainActivity.this, bowl[i], Toast.LENGTH_SHORT).show();
      });
        CustomListView customLV = new CustomListView();
        lv.setAdapter(customLV);
    }

    public class CustomListView extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.one_item_design, viewGroup, false);
            }
            ImageView image = view.findViewById(R.id.fruits_image);
            TextView text = view.findViewById(R.id.fruits_name);
            image.setImageResource(images[i]);
            text.setText(bowl[i]);
            return view;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
    }

    private void createData() {
        bowl = new String[10];
        bowl[0] = "apple";
        bowl[1] = "banana";
        bowl[2] = "kiwi";
        bowl[3] = "lemon";
        bowl[4] = "lime";
        bowl[5] = "mango";
        bowl[6] = "orange";
        bowl[7] = "pear";
        bowl[8] = "pineapple";
        bowl[9] = "plum";


        images = new int[10];
        images[0] = R.drawable.a;
        images[1] = R.drawable.b;
        images[2] = R.drawable.c;
        images[3] = R.drawable.l;
        images[4] = R.drawable.lime;
        images[5] = R.drawable.mango;
        images[6] = R.drawable.orange;
        images[7] = R.drawable.pine;
        images[8] = R.drawable.a;
        images[9] = R.drawable.b;
    }
}