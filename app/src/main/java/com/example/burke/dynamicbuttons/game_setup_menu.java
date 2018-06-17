package com.example.burke.dynamicbuttons;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class game_setup_menu extends Activity{

    Button addBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);

        // Getting element id's.
        addBTN = findViewById(R.id.add_button);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String numPlayers = intent.getStringExtra("Num of Players");


        // Add button listener.
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewButt();
            }
        });

    }

    public void twoPlayer(View v){
        String lol = "player";
        for(int i = 1; i<3; i++){
            TextView player = new TextView(this);
            Button p_count = new Button(this);

            player.setId(Integer.parseInt("player" + i));
            p_count.setId(Integer.parseInt("player" + i + "_btn"));
        }

    }


    public void addNewButt() {
        Button myButton = new Button(this);
        myButton.setText("press me");

        LinearLayout ll = findViewById(R.id.LL_button);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(myButton, lp);
    }
}
