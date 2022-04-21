package example;

import montecarlo.MonteCarloTreeSearch;
import tictactoe.Board;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		MonteCarloTreeSearch treeSearch = new MonteCarloTreeSearch();
		Board board = new Board();
		int playerNumber1 = 1;

		Random rand = new Random();
		ArrayList<Board> boardList = new ArrayList<Board>();
		int i = 0;

		while (i <= 9) { // gives 9 possible executions
			Board tempBoard = treeSearch.findNextMove(board, playerNumber1);
		//	tempBoard.printBoard();
			boardList.add(tempBoard);
			i++;
		}
		// Get Different findNextMove boards

		int possibleBoardIndex = rand.nextInt(boardList.size() - 1); // nondeterminism because choose a random board
		board = boardList.get(possibleBoardIndex);
		int currentplayer = 1;
		
		while (board.checkStatus() == -1) {
			if (currentplayer == 1) {
				board = treeSearch.findNextMove(board, playerNumber1);
				currentplayer = 2;
			} else {
				board = treeSearch.findNextMove(board, playerNumber1);
				currentplayer = 1;
			}
		//	board.printBoard();
		}

	}
}
