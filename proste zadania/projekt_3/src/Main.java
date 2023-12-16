public class Main {
    public static void main(String[] args) {
        int size = 8; // wielkość szachownicy
        String[][] board = new String[size][size];

        // wypełnienie tablicy znakami i kolorami
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = "\u001B[47m   \u001B[0m"; // biały kwadrat
                } else {
                    board[i][j] = "\u001B[40m   \u001B[0m"; // czarny kwadrat
                }
            }
        }

        // wyświetlenie szachownicy
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
