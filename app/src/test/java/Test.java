import com.example.tictactoev1.tttAI;

import static org.junit.Assert.*;

public class Test {

    // BOARD PIECES
    // Nothing = 0
    // X = 1
    // O = 2

    @org.junit.Test
    public void goodStartingMoveUntaken1() {
        // Bot plays as Os and "User" as Xs, hard difficulty
        // "User" does not place a X on designated starting moves
        tttAI AI = new tttAI(2, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {1, 0, 0},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);

        assertTrue(testBoard[0][0] == 2 ||
                        testBoard[0][2] == 2 ||
                        testBoard[1][1] == 2 ||
                        testBoard[2][0] == 2 ||
                        testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void goodStartingMoveUntaken2() {
        // Bot plays as Os and "User" as Xs, hard difficulty
        // "User" does not place a X on designated starting moves
        tttAI AI = new tttAI(2, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 0, 1},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[1][1] == 2 ||
                testBoard[2][0] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void goodStartingMoveUntaken3() {
        // Bot plays as Os and "User" as Xs, hard difficulty
        // "User" does not place a X on designated starting moves
        tttAI AI = new tttAI(2, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 0, 0},
                new int[] {0, 1, 0}
        };

        testBoard = AI.makePlay(testBoard);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[1][1] == 2 ||
                testBoard[2][0] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void goodStartingMoveTaken1() {
        // Bot plays as Os and "User" as Xs, hard difficulty
        // "User" places an X on designated starting moves
        tttAI AI = new tttAI(2, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 1, 0},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[2][0] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void goodStartingMoveTaken2() {
        // Bot plays as Os and "User" as Xs, hard difficulty
        // "User" places an X on designated starting moves
        tttAI AI = new tttAI(2, 2);

        int[][] testBoard = new int[][] {
                new int[] {1, 0, 0},
                new int[] {0, 0, 0},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);

        assertTrue(testBoard[0][2] == 2 ||
                testBoard[1][1] == 2 ||
                testBoard[2][0] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void goodStartingMoveTaken3() {
        // Bot plays as Os and "User" as Xs, hard difficulty
        // "User" places an X on designated starting moves
        tttAI AI = new tttAI(2, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 0, 0},
                new int[] {0, 0, 1}
        };

        testBoard = AI.makePlay(testBoard);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[1][1] == 2 ||
                testBoard[2][0] == 2);
    }

    @org.junit.Test
    public void randomMove1() {
        // Bot plays as Os and "User" as Xs, easy difficulty
        // Bot makes a random play based on already existing board
        tttAI AI = new tttAI(0, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {2, 1, 0},
                new int[] {1, 2, 1}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(5);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][1] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[1][2] == 2);
    }

    @org.junit.Test
    public void randomMove2() {
        // Bot plays as Os and "User" as Xs, easy difficulty
        // Bot makes a random play based on already existing board
        tttAI AI = new tttAI(0, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {2, 1, 0},
                new int[] {1, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(3);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][1] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[1][2] == 2 ||
                testBoard[2][1] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void randomMove3() {
        // Bot plays as Os and "User" as Xs, easy difficulty
        // Bot makes a random play based on already existing board
        tttAI AI = new tttAI(0, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 2, 1},
                new int[] {2, 1, 0},
                new int[] {1, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(5);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[1][2] == 2 ||
                testBoard[2][1] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void randomMove4() {
        // Bot plays as Os and "User" as Xs, easy difficulty
        // Bot makes a random play based on already existing board
        tttAI AI = new tttAI(0, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 0, 0},
                new int[] {0, 1, 0},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(1);

        assertTrue(testBoard[0][0] == 2 ||
                testBoard[0][1] == 2 ||
                testBoard[0][2] == 2 ||
                testBoard[1][0] == 2 ||
                testBoard[1][2] == 2 ||
                testBoard[2][0] == 2 ||
                testBoard[2][1] == 2 ||
                testBoard[2][2] == 2);
    }

    @org.junit.Test
    public void randomMove5() {
        // Bot plays as Os and "User" as Xs, easy difficulty
        // Bot makes a random play based on already existing board
        tttAI AI = new tttAI(0, 2);

        int[][] testBoard = new int[][] {
                new int[] {1, 2, 1},
                new int[] {2, 1, 0},
                new int[] {1, 0, 2}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(7);

        assertTrue(testBoard[1][2] == 2 ||
                testBoard[2][1] == 2);
    }

    @org.junit.Test
    public void playWinningMove1() {
        // Bot plays as Os and "User" as Xs, medium difficulty
        // Bot finds the winning move and returns it
        tttAI AI = new tttAI(1, 2);

        int[][] testBoard = new int[][] {
                new int[] {1, 2, 1},
                new int[] {2, 2, 1},
                new int[] {1, 0, 2}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(8);

        assertEquals(testBoard[2][1], 2);
    }

    @org.junit.Test
    public void playWinningMove2() {
        // Bot plays as Os and "User" as Xs, medium difficulty
        // Bot finds the winning move and returns it
        tttAI AI = new tttAI(1, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 2, 2},
                new int[] {0, 1, 0},
                new int[] {0, 0, 1}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(4);

        assertEquals(testBoard[0][0], 2);
    }

    @org.junit.Test
    public void playWinningMove3() {
        // Bot plays as Os and "User" as Xs, medium difficulty
        // Bot finds the winning move and returns it
        tttAI AI = new tttAI(1, 2);

        int[][] testBoard = new int[][] {
                new int[] {2, 1, 0},
                new int[] {0, 2, 1},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(4);

        assertEquals(testBoard[2][2], 2);
    }

    @org.junit.Test
    public void playWinningMove4() {
        // Bot plays as Os and "User" as Xs, medium difficulty
        // Bot finds the winning move and returns it
        tttAI AI = new tttAI(1, 2);

        int[][] testBoard = new int[][] {
                new int[] {2, 1, 0},
                new int[] {2, 1, 1},
                new int[] {0, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(5);

        assertEquals(testBoard[2][0], 2);
    }

    @org.junit.Test
    public void playWinningMove5() {
        // Bot plays as Os and "User" as Xs, medium difficulty
        // Bot finds the winning move and returns it
        tttAI AI = new tttAI(1, 2);

        int[][] testBoard = new int[][] {
                new int[] {0, 1, 0},
                new int[] {1, 2, 1},
                new int[] {2, 0, 0}
        };

        testBoard = AI.makePlay(testBoard);
        AI.setMovenum(5);

        assertEquals(testBoard[0][2], 2);
    }

}
