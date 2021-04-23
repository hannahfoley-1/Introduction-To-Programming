public class Connect4Grid2DArray implements Connect4Grid {
	
	//creates an empty grid 2d array
	public void emptyGrid() {
		for (int row = 0; row < COL_SIZE; row++) 
		{
            for (int col = 0; col < ROW_SIZE ; col++)
            {
                grid[row][col] = '.';
            }
        }
		
	}
	
	//creates a string version of the playing board
	public String toString() {
		String board = "";
        for (int row = 0; row < COL_SIZE; row++)
        {
            for (int col = 0; col < ROW_SIZE; col++) 
            {
                board += (grid[row][col]) + "  ";
            }
            board += "\n";
        }	
        return board;
	}
	
	//checks if the column number exists on the board
	@Override
	public boolean isValidColumn(int column) {
		if (column <= ROW_SIZE-1 && column >= 0)
		{
			return true;
		}
		return false;
	}
	
	//check if the column has been filled to the top
	@Override
	public boolean isColumnFull(int column) {
		char c = grid [0][column];
		if (c != '.') 
		{
			return true;
		}

		return false;
	}
	
	//changes the grid 2d array so the players piece will be shown on the board
	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		//get piece for this player
		char playerPiece = player.getPlayerPiece();
		boolean dropped = false;
		//will drop the piece into the next available row in that column
		for (int row = COL_SIZE-1; row >= 0; row--) {
			boolean space = false;
			char c = grid[row][column];
			if (c != '.') 
			{
				space = false;
			}
			else 
			{
				grid[row][column] = playerPiece;
				dropped = true;
			}
			if (dropped) {
				//to stop the for loop from continuing
				row = -1;
			}
		}
	}
	
	@Override
	public boolean didLastPieceConnect4(char playerPiece) {
		//check horizontally each row
		//starting at row 0, col 0 and get next 4 elements until we reach col index 3 as the first col
		//them inc row numbers and repeat until row index 5
		char c1 = ' ';
		char c2 = ' ';
		char c3 = ' ';
		char c4 = ' ';
		
		for (int row = 0; row < COL_SIZE; row ++)
		{
			for (int col = 0; col <= 3; col++)
			{
				c1 = grid[row][col];
				c2 = grid[row][col+1];
				if (c1 == playerPiece) {
					if (c1 == c2) {
						c3 = grid[row][col+2];
						if (c3 == c1) {
							c4 = grid[row][col+3];
							if (c4 == c1) {
								return true;
							}
						}
					}
				}
			}
		}
		
		//check vertically each column
		//starting at col 0 and row 0, increase row number until row is 2
		//then move onto next col
		for (int col = 0; col < ROW_SIZE-1; col++) {
			for (int row = 0; row <= 2; row ++) {
				c1 = grid[row][col];
				c2 = grid[row+1][col];
				if (c1 == playerPiece) {
					if (c1 == c2) {
						c3 = grid[row+2][col];
						if (c3 == c1) {
							c4 = grid[row+3][col];
							if (c4 == c1) {
								return true;
							}
						}
					}
				}
			}
		}
		
		//check diagonally to the right and down
		//starting at row 0 col 0
		//inc row by 1 and col by 1 and check for similarity
		for (int row = 0; row <= 2; row++) {
			for (int col = 0; col <= 2; col ++) {
				c1 = grid[row][col];
				c2 = grid[row+1][col+1];
				if (c1 == playerPiece) {
					if (c1 == c2) {
						c3 = grid[row+2][col+2];
						if (c3 == c1) {
							c4 = grid[row+3][col+3];
							if (c4 == c1) {
								return true;
							}
						}
					}
				}
			}
		}
		
		//check diagonally to the left and down
		//starting at row 0 col 6
		//inc row by 1 and dec col by 1
		for (int row = 0; row <= 2; row++) {
			for (int col = ROW_SIZE-1; col <= 3; col --) {
				c1 = grid[row][col];
				c2 = grid[row+1][col-1];
				if (c1 == playerPiece) {
					if (c1 == c2) {
						c3 = grid[row+2][col-2];
						if (c3 == c1) {
							c4 = grid[row+3][col-3];
							if (c4 == c1) {
								return true;
							}
						}
					}
				}
			}
		}
		
		//check diagonally to the right and up
		//starting at row 5 col 0
		//inc row by 1, inc col by 1
		for (int row = 5; row <= 3; row--) {
			for (int col = 0; col <= 3; col ++) {
				c1 = grid[row][col];
				c2 = grid[row-1][col+1];
				if (c1 == playerPiece) {
					if (c1 == c2) {
						c3 = grid[row-2][col+2];
						if (c3 == c1) {
							c4 = grid[row-3][col+3];
							if (c4 == c1) {
								return true;
							}
						}
					}
				}
			}
		}
		
		//check diagonally to the left and up
		//start at row 5 col 6
		//dec row and dec col
		for (int row = 5; row <= 3; row--) {
			for (int col = 6; col <= 3; col --) {
				c1 = grid[row][col];
				c2 = grid[row-1][col-1];
				if (c1 == playerPiece) {
					if (c1 == c2) {
						c3 = grid[row-2][col-2];
						if (c3 == c1) {
							c4 = grid[row-3][col-3];
							if (c4 == c1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	//check if grid is full and game is over by counting the amount of player pieces in the top row
	//if the amount of player pieces is equal to the size of the row then return true as the grid is full
	@Override
	public boolean isGridFull() {
		int fullTopRowCount = 0;
		int row = 0;
        for (int col = 0; col < ROW_SIZE ; col++)
        {
            char c = grid[row][col];
            if (c != '.') {
               	fullTopRowCount++;
            }
        }
		if (fullTopRowCount < ROW_SIZE) {
			return false;
		}
		else {
		return true;
		}
	}

}
