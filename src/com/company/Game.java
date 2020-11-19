package com.company;

public class Game {
    private char[][] board;
    private char currentPlayer;

    public Game() {
        board = new char[3][3];
        currentPlayer = 'O';
        initializeBoard();


    }

    public void changePlayer() {
        if (currentPlayer == 'O')
            currentPlayer = 'X';
        else
            currentPlayer = 'O';
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }

        }
    }

    public boolean choice(int row,int column){

        if(row >= 0 && row <3) {
            if (column >= 0 && column < 3) {
                if (board[row][column] == '-') {
                    board[row][column] = currentPlayer;
                    return true;
                }else{
                    System.out.println("the Place is taken");
                    changePlayer();
                }
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
                System.out.println();
        }
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    isFull = false;
            }
        }
        return isFull;
    }

    public boolean checkWin() {
        return (checkRowWin() || checkColumnWin() || checkDiagonalsForWin());
    }

    private boolean checkRowWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRaw(board[i][0], board[i][1], board[i][2]) == true)
                return true;
        }
        return false;
    }

    private boolean checkColumnWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRaw(board[0][i], board[1][i], board[2][i]) == true)
                return true;
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return (checkRaw(board[0][0], board[1][1], board[2][2])
                || checkRaw(board[0][2], board[1][1], board[2][0]));
    }

    private boolean checkRaw(char one, char two, char tree) {
        return (one!= '-' && one == two && two == tree);
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }



}
