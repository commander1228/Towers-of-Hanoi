import java.util.Scanner;
import java.util.stream.IntStream;

public class game {
    int discsPerTower;
    tower[] towers = new tower[3];

    public game(int discCount)
    {
        discsPerTower = discCount;
        towers[0] = new tower(3,1);
        towers[1] = new tower(3,0);
        towers[2] = new tower(3,0);
    }
    public void startGame()
    {
        Scanner inputs = new Scanner(System.in);
        int gameState = 1;
        while(gameState == 1)
        {
            printTowers();
            System.out.println("tower 1:");
            int selection1 = inputs.nextInt();
            System.out.println("tower 2:");
            int selection2 = inputs.nextInt();
            moveDisc(selection1,selection2);
            gameState = isSolved();
        }
        printTowers();
        System.out.println("congratulations you have beaten the towers of hanoi!");
        System.exit(0);
    }

    public int isSolved()
    {
        int maxDiscTotal = 0;
        int[] tower3 = towers[2].getTowerArray();
        int currentDiscTotal = IntStream.of(tower3).sum();
        for (int i = 0; i < discsPerTower; i++)
        {
            maxDiscTotal += (i+1);
        }
        if (currentDiscTotal == maxDiscTotal)
        {
            return 0;
        } else{
            return 1;
        }
    }

    public void printTowers()
    {
        int[] tower1 = towers[0].getTowerArray();
        int[] tower2 = towers[1].getTowerArray();
        int[] tower3 = towers[2].getTowerArray();
        for(int i = 0; i < discsPerTower; i++)
        {
            System.out.printf(" "+ tower1[i] + "   "+ tower2[i] + "   "+tower3[i]+"\n");
        }
        System.out.println("--- --- ---");
    }

    public void printErrorMessage(int selection) {
        switch (selection) {
            case 1:
                System.out.println("tower 1 has no discs to move");
                break;
            case 2:
                System.out.println(" tower 2 has no room");
                break;
            case 3:
                System.out.println("the disc your moving is bigger than the others on that tower");
        }
    }

    public void moveDisc(int towerSelection1, int towerSelection2) {
        int tower1 = towerSelection1 - 1;
        int tower2 = towerSelection2 - 1;
        boolean tower1NotEmpty = towers[tower1].getTowerStatus() == tower.towerState.EMPTY;
        boolean tower2NotFull = towers[tower2].getTowerStatus() == tower.towerState.FULL;
        boolean DiscTooBig = (towers[tower1].getTopMostDisc() > towers[tower2].getTopMostDisc());

        if (tower1NotEmpty) {
            printErrorMessage(1);
            return;
        }
        if(tower2NotFull)
        {
            printErrorMessage(2);
            return;
        }
        if (DiscTooBig && towers[tower2].getTowerStatus() != tower.towerState.EMPTY) {
            printErrorMessage(3);
            return;
        }
        towers[tower2].addTopDisc(towers[tower1].getTopMostDisc());
        towers[tower1].removeTopDisc();
    }

}