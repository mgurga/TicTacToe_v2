package com.example.tictactoev1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class tttAI {
    int diff = 0;
    // 0 = easy
    // 1 = medium
    // 2 = hard

    int botpiece = 0;
    // 0 = nothing
    // 1 = opposing player (could switch)
    // 2 = AI (could switch)

    Random rand = new Random();

    public tttAI(int diff, int botxo) {
        this.diff = diff;
        this.botpiece = botxo;
    }

    public int[][] makePlay(int[][] board) {
        int[][] out = new int[3][3];
        int[] play = new int[2];
        out = board;

        if(diff == 0) {
            play = randomMove(board);
        } else if(diff == 1) {
            play = randomMove(board);

            if(lookForWin(board)[0] != -1) {
                play = lookForWin(board);
            }
        }

        out[play[0]][play[1]] = botpiece;

        return out;
    }

    private int[] randomMove(int[][] board) {
        ArrayList<int[]> possiblemoves = new ArrayList<int[]>();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    possiblemoves.add(new int[] {i, j});
                }
            }
        }

        int[] out = new int[] {1, 1};

        while(board[out[0]][out[1]] != 0) {
            out = possiblemoves.get(rand.nextInt(possiblemoves.size()));
        }

        return out;
    }

    public int[] lookForWin(int[][] board) {

        int[] out = new int[] {-1, -1};

        for(int i = 0; i < 3; i++) {
            int[] row = board[i];

            if(row[1] == row[2] && row[2] == botpiece && row[0] == 0) {
                out = new int[] {i, 0};
            }

            if(row[0] == row[1] && row[1] == botpiece && row[2] == 0) {
                out = new int[] {i, 2};
            }

            if(row[0] == row[2] && row[2] == botpiece && row[1] == 0) {
                out = new int[] {i, 1};
            }
        }

        for(int i = 0; i < 3; i++) {
            int[] row = new int[] {board[i][0], board[i][1], board[i][2]};

            if(row[1] == row[2] && row[2] == botpiece && row[0] == 0) {
                out = new int[] {0, i};
            }

            if(row[0] == row[2] && row[2] == botpiece && row[1] == 0) {
                out = new int[] {1, i};
            }

            if(row[0] == row[1] && row[1] == botpiece && row[2] == 0) {
                out = new int[] {2, i};
            }
        }

        return out;
    }

}
