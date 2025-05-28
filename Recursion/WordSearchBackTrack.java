package Recursion;

public class WordSearchBackTrack {

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word = "ABCB" ;
		
		System.out.println(exist(board, word));

	}

	public static boolean exist(char[][] board, String word) {
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if(board[row][col] == word.charAt(0) && helper(board, word, row,col,0)) {
					return true;
				}
			}
		}
        return false;
    }
	public static boolean helper(char[][] board, String word, int row, int col, int index) {
		if(index == word.length() ) {
			return true;
		}
		
        if( row < 0 || row ==board.length || col<0 || col == board[0].length || board[row][col] != word.charAt(index)) {
        	   	return false;
           }
        
        char ch = board[row][col] ;
        board[row][col] ='#';
     // Down step
     boolean res=  helper(board, word, row+1 , col,index +1) || 
     // Right step
    		 	   helper(board, word, row, col+1,index+1) ||
	 // Up step
    		 	   helper(board, word, row-1 , col,index+1) ||
	 // Left step
    		 	   helper(board, word, row , col -1,index+1);
		
		board[row][col] = ch;
		
		return res;
    }
}
