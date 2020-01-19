package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String mOrderMessage;
    public static final String EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE";
    private TextView donutDescription, iceCreamDescription, froyoDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });

        List<TextView> lista = new ArrayList<>();

        donutDescription = findViewById(R.id.donut_description);
        iceCreamDescription = findViewById(R.id.ice_cream_description);
        froyoDescription = findViewById(R.id.froyo_description);

        lista.add(donutDescription);
        lista.add(iceCreamDescription);
        lista.add(froyoDescription);
        registrarContextos(lista);

    }

    private void registrarContextos(List<TextView> lista){
        for (TextView elemento : lista) {
            registerForContextMenu(elemento);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;

            case R.id.action_status:
                Intent intent2 = new Intent(MainActivity.this, DialogAlert.class);
                startActivity(intent2);
                return true;

            case R.id.action_favorites:
                Intent intent3 = new Intent(MainActivity.this,PickerDate.class);
                startActivity(intent3);
                return true;

            case R.id.action_contact:
                Intent intent4 = new Intent(MainActivity.this,PickerHour.class);
                startActivity(intent4);
                return true;

            default:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.context_edit:
                displayToast("Opcion de edicion");
                return true;
            case R.id.context_share:
                displayToast("Opcion de compartir");
                return true;
            case R.id.context_delete:
                displayToast("Opcion de borrar");
                return true;
            default:
                return super.onContextItemSelected(item);
        }


    }

    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage
        );
    }

    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


}
