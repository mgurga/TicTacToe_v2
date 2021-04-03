package com.example.tictactoev1;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class tttAI {
    private int diff = 0;
    // 0 = easy
    //      - random moves
    // 1 = medium
    //      - takes winning plays when available
    //      - random moves
    // 2 = hard
    //      - takes strategic moves in the beginning of the game
    //      - stops user from winning
    //      - takes winning plays when available
    //      - random moves

    private int botpiece = 0;
    // 0 = nothing
    // 1 = opposing player (could switch)
    // 2 = AI (could switch)

    private int movenum = 0;

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

            if(lookForWin(board, botpiece)[0] != -1) {
                play = lookForWin(board, botpiece);
                Log.d("TTT", "[" + movenum + "] playing winning move: " + play[0] + ", " + play[1]);
            }
        } else if(diff == 2) {
            play = randomMove(board);

            if(movenum == 0) {
                play = goodStaringMove(board);
                Log.d("TTT", "[" + movenum + "] playing starting move: " + play[0] + ", " + play[1]);
            } else {
                int userpiece = botpiece + 1;
                if (userpiece == 3)
                        userpiece = 1;
                if(lookForWin(board, userpiece)[0] != -1) {
                    play = lookForWin(board, userpiece);
                    Log.d("TTT", "[" + movenum + "] stopping user win: " + play[0] + ", " + play[1]);
                }
                if(lookForWin(board, botpiece)[0] != -1) {
                    play = lookForWin(board, botpiece);
                    Log.d("TTT", "[" + movenum + "] playing winning move: " + play[0] + ", " + play[1]);
                }
            }
        }

        out[play[0]][play[1]] = botpiece;
        movenum++;

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

    public int[] lookForWin(int[][] board, int piece) {
        int[] out = new int[] {-1, -1};

        // check vertical row for possible win
        for(int i = 0; i < 3; i++) {
            int[] row = board[i];
            if(row[1] == row[2] && row[2] == piece && row[0] == 0) {
                out = new int[] {i, 0};
            }
            if(row[0] == row[1] && row[1] == piece && row[2] == 0) {
                out = new int[] {i, 2};
            }
            if(row[0] == row[2] && row[2] == piece && row[1] == 0) {
                out = new int[] {i, 1};
            }
        }

        // check column for possible win
        for(int i = 0; i < 3; i++) {
            int[] col = new int[] {board[0][i], board[1][i], board[2][i]};
            if(col[1] == col[2] && col[2] == piece && col[0] == 0) {
                out = new int[] {0, i};
            }
            if(col[0] == col[2] && col[2] == piece && col[1] == 0) {
                out = new int[] {1, i};
            }
            if(col[0] == col[1] && col[1] == piece && col[2] == 0) {
                out = new int[] {2, i};
            }
        }

        //check diagonals
        int[] diag = new int[] {board[0][0], board[1][1], board[2][2]};
        if(diag[1] == diag[2] && diag[2] == piece && diag[0] == 0) {
            out = new int[] {0, 0};
        }
        if(diag[0] == diag[2] && diag[2] == piece && diag[1] == 0) {
            out = new int[] {1, 1};
        }
        if(diag[0] == diag[1] && diag[1] == piece && diag[2] == 0) {
            out = new int[] {2, 2};
        }

        diag = new int[] {board[0][2], board[1][1], board[2][0]};
        if(diag[1] == diag[2] && diag[2] == piece && diag[0] == 0) {
            out = new int[] {0, 2};
        }
        if(diag[0] == diag[2] && diag[2] == piece && diag[1] == 0) {
            out = new int[] {1, 1};
        }
        if(diag[0] == diag[1] && diag[1] == piece && diag[2] == 0) {
            out = new int[] {2, 0};
        }

        return new int[] {out[0], out[1]};
    }

    public int[] goodStaringMove(int[][] board) {
        ArrayList<int[]> goodMoves = new ArrayList<int[]>();
        goodMoves.add(new int[] {0, 0});
        goodMoves.add(new int[] {0, 2});
        goodMoves.add(new int[] {1, 1});
        goodMoves.add(new int[] {0, 2});
        goodMoves.add(new int[] {2, 2});

        int[] out = new int[] {1, 1};

        while(board[out[0]][out[1]] != 0) {
            out = goodMoves.get(rand.nextInt(goodMoves.size()));
        }

        return out;
    }

    public int getMovenum() {
        return movenum;
    }

    public void setMovenum(int movenum) {
        this.movenum = movenum;
    }
}
