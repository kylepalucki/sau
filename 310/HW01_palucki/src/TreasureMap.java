
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
            start = board[9][0];
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        System.out.println(displayBoard(board)+"\n\n");
        //display(board);
        findTreasure(start, board); 
    }
    
    private static int[][] createBoard() throws FileNotFoundException{
        int[][] board = new int[10][];
        File f = new File("map.txt");
        Scanner s = new Scanner(f);
        int i = 0;
        int[] nums = new int[82];
        while(s.hasNextInt()) {
            nums[i++] = s.nextInt();
        }
        i=0;
        for (int j = 0; j < 9; j++) {
            board[j] = new int[9];
        }
        for (int rows = 0; rows < 9; rows++) {
            for (int cols = 0; cols < 9; cols++) {
                board[rows][cols] = nums[i++];
            }
        }
        board[9] = new int[1];
        board[9][0] = nums[81];
        return board;
    }
    
    
    private static void findTreasure(int start, int[][] board) {
        boolean found = false;
        int x = start/10;
        int y = start%10;
        System.out.println(start);
        while (!found) {
            int next = board[x-1][y-1];
            System.out.println(next);
            if (board[(next/10)-1][(next%10)-1]<0) {
                System.out.println("The treasure is: " + board[(next/10)-1][(next%10)-1]);
                found = true;
            } else {
                x = next/10;
                y = next%10;
            }
        }
    }
    private static String displayBoard(int[][] data){
        String f = "";
        for (int i = 1; i <= 9; i++) {
            f += String.format("%6s", i);
        }
        f+= ("\n   +-----------------------------------------------------+\n");
        for (int i=0; i < data.length-1; i++) {
            f+= i+1 + "  |";
            for(int j = 0; j < data[i].length; j++) {
                f += String.format("%6s", data[i][j] + " |");
            }
            f+="\n";   
            if (i<8){
                f+= ("   +-----+-----+-----+-----+-----+-----+-----+-----+-----+\n");
            }
        }
        f+= ("   +-----------------------------------------------------+");
        return f;
    }
}
