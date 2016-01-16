package com.example.test4.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView li;
    List<String> lis=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=(ListView)findViewById(R.id.list_view);
        lis.add("monitor");
        lis.add("kayboard");
        lis.add("chips");
        lis.add("fan");
        lis.add("smps");
        lis.add("buttons");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,lis);
        li.setAdapter(adapter);
        registerForContextMenu(li);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.model,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch(item.getItemId())
        {
            case R.id.delete_id :
            lis.remove(info.position);
            adapter.notifyDataSetChanged();
                return true;
            default:return super.onContextItemSelected(item);
        }

    }
}
