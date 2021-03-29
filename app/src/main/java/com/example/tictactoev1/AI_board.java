package com.example.tictactoev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AI_board extends AppCompatActivity implements View.OnClickListener{

    private Button[][] buttons = new Button[3][3];
    private tttAI AI = null;
    int xWins, yWins = 0;
    TextView xScore, yScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int diff = intent.getIntExtra("difficulty", 1);

        AI = new tttAI(diff, 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        xScore = findViewById(R.id.xScore);
        yScore = findViewById(R.id.yScore);
    }

    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }

        ((Button) view).setText("X");
        ((Button) view).setTextColor(getResources().getColor(R.color.black));

        if (checkForWin()) {
            Log.d("TTT", "someone won");
        } else {
            int[][] board = boardToInt();

        }
    }

    private void updateBoard() {

    }

    private void printBoardInt(int[][] board) {
        for(int i = 0; i < 3; i++) {
            String line = "";
            for(int j = 0; j < 3; j++) {
                line += board[i][j] + " ";
            }
            Log.d("TTT", line);
        }
    }

    private int[][] boardToInt() {
        int[][] out = new int[3][3];

        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getText().equals("X")) {
                    out[i][j] = 1;
                } else if(buttons[i][j].getText().equals("O")) {
                    out[i][j] = 2;
                } else {
                    out[i][j] = 0;
                }
            }
        }

        return out;
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
        return false;
    }

    private void playerOneWins() {
        // takes to screen where it says player one won
        Toast.makeText(AI_board.this, ("X wins!"), Toast.LENGTH_SHORT).show();
        xWins++;
        xScore.setText(xWins +"");
        resetBoard();
    }

    private void playerTwoWins() {
        // takes to screen where it says player one won
        Toast.makeText(AI_board.this, ("O wins!"), Toast.LENGTH_SHORT).show();
        yWins++;
        yScore.setText(yWins + "");
        resetBoard();
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
}