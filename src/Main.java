/*This Object Oriented program calculates the cost of carpeting of a given area.*/
//Author: Daniel Magdziarz

import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        boolean quit = false;
        menu();
        int menuSelection;
        while(!quit){
            System.out.print("\tEnter Menu Selection: ");
            if(keyboard.hasNextInt()){
                menuSelection = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                String wrongInput = keyboard.nextLine();
                System.out.println('"' + wrongInput + "\" is a wrong input. Tray again.");
                continue;
            }

            switch(menuSelection){
                case 0 :
                    quit = true;
                    System.out.println("Bye... ");
                    break;
                case 1 :
                    menu();
                    break;
                case 2 :
                    carpetCostBasedArea();
                    break;
                case 3 :
                    carpetCostBasedWidthHeight();
                    break;
                default:
                    System.out.println("Wrong menu selection.");
                    break;
            }
        }
        keyboard.close();
    }

    //Calculate based on Area and Carpet Cost
    public static void carpetCostBasedArea(){
        System.out.println("Enter Area of the floor. ");
        FloorSize floorSize = new FloorSize(validateUserInput());
        System.out.println("Enter Carpet Cost per square unit. $");
        CarpetCost carpetCost = new CarpetCost(validateUserInput());
        floorSize.calculateArea();
        System.out.println("The carpet cost for " + floorSize.getArea() + " square units is $" +
                (new Calculator(floorSize, carpetCost)).getTotalCost());
    }

    //Calculate based on Width, Height, and Carpet Cost.
    public static void carpetCostBasedWidthHeight(){
        System.out.println("Enter the Width of the floor. ");
        double floorWidth = validateUserInput();
        System.out.println("Enter the Length of the floor. ");
        FloorSize floorSize = new FloorSize(floorWidth, validateUserInput());
        System.out.println("Enter the Carpet Cost per square unit. $");
        CarpetCost carpetCost = new CarpetCost(validateUserInput());
        floorSize.calculateArea();
        System.out.println("The carpet cost for " + floorSize.getArea() + " square units is $" +
                new Calculator(floorSize, carpetCost).getTotalCost());
    }

    public static double validateUserInput(){
        String userInputStr;
        while (true){
            System.out.print("Enter a value: ");
            userInputStr = keyboard.nextLine();
            try{
                return Double.parseDouble(userInputStr);
            } catch (NumberFormatException nfe){
                System.out.println('"' + userInputStr + "\" is a wrong input. Numbers only. Tray again.");
            }
        }
    }

    public static void menu(){
        System.out.println("\tMAIN MENU\n" +
                "0. Exit.\n" +
                "1. Print Menu.\n" +
                "2. Calculate carpet cost based on floor AREA OR\n" +
                "3. Calculate carpet cost based on floor's WIDTH & LENGTH.\n");
    }
}
