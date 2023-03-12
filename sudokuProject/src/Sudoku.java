import java.util.Scanner;
//import javax.swing.text.StyledEditorKit.ForegroundAction;
public class Sudoku {
    public static void main(String[] args) {
        int arr[][] = {{4,3,6,7,5,1,9,8,2},
                {9,5,8,6,3,2,4,1,7},
                {2,1,7,9,4,8,6,5,3},
                {8,9,4,2,7,6,5,3,1},
                {6,2,1,5,9,3,7,4,8},
                {3,7,5,1,8,4,2,6,9},
                {7,6,9,3,1,5,8,2,4},
                {1,4,2,8,6,9,3,7,5},
                {5,8,3,4,2,7,1,9,0}};
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Sudoku!");
        while (!isSolved(arr)) {
            int i = scan.nextInt() - 1;
            int j = scan.nextInt() - 1;
            int num = scan.nextInt();
            if (i < 0 || i > 9 || j < 0 || j > 9 || num < 0 || num > 9) {
                System.out.println("\u001B[31mWrong Move!\u001B[0m");
                continue;
            }

//            arr[i][j] = num;

            if (isValid(arr, i, j, num))
                arr[i][j] = num;
            else
                System.out.println("Wrong number");

            // print(arr);
        }
        System.out.println("You Win!");
        scan.close();
    }

    public static boolean checkQuadrtant(int arr[][], int si, int sj, int ei, int ej) { // start i, end i, same for j
        int sum = 0;
        for (int i = si; i < ei; i++)
            for (int j = sj; j < ej; j++)
                sum += arr[i][j];

        if (sum == 45)
            return true;
        else
            return false;
    }

    public static boolean checkQuadrants(int arr[][]) {
        boolean q1 = checkQuadrtant(arr, 0, 0, 3, 3);
        boolean q2 = checkQuadrtant(arr, 0, 3, 3, 6);
        boolean q3 = checkQuadrtant(arr, 0, 6, 3, 9);
        boolean q4 = checkQuadrtant(arr, 3, 0, 6, 3);
        boolean q5 = checkQuadrtant(arr, 3, 3, 6, 6);
        boolean q6 = checkQuadrtant(arr, 3, 6, 6, 9);
        boolean q7 = checkQuadrtant(arr, 6, 0, 9, 3);
        boolean q8 = checkQuadrtant(arr, 6, 3, 9, 6);
        boolean q9 = checkQuadrtant(arr, 6, 6, 9, 9);

        return q1 && q2 && q3 && q4 && q5 && q6 && q7 && q8 && q9;
    }

    public static boolean isSolved(int arr[][]) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                if (arr[i][j] == 0) {
                    print(arr);
                    return false;
                }
        print(arr);
        return checkQuadrants(arr);
    }

    public static boolean isValid(int arr[][], int i, int j, int x) {
        int countCol = 0; // counter for duplicates
        int countRow = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k][j] == x)
                countCol += 1;
        }
        for (int k = 0; k < arr.length; k++) {
            if (arr[i][k] == x)
                countRow += 1;
        }
        if (countRow + countCol > 0)
            return false;
        else
            return true;
    }

    public static void print(int array[][]) {
        System.out.println("\u001B[31m ----------------------------------------------------- \u001B[0m");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((j + 1) % 3 == 0) {
                    System.out.print(array[i][j] + "\u001B[31m  |  \u001B[0m");
                } else if (j == 0)
                    System.out.print("\u001B[31m|  \u001B[0m" + array[i][j] + "  |  ");
                else
                    System.out.print(array[i][j] + "  |  ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != array.length - 1)
                System.out.println("\u001B[31m|-----------------|-----------------|-----------------|\u001B[0m");
            else if (i==0)
                System.out.println("\u001B[31m|\u001B[0m-----|-----|-----\u001B[31m|\u001B[0m-----|-----|-----\u001B[31m|\u001B[0m-----|-----|-----\u001B[31m|\u001B[0m");
            else if(i!= array.length-1)
                System.out.println("\u001B[31m|\u001B[0m-----|-----|-----\u001B[31m|\u001B[0m-----|-----|-----\u001B[31m|\u001B[0m-----|-----|-----\u001B[31m|\u001B[0m");
        }
        System.out.println("\u001B[31m ----------------------------------------------------- \u001B[0m");

    }
}
