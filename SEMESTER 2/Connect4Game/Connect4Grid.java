public interface Connect4Grid {
		static final char PLAYER1 = 'X';
		static final char PLAYER2 = 'O'; 
	    static final int COL_SIZE = 6;
		static final int ROW_SIZE = 7;
		static final char [][] grid = new char [COL_SIZE][ROW_SIZE]; 
		
		public void emptyGrid();
		public String toString();
		public boolean isValidColumn(int column);
		public boolean isColumnFull(int column);
		public void dropPiece(ConnectPlayer player, int column);
		public boolean didLastPieceConnect4(char playerPiece);
		public boolean isGridFull(); 
	
}
