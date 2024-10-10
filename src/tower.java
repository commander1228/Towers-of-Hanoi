import java.util.Arrays;

public class tower
{

    enum towerState
    {
        FULL,
        EMPTY,
        READY
    }
    int[] discsInTower;

    public tower(int discCount,int startState)
    {
        enum towerState
        {
            FULL,
            EMPTY,
            READY
        }
        discsInTower = new int[discCount];
        fillTower(startState);
    }

    public int getTowerSize()
    {
        return discsInTower.length;
    }

    public int[] getTowerArray()
    {
        return discsInTower;
    }

    public int getTopMostDisc()
    {
        for (int disc : discsInTower) {
            if (disc > 0) {
                return disc;
            }
        }
        return 0;
    }

    public towerState getTowerStatus()
    {
        int sumOfDiscSizes = 0;
        int maxSumofDiscSizes = 1;
        for (int i = 0;i<discsInTower.length;i++)
        {
            maxSumofDiscSizes += (i + 1);
        }
        for (int disc : discsInTower)
        {
            sumOfDiscSizes += disc;
        }
        if (sumOfDiscSizes == 0)
        {
            return towerState.EMPTY;
        }
        if(sumOfDiscSizes == maxSumofDiscSizes)
        {
            return towerState.FULL;
        }
        return towerState.READY;
    }

    public void fillTower(int fillType)
    {
        if(fillType == 1)
        {
            int startNum = 1;
            for (int disc = 0; disc < discsInTower.length; disc++)
            {
                discsInTower[disc] = startNum;
                startNum += 1;
            }
        }
        if (fillType == 0)
        {
            Arrays.fill(discsInTower, 0);
        }
    }

    public void addTopDisc(int discSize)
    {
        for (int disc = 0; disc < discsInTower.length; disc++)
        {
            if(discsInTower[disc] > 0)
            {
                discsInTower[disc - 1] = discSize;
                return;
            }
        }
       discsInTower[discsInTower.length - 1] =discSize;
    }

    public void removeTopDisc()
    {
        for (int disc = 0; disc < discsInTower.length; disc++)
        {
        if(discsInTower[disc] > 0)
        {
            discsInTower[disc] = 0;
            return;
        }
        }
    }

    public void printTower()
    {
        System.out.println(Arrays.toString(discsInTower));
    }
}
