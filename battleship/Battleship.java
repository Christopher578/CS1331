    import java.util.*;
    import java.io.*;

public class Battleship {
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        char[][] playerOneShotsBoard = new char[5][5];
        char[][] playerTwoShotsBoard = new char[5][5];
        char[][] playerOneLocationBoard = new char[5][5];
        char[][] playerTwoLocationBoard = new char[5][5];
        int[] ships = {5,5};

        initializeBoard(playerOneLocationBoard);
        initializeBoard(playerTwoLocationBoard);

        placeShips(scanner, playerOneLocationBoard, 1);
        printBattleShip(playerOneLocationBoard);
        System.out.println();

        placeShips(scanner, playerTwoLocationBoard, 2);
        printBattleShip(playerTwoLocationBoard);
        System.out.println();

    do {
        playGame(scanner, playerTwoLocationBoard, 1,2,ships);
        if (ships[0] == 0) {
    	System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
            break;
        }
        playGame(scanner, playerOneLocationBoard, 2,1,ships);
        if (ships[1] == 0) {
    	System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
            break;
        }
       } while (true);
       System.out.println();
         System.out.println("Final boards:");
         System.out.println();
      //Final boards:
       printBattleShip(playerOneLocationBoard);
       System.out.println();
       printBattleShip(playerTwoLocationBoard);
       scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void placeShips(Scanner scanner, char[][] locationBoard, int player) {
        System.out.println("PLAYER " + player + ", ENTER YOUR SHIPS' COORDINATES.");

        for (int ship = 1; ship <= 5; ship++) {
            int row, col;
            do {
                System.out.println("Enter ship " + ship + " location:");
                row = scanner.nextInt();
                col = scanner.nextInt();
      
            } while (isValidCoordinates(locationBoard, row, col));
            locationBoard[row][col] = '@';
            
        }
    }

    private static boolean isValidCoordinates(char[][] board, int row, int col) {
        boolean detect = false;
        if (row < 0 || row > 4 ||col < 0 || col > 4 ){
        System.out.println("Invalid coordinates. Choose different coordinates.");
        detect = true;
        }
        else if (board[row][col] == '@') {
        System.out.println("You already have a ship there. Choose different coordinates.");
        detect = true;
        }
        else
        detect = false;
        
        return detect;
    }
    private static boolean isValidCoordinates2(char[][] board, int row, int col) {
        boolean detect = false;
        if (row < 0 || row > 4 ||col < 0 || col > 4 ){
        System.out.println("Invalid coordinates. Choose different coordinates.");
        detect = true;
        }
        else if (board[row][col] == 'O' || board[row][col] == 'X') {
    	       System.out.println("You already fired on this spot. Choose different coordinates.");
    	       detect = true;	       
    	      }
    	else
    	detect = false;
    	return detect;  
    }

    private static void playGame(Scanner scanner, char[][] locationBoard, int playershot, int playerget, int[] ships) {
        int row, col;
        do {
            System.out.println("Player " + playershot + ", enter hit row/column:");
            row = scanner.nextInt();
            col = scanner.nextInt();
        }
        while (isValidCoordinates2(locationBoard, row, col));
            if (locationBoard[row][col] == '@') {
                System.out.println("PLAYER " + playershot + " HIT PLAYER " + playerget + "'s SHIP!");
                    locationBoard[row][col] = 'X';
                    ships[playershot-1] -=1;
            } else {
                locationBoard[row][col] = 'O';
                System.out.println("PLAYER " + playershot + " MISSED!");
            }
            printBattleShip(hideships(locationBoard));
            System.out.println();

    }
    public static char[][] hideships( char[][] hide ) {
             char[][] show = new char[5][5];
             for (int m= 0 ;m< hide.length ; m++) {
                 for (int n= 0 ; n<hide[0].length ; n++)
                 show[m][n] =hide[m][n];
             }
             
             for (int row = 0; row < show.length ; row ++) {
                for (int column = 0 ; column< show[0].length ; column++) {
                 if (show[row][column] == '@')
                  show[row][column] = '-';
                }
             }
            return show;
    }

}
