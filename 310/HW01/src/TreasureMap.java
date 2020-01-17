
/**
 *
 * @author Palucki
 */
import java.util.*;
import java.io.*;

public class TreasureMap {
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        try {
            board = createBoard();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        displayBoard(board);
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
        System.out.println("+-----------------------------------------------------+");
        
    }
}
