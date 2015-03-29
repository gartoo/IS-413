package gameOfLife;

public class gameBoard {

	public golCell[][] board;
	public int y, x;

	public gameBoard(int height, int width) {

		y = height;
		x = width;
		board = new golCell[height][width];

	}

	public boolean[][] boardStatus() {

		boolean[][] results = new boolean[y][x];

		for (int yCount = 0; yCount < y; yCount++) {
			for (int xCount = 0; xCount < x; xCount++) {
				results[yCount][xCount] = board[yCount][xCount].getAlive();

			}
		}

		return results;
	}

	public void neighborCheck(int yCoordinate, int xCoordinate) {

		int livingNeighbors = 0;

		for (int yCheck = yCoordinate - 1; yCheck < yCoordinate + 1; yCheck++) {
			for (int xCheck = xCoordinate - 1; xCheck < xCoordinate + 1; xCheck++) {
				if (yCheck < 0 || yCheck > y) {
					continue;
				}
				if (xCheck < 0 || xCheck > x) {
					continue;
				}

				if (board[yCheck][xCheck].getAlive()) {
					livingNeighbors++;
				}
			}
		}

		if (livingNeighbors <= 1) {
			if (board[yCoordinate][xCoordinate].getAlive()) {
				board[yCoordinate][xCoordinate].kill();
			}
		}
		if (livingNeighbors == 3) {
			if (!board[yCoordinate][xCoordinate].getAlive()) {
				board[yCoordinate][xCoordinate].birth();
			}
		}
		if (livingNeighbors > 3) {
			if (board[yCoordinate][xCoordinate].getAlive()) {
				board[yCoordinate][xCoordinate].kill();
			}
		}

	}

}
