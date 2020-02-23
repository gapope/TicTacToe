package com.example.tictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private int states[] = new int[9];
    private int playerTurn = 1;
    private boolean playing = true;

    ImageView sq[] = new ImageView[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button start = findViewById(R.id.quitButton);
        start.setOnClickListener(this);

        sq[0] = findViewById(R.id.Sq1);
        sq[0].setOnClickListener(this);

        sq[1] = findViewById(R.id.Sq2);
        sq[1].setOnClickListener(this);

        sq[2] = findViewById(R.id.Sq3);
        sq[2].setOnClickListener(this);

        sq[3] = findViewById(R.id.Sq4);
        sq[3].setOnClickListener(this);

        sq[4] = findViewById(R.id.Sq5);
        sq[4].setOnClickListener(this);

        sq[5] = findViewById(R.id.Sq6);
        sq[5].setOnClickListener(this);

        sq[6] = findViewById(R.id.Sq7);
        sq[6].setOnClickListener(this);

        sq[7] = findViewById(R.id.Sq8);
        sq[7].setOnClickListener(this);

        sq[8] = findViewById(R.id.Sq9);
        sq[8].setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int square = 0;

        switch (v.getId()) {
            case R.id.quitButton:
                Intent actIntent = new Intent(v.getContext(), MenuActivity.class);
                startActivityForResult(actIntent, 0);
                break;

            case R.id.Sq1:
                square = 0;
                break;

            case R.id.Sq2:
                square = 1;
                break;

            case R.id.Sq3:
                square = 2;
                break;

            case R.id.Sq4:
                square = 3;
                break;

            case R.id.Sq5:
                square = 4;
                break;

            case R.id.Sq6:
                square = 5;
                break;

            case R.id.Sq7:
                square = 6;
                break;

            case R.id.Sq8:
                square = 7;
                break;

            case R.id.Sq9:
                square = 8;
                break;
        }

        if (playing && states[square] == 0) {
            if (playerTurn == 1) {
                sq[square].setBackgroundColor(0xffcc0000);
            } else {
                sq[square].setBackgroundColor(0xff33b5e5);
            }

            states[square] = playerTurn;

            int win = checkWin();

            if (win == -2) {
                Toast toast = Toast.makeText(this, "Tie", Toast.LENGTH_SHORT);
                toast.show();
                playing = false;
            } else if (win != 0) {
                Toast toast = Toast.makeText(this, ((playerTurn == 1) ? "Player 1" : "Player 2") +" wins", Toast.LENGTH_SHORT);
                toast.show();
                playing = false;
            }

            playerTurn *= -1;
        }
    }


    private int checkWin() {
        //Horizontal lines
        for (int i = 0; i <= 6; i += 3) {
            if (states[i] != 0 && states[i] == states[i+1] && states[i+1] == states[i+2]) {
                return states[i];
            }
        }

        //Vertical lines
        for (int i = 0; i < 3; i++) {
            if (states[i] != 0 && states[i] == states[i+3] && states[i+3] == states[i+6]) {
                return states[i];
            }
        }

        //Diagonals
        if (states[4] != 0) {
            if (states[0] == states[4] && states[4] == states[8] ||
                states[6] == states[4] && states[4] == states[2]) {
                return states[4];
            }
        }

        for (int i = 0; i < states.length; i++) {
            if (states[i] == 0) return 0;
        }

        return -2;
    }

}
