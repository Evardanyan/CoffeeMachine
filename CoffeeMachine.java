package machine;

import java.beans.PropertyEditorManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int coffeebeans = 120;
    static int cups = 9;
    static int money = 550;

    static Boolean exit = false;

    static Scanner scanner = new Scanner(System.in);

    enum Status {
        CHOICE, BUY, FILL, TAKE, REMAINING, EXIT
    }

    static Status currentStatus = Status.CHOICE;

    public static void main(String[] args) {
        do {
            System.out.println(currentStatus);
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            switch (action) {
                case "buy":
                    currentStatus = Status.BUY;
                    System.out.println(currentStatus);
                    buy();
                    break;
                case "fill":
                    currentStatus = Status.FILL;
                    System.out.println(currentStatus);
                    fill();
                    break;
                case "take":
                    currentStatus = Status.TAKE;
                    System.out.println(currentStatus);
                    take();
                    break;
                case "remaining":
                    currentStatus = Status.REMAINING;
                    System.out.println(currentStatus);
                    coffeMachineInf();
                    break;
                case "exit":
                    exit();
                    System.out.println(currentStatus);
                    break;
            }
        } while (currentStatus != Status.EXIT);



//        coffeMachineFunc();

    }

    private static void ingredientCalc(int cup) {
        // one cup need 200ml water, 50ml milk 15g coffe beans
        System.out.println("For " + cup + " " + "cups of coffee you will need:");
        System.out.println(cup * 200 + " " + "ml of water");
        System.out.println(cup * 50 + " " + "ml of milk");
        System.out.println(cup * 15 + " " + "g of coffee beans");

    }

    private static void isPossibleMakeCoffe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk =  scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int calcCupsWater = water / 200;
        int calcCupsMilk = milk / 50;
        int calcCupsBeans = beans / 15;

        int[] temp = new int[3];
        temp[0] = calcCupsWater;
        temp[1] = calcCupsBeans;
        temp[2] = calcCupsMilk;

        Arrays.sort(temp);

        int min = temp[0];
        int difference = 0;

        if (cups == min) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cups > min) {
            System.out.println("No, I can make only" + " " + min + " " + "cup(s) of coffee");
        } else if (cups < min) {
            difference = min - cups;
            System.out.println("Yes, I can make that amount of coffee (and even" + " " + difference + " " + "more than that)");
        }
    }

    private static void coffeMachineInf() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " " + "of water");
        System.out.println(milk + " " + "of milk");
        System.out.println(coffeebeans + " " + "of coffee beans");
        System.out.println(cups + " " + "of disposable cups");
        System.out.println(money + " " + "of money");


    }

    private static void coffeMachineFunc() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);

//        coffeMachineInf();

        while (check) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String func = scanner.next();
            if (func.equals("fill")) {
                fill();
            } else if (func.equals("buy")) {
                buy();
            } else if (func.equals("take")) {
                take();
            } else if (func.equals("remaining")) {
                coffeMachineInf();
            } else if (func.equals("exit")) {
                check =false;
            }

        }
    }

    private static void buy() {
        Scanner scanner = new Scanner(System.in);
        String coffeType = "";
        boolean check = true;
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            coffeType = scanner.next();
        switch (coffeType) {
            case "1":
                if (water >= 250 && coffeebeans >= 16) {
                    System.out.println("I have enough resources, making you a coffee!");
                    money = money + 4;
                    cups = cups - 1;
                }
                if (water < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    water = water - 250;
                }
                if (coffeebeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else {
                    coffeebeans = coffeebeans - 16;
                }
                break;
            case "2":
                if (water >= 350 && coffeebeans >= 20 && milk >= 75) {
                    System.out.println("I have enough resources, making you a coffee!");
                    money = money + 7;
                    cups = cups - 1;
                }
                if (water < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    water = water - 350;
                }
                if (coffeebeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else {
                    coffeebeans = coffeebeans - 20;
                }
                if (milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {
                    milk = milk - 75;
                }
                break;
            case "3":
                if (water >= 200 && coffeebeans >= 12 && milk >= 100) {
                    System.out.println("I have enough resources, making you a coffee!");
                    money = money + 6;
                    cups = cups - 1;
                }
                if (water < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    water = water - 200;
                }
                if (coffeebeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                } else {
                    coffeebeans = coffeebeans - 12;
                }
                if (milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {
                    milk = milk - 100;
                }
                break;
            case "back":
                return;
            default:
                if (water == 0 || milk == 0 || coffeebeans == 0) {
                    System.out.println("its default choice");
                }
        }
//        coffeMachineInf();
    }


    private static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int water_inp = scanner.nextInt();
        water = water + water_inp;
        System.out.println("Write how many ml of milk do you want to add:");
        int milk_inp = scanner.nextInt();
        milk = milk + milk_inp;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeebeans_inp = scanner.nextInt();
        coffeebeans = coffeebeans + coffeebeans_inp;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups_inp = scanner.nextInt();
        cups = cups + cups_inp;

//        coffeMachineInf();
}

    private static void take() {
        System.out.println("I gave you $" + money );
        money = 0;
//        coffeMachineInf();
    }

    static void exit() {
        //System.out.println("exit() called");
        currentStatus = Status.EXIT;
    }

}
