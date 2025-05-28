package Recursion;

import java.util.Arrays;

public class BackTracking {

	public static void main(String[] args) {
		boolean board[][] = {
				{true, true, true},
				{true, true, true},
				{true, true, true}
		};
		int[][] path = new int[board.length][board[0].length];
//		printPathBack("", board,0,0);
		printPathBackPrint("", board, 0,0, path,1);
	}

	// print all paths D->R->L->U
		static void printPathBack(String p,boolean[][] maze, int row, int col) {
			if(row == maze.length -1 && col ==maze[0].length -1) {
				System.out.println(p);
				return;
			}
			if(!maze[row][col]) {
				return;
			}
			maze[row][col] = false;
			
			if(row < maze.length -1) {
				printPathBack(p + 'D',maze, row +1, col);
			}
			if(col < maze[0].length -1) {
				printPathBack(p + 'R', maze, row , col +1);
			}
			if(row >0) {
				printPathBack(p + 'U', maze, row-1 , col);
			}
			if(col >0) {
				printPathBack(p + 'L', maze, row , col -1);
			}
			maze[row][col] = true;
		}
		
		// print the path as a integer 
		static void printPathBackPrint(String p,boolean[][] maze, int row, int col, int[][] path, int step) {
			if(row == maze.length -1 && col ==maze[0].length -1) {
				path[row][col] = step;
				for(int[] arr : path) {
					System.out.println(Arrays.toString(arr));
				}
				System.out.println(p);
				System.out.println();
				return;
			}
			if(!maze[row][col]) {
				return;
			}
			maze[row][col] = false;
			path[row][col] = step;
			
			if(row < maze.length -1) {
				printPathBackPrint(p + 'D',maze, row +1, col, path, step +1);
			}
			if(col < maze[0].length -1) {
				printPathBackPrint(p + 'R', maze, row , col +1, path, step +1);
			}
			if(row >0) {
				printPathBackPrint(p + 'U', maze, row-1 , col, path, step +1);
			}
			if(col >0) {
				printPathBackPrint(p + 'L', maze, row , col -1, path, step +1);
			}
			maze[row][col] = true;
			path[row][col] = 0;
		}
}
