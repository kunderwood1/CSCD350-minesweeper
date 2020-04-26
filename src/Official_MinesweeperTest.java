import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

//Authors:
//Kevin Underwood
//Philip Siler
//Damien Rodriguez

class Official_MinesweeperTest {


    @org.junit.jupiter.api.Test
    void OnexOneNoMines() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneByOneNone.txt", "JUnitTestingOutput/output1.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output1.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneByOneNone.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OnexOneAllMines() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneByOneAll.txt", "JUnitTestingOutput/output2.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output2.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneByOneAll.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OnexOneHundredNoMines() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneByOneHundredNone.txt", "JUnitTestingOutput/output3.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output3.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneByOneHundredNone.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OnexOneHundredAllMines() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneByOneHundredAll.txt", "JUnitTestingOutput/output4.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output4.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneByOneHundredAll.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OnexOneHundredHalfMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneByOneHundredHalf.txt", "JUnitTestingOutput/output5.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output5.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneByOneHundredHalf.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OneHundredxOneNoMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneByOneHundredNone.txt", "JUnitTestingOutput/output6.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output6.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneByOneHundredNone.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OneHundredxOneAllMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneHundredByOneAll.txt", "JUnitTestingOutput/output7.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output7.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneHundredByOneAll.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OneHundredxOneHalfMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneHundredByOneHalf.txt", "JUnitTestingOutput/output8.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output8.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneHundredByOneHalf.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OneHundredxOneHundredNoMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneHundredByOneHundredNone.txt", "JUnitTestingOutput/output9.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output9.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneHundredByOneHundredNone.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OneHundredxOneHundredAllMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneHundredByOneHundredAll.txt", "JUnitTestingOutput/output10.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output10.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneHundredByOneHundredAll.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void OneHundredxOneHundredHalfMine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/OneHundredByOneHundredHalf.txt", "JUnitTestingOutput/output11.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output11.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/OneHundredByOneHundredHalf.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void FivexFive() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/FiveByFiveSomethingPercent.txt", "JUnitTestingOutput/output12.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output12.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/FiveByFiveSomethingPercent.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void TwentyxFifteen() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/TwentyByFifteenBySomethingPercent.txt", "JUnitTestingOutput/output13.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output13.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/TwentyByFifteenBySomethingPercent.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void FourtyTwoSquaredOrSomeShitLikeThat() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/FourtyTwoByFourtyTwoFourtyTwoPercent.txt", "JUnitTestingOutput/output14.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output14.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/FourtyTwoByFourtyTwoFourtyTwoPercent.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    @org.junit.jupiter.api.Test
    void SixtyNinexSixtyNine() throws IOException {
        String[] args = {"jUnitTestingTextFiles/Unsolved/SixtyNineBySixtyNineSixtyNinePercent.txt", "JUnitTestingOutput/output15.txt"};
        Official_Minesweeper.main(args);

        BufferedReader testIn = new BufferedReader(new FileReader("JUnitTestingOutput/output15.txt"));
        BufferedReader compareIn = new BufferedReader(new FileReader("jUnitTestingTextFiles/Solved/SixtyNineBySixtyNineSixtyNinePercent.txt"));

        assertEquals(true, FileComparison(testIn, compareIn));
    }


    //Citation for <b>shamelessly</b> stolen code
    //https://www.devglan.com/corejava/comparing-files-in-java
    //Author: Peter Hill
    //Thank you Peter.
    private static boolean FileComparison(BufferedReader test, BufferedReader compare) throws IOException {

        String line1 = test.readLine();

        String line2 = compare.readLine();

        boolean areEqual = true;

        int lineNum = 1;

        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;

                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;

                break;
            }

            line1 = test.readLine();

            line2 = compare.readLine();

            lineNum++;
        }

        test.close();

        compare.close();

        return areEqual;

    }
}


