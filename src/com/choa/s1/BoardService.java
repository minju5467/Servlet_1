package com.choa.s1;

import java.util.ArrayList;

public class BoardService {

	private BoardDAO boardDAO;

	public BoardService() {
		boardDAO = new BoardDAO();
	}

	public ArrayList<BoardDTO> boardList() throws Exception {

		ArrayList<BoardDTO> ar = boardDAO.boardList();

		return ar;
	}

	public void boardWrite(BoardDTO boardDTO) throws Exception {

		int result = boardDAO.boardWrite(boardDTO);
	}
}
