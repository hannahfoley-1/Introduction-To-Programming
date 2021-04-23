public abstract class ConnectPlayer {
	public char playerPiece;
	
	public void setPlayerPiece(char playerPiece) {
		this.playerPiece = playerPiece;
	}
	
	public char getPlayerPiece() {
		return playerPiece;
	}
	
	public abstract void makeMove(Connect4Grid grid, ConnectPlayer player);

}
