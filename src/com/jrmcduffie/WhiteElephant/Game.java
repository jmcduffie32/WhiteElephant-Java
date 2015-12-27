package com.jrmcduffie.WhiteElephant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by bobber on 12/27/2015.
 */
public class Game {
    ArrayList<Item> itemList= new ArrayList<Item>();
    double averageValue;
    Scanner scanner = new Scanner(System.in);

    public void showChoices() {
        String prompt = "What would you like to do?\n" +
                "1: add item\n" +
                "2: mark item stolen\n" +
                "3: suggest item to take\n" +
                "q: quit";
        System.out.println(prompt);
    }

    public void choose(String choice) {
        switch (choice) {
            case "1":
                addItem();
                break;
            case "2":
                stealItem();
                break;
            case "3":
                suggestItem();
                break;
            case "q":
                break;
            default:
                System.out.println("PLEASE MAKE A VALID CHOICE.");
        }
    }

    private void addItem() {
        System.out.println("What is the item called?");
        String itemName = scanner.nextLine();
        System.out.println("What is the item's rank");
        int itemRank = Integer.parseInt(scanner.nextLine());

        itemList.add(new Item(itemName, itemRank));
        calculateAverageValue();
    }
    private void stealItem(){
        int index = 0;
        for (Item item : itemList) {
            System.out.println(index + ": " + item);
            index++;
        }
        System.out.println("Which item was stolen? (enter the number)");

        int choice = Integer.parseInt(scanner.nextLine());
        itemList.get(choice).steal(itemList);

    }
    private void suggestItem(){
        Item suggestedItem = Collections.max(itemList);
        if (suggestedItem.rank < averageValue || suggestedItem.wasJustStolen) {
            System.out.println("Open a new one!");
        } else {
            System.out.println(suggestedItem);
        }
    }

    private void calculateAverageValue() {
        double sum = 0;
        for (Item item : itemList) {
            sum += item.rank;
        }

        averageValue = sum/itemList.size();
    }

}
