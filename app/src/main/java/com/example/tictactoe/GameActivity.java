package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button start = findViewById(R.id.quitButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actIntent = new Intent(v.getContext(), MenuActivity.class);
                startActivityForResult(actIntent, 0);
            }
        });
    }

    /*
    private void checkWin() {

    }
    */
}
