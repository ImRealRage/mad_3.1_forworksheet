package com.example.exp_33_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonPopMenu, buttonActionTaskbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPopMenu = findViewById(R.id.buttonPopMenu);
        buttonPopMenu.setOnClickListener(this::showPopupMenu);

        buttonActionTaskbar = findViewById(R.id.buttonActionTaskbar);
        buttonActionTaskbar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CustomizedActionTaskbarActivity.class);
            startActivity(intent);
        });
    }

    private void showPopupMenu(View v) {
        // Creating the instance of PopupMenu
        PopupMenu popup = new PopupMenu(MainActivity.this, v);
        // Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());

        // Registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                // Displaying the selected item name
                Toast.makeText(MainActivity.this, "Selected Game: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show(); // Showing popup menu
    }
}
