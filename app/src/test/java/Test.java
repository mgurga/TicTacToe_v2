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

}
