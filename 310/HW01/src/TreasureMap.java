
/**
 *
 * @author Palucki
 */
import java.util.*;
import java.io.*;

public class TreasureMap {
    public static void main(String[] args) {
        int[][] board = new int[10][];
        int start = 0;
        try {
            board = createBoard();
            start = getStart();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        display(board);
        System.out.println("start: " + start);
        findTreasure(start, board); 
    }
    private static int[][] createBoard() throws FileNotFoundException{
        int[][] board = new int[9][9];
        File f = new File("map.txt");
        Scanner s = new Scanner(f);
        int i = 0;
        int[] nums = new int[82];
        while(s.hasNextInt()) {
            nums[i++] = s.nextInt();
        }
        int counter=0;
        for (int rows = 0; rows < 9; rows++) {
            for (int cols = 0; cols < 9; cols++) {
                board[rows][cols] = nums[counter];
                counter++;
            }
        }
        return board;
    }
    
    private static int getStart() throws FileNotFoundException {
        File f = new File("map.txt");
        Scanner s = new Scanner(f);
        int i = 0;
        int[] nums = new int[82];
        while(s.hasNextInt()) {
            nums[i++] = s.nextInt();
        }
        return nums[81];
    }
    
    private static void findTreasure(int start, int[][] board) {
        boolean found = false;
        int x = start/10;
        int y = start%10;
        while (!found) {
            int next = board[x-1][y-1];
            System.out.println("next " + next);
            if (next<0) {
                System.out.println("The Treasure is " + next);
                found=true;
            } else {
                System.out.println(next);
                x = board[x][y]/10;
                y = board[x][y]%10;

            }
        }
    }
    
    private static int[][] createRandomBoard() {
        int[][] board = new int[9][9];
        int counter=0;
        for (int rows = 0; rows < 9; rows++) {
            for (int cols = 0; cols < 9; cols++) {
                board[rows][cols] = gen();
                counter++;
            }
        }
        return board;
    }
    private static int gen() {
        Random random = new Random();
        int num = random.nextInt(100);
        num = num > 9 ? num : num+10;
        int coin = random.nextInt(2);
        return coin == 0 ? num : num*-1;
    }
    
    
    
    private static void display(int[][] data) {
        String s = "";
        for (int r=0;r<data.length;r++) {
            for (int c=0; c<data[r].length; c++) {
                s += String.format("%4d", data[r][c]);
            }
            s += "\n";
        }
        System.out.println(s);
    }
    
    private static void displayBoard(int[][] data){
        display(data);
        System.out.println("     1     2     3     4     5     6     7     8     9   ");
        System.out.println("  +-----------------------------------------------------+");
        System.out.print("1 | ");
        for (int i=0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; i++) {
                System.out.print(data[j][i] + " |  ");
                if (j==data[j].length-2) System.out.println();
            }
            System.out.println(i==8 ? 
                    "  +-----+-----+-----+-----+-----+-----+-----+-----+-----+" :
                    "  +-----------------------------------------------------+");
        }
    }
}
