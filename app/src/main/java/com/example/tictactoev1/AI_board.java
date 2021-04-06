package com.example.tictactoev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
    boolean latestMovePlayer = true;

    // BOARD PIECES
    // Nothing = 0
    // X = 1
    // O = 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int diff = intent.getIntExtra("difficulty", 1);

        AI = new tttAI(diff, 2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setText("");
            }
        }

        xScore = findViewById(R.id.xScore);
        yScore = findViewById(R.id.yScore);

        ((TextView) findViewById(R.id.xwinslabel)).setText("X Wins (User):");
        ((TextView) findViewById(R.id.owinslabel)).setText("O Wins (Bot):");

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void resetGame() {
        xWins = 0;
        yWins = 0;
        xScore.setText(xWins + "");
        yScore.setText(yWins + "");
        resetBoard();
    }

    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }

        ((Button) view).setText("X");
        latestMovePlayer = true;

        if (checkForWin()) {
            Log.d("TTT", "USER won");
            playerUSERWins();
        } else if (checkForDraw()) {
            gameDraw();
        } else {
            // AI makes play
            updateBoard(AI.makePlay(boardToInt()));
            latestMovePlayer = false;

            if(checkForDraw())
                gameDraw();
            if(checkForWin()) {
                Log.d("TTT", "AI won");
                playerAIWins();
            }
        }

        // make sure board colors are correct
        updateBoard(boardToInt());
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

    private void updateBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case 0:
                        buttons[i][j].setText("");
                        break;
                    case 1:
                        buttons[i][j].setText("X");
                        buttons[i][j].setTextColor(getResources().getColor(R.color.black));
                        break;
                    case 2:
                        buttons[i][j].setText("O");
                        buttons[i][j].setTextColor(getResources().getColor(R.color.white));
                        break;
                }
            }
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

    private boolean checkForDraw() {
        int totalplacements = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(buttons[i][j].getText().equals("X") || buttons[i][j].getText().equals("O")) {
                    totalplacements++;
                }
            }
        }

        // Log.d("TTT", "Board Placements: " + totalplacements);
        // Log.d("TTT", (totalplacements == 8 ? true : false) + "");

        return totalplacements == 9 && !checkForWin();
    }

    private void playerUSERWins() {
        // takes to screen where it says player one won
        Toast.makeText(AI_board.this, ("X wins!"), Toast.LENGTH_SHORT).show();
        xWins++;
        xScore.setText(xWins + "");
        resetBoard();
    }

    private void playerAIWins() {
        // takes to screen where it says player one won
        Toast.makeText(AI_board.this, ("O wins!"), Toast.LENGTH_SHORT).show();
        yWins++;
        yScore.setText(yWins + "");
        resetBoard();
    }

    private void gameDraw() {
        Toast.makeText(AI_board.this, ("Nobody wins!"), Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void resetBoard() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }
                AI.setMovenum(0);
            }
        }, 2500);
    }
}