package com.jrmcduffie.WhiteElephant;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        Game game = new Game();

        game.showChoices();
        choice = scanner.nextLine();

        while (!choice.equals("q")){
            game.choose(choice);
            game.showChoices();
            choice = scanner.nextLine();
        }


    }
}
