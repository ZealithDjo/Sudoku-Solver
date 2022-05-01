
public class Solver
{

    public static void solve(int[][] puzzle)
    {
        if (done(puzzle) == true)
        {
            System.out.println("\nSolution: ");
            printPuzzle(puzzle);
            return;
        }
        else
        {

            for (int row = 0; row < 9; row++)
            {
                for (int col = 0; col < 9; col++)
                {
                    if (puzzle[row][col] == 0)
                    {
                        for (int n = 1; n <= 9; n++)
                        {
                            if (isValid(puzzle, row, col, n))
                            {
                                puzzle[row][col] = n;
                                solve(puzzle);
                                if (done(puzzle))
                                    return;
                                puzzle[row][col] = 0;

                            }

                        }

                        return;
                    }

                }

            }

        }

    }

    public static void printPuzzle(int[][] puzzle)
    {

        System.out.println(" ------------------------");

        int i = 0;
        while (i <= 8)
        {
            for (int j = 0; j <= 8; j++)
            {
                if (j == 8)
                {
                    System.out.print(puzzle[i][j] + " | " + "\n");
                    if (i % 3 == 2)
                    {
                        System.out.println(" ------------------------");
                    }
                }
                else
                {
                    if (j % 3 == 0)
                    {
                        System.out.print("| ");
                    }
                    System.out.print(puzzle[i][j] + " ");
                }
            }
            i++;
        }
    }

    public static boolean isValid(int puzzle[][], int row, int col, int val)
    {
        // check row
        for (int i = 0; i < 9; i++)
        {
            if (puzzle[i][col] == val)
                return false;
        }

        // check column
        for (int i = 0; i < 9; i++)
        {
            if (puzzle[row][i] == val)
                return false;
        }

        // check 3x3 block
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for (int i = rowStart; i < rowStart + 3; i++)
        {
            for (int j = colStart; j < colStart + 3; j++)
            {
                if (puzzle[i][j] == val)
                    return false;
            }
        }

        return true;
    }

    public static boolean done(int puzzle[][])
    {

        boolean done = true;

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (puzzle[i][j] == 0)
                {
                    done = false;
                }
            }
        }

        return done;
    }

}
