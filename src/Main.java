import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputs = new Scanner (System.in);
        System.out.println("Welcome to the Towers Of Hanoi by Kian Wheeler");
        System.out.println("The objective of the towers of hanoi game is to move all of the discs on the leftmost tower to the rightmost tower");
        System.out.println("the discs however can only be placed on a tower if it is smaller than any currently on a tower or the only one being placed on a tower");
        System.out.println("to move a disc to a different tower simply type in the number of each tower and press enter");
        game towersOfHanoi = new game(3);
        towersOfHanoi.startGame();
    }
}