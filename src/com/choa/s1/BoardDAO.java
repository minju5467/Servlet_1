package com.choa.s1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.choa.s1.DBConnector;

public class BoardDAO {

	private DBConnector dbConnector;

	public BoardDAO() {
		dbConnector = new DBConnector();
	}

	public ArrayList<BoardDTO> boardList() throws Exception {

		Connection con = dbConnector.getConnect();

		String sql = "select * from board";

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<BoardDTO> ar = new ArrayList<>();

		while (rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setRegDate(rs.getDate("regDate"));
			boardDTO.setHit(rs.getLong("hit"));

			ar.add(boardDTO);

		}
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	public int boardWrite(BoardDTO boardDTO) throws Exception {
		Connection con = dbConnector.getConnect();

		String sql = "insert into board values(?,?,?,?,sysdate,0)";

		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, boardDTO.getNum());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getWriter());
		st.setString(4, boardDTO.getContents());

		int num = st.executeUpdate();

		st.close();
		con.close();

		return num;
	}
}
