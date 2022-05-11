package com.example.assignment8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button showbtn;
    Button showConbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showbtn=findViewById(R.id.showbtn);
        showConbtn=findViewById(R.id.showcontextbtn);
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu menu = new PopupMenu(MainActivity.this, showbtn);
                menu.getMenuInflater().inflate(R.menu.popup_menu, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        Toast.makeText(MainActivity.this, "You clcked "+ menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        return true;
                    }
                });

                menu.show();
            }
        });

        registerForContextMenu(showConbtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.context_menu, menu);

    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.download){
            Toast.makeText(MainActivity.this, "You selected "+item.toString(), Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.play){
            Toast.makeText(MainActivity.this, "You selected "+item.toString(), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "You selected "+item.toString(), Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

}