package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game ticTac = new Game();
        ticTac.printBoard();

        System.out.println("please Chose your Mark(O or X)");
        String select = input.next();
        if(select.equals("X") ){
            ticTac.setCurrentPlayer('X');
            System.out.println("player One play as "+ticTac.getCurrentPlayer());
            System.out.println("player Two play as O");
        }else if(select.equals("O")){
            ticTac.setCurrentPlayer('O');
            System.out.println("player One play as "+ticTac.getCurrentPlayer());
            System.out.println("player Two play as X");
        }


        while (true) {
            System.out.println(ticTac.getCurrentPlayer()+" Enter your number");
            int r = input.nextInt();
            int c = input.nextInt();
            if(r<3&&c<3) {
                ticTac.choice(r, c);
                ticTac.printBoard();
                ticTac.changePlayer();
            }
            if (ticTac.checkWin()) {
                System.out.println("we have a winner!");
                System.out.println("Do you Want to play Again?(Y/N)");
                String answer = input.next();
                if(answer.equals("Y")){
                    ticTac.initializeBoard();
                }else{
                break;
                }
            }
            if(ticTac.isBoardFull()) {
                System.out.println("draw!");
                System.out.println("Do you Want to play Again?(Y/N)");
                String answer = input.next();
                if(answer.equals("Y")){
                    ticTac.initializeBoard();
                }else{
                    break;
                }
            }
        }
    }


}
