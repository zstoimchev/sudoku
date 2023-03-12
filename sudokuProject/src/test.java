public class test {
    public static void main(String[] args) {
        String[][] array = new String[9][9];
        for(int i=0; i<9; i++)
            for (int j = 0; j < 9; j++)
                array[i][j]=""+i+1+""+j+1;
        System.out.print("\u250C"); // top-left corner
        for (int i=0; i< array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((j + 1) % 3 == 0) {
                    System.out.print(array[i][j] + " \u2502 ");
                } else {
                    System.out.print(array[i][j] + " | ");
                }
            }

            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("\u2514\u2500\u2500\u2500\u2534\u2500\u2500\u2500\u2534\u2500\u2500\u2500\u2518"); // bottom border
            } else if (i == 8) {
                System.out.println("\u2518\u2500\u2500\u2500\u2534\u2500\u2500\u2500\u2534\u2500\u2500\u2500\u2510"); // bottom-right corner
            } else {
                System.out.println("\u251C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u253C\u2500\u2500\u2500\u2524"); // middle border
            }
        }
    }
}
