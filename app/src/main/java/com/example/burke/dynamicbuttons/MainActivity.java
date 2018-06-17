package com.example.burke.dynamicbuttons;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends Activity {

    Spinner playerNumSPIN;
    Button nextBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting element id's.
        playerNumSPIN = findViewById(R.id.num_players_spin);
        nextBTN = findViewById(R.id.next_btn);


        // Creating & setting spinner & adapter.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.num_of_players, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        playerNumSPIN.setAdapter(adapter);


        // Click listener for Next button.
        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextBTN_clicked(view);
            }
        });
    }

    public void nextBTN_clicked(View v){
        String numOfPlayers = playerNumSPIN.getSelectedItem().toString();

        Intent intent = new Intent(this, game_setup_menu.class);

        switch (numOfPlayers){
            case "2":
                intent.putExtra("Num of Players", "2");
                startActivity(intent);
                break;
            case "3":
                intent.putExtra("Num of Players", "3");
                startActivity(intent);
                break;
            case "4":
                intent.putExtra("Num of Players", "4");
                startActivity(intent);
                break;
            case "5":
                intent.putExtra("Num of Players", "5");
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
