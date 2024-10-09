package kr.co.seoulit.account.sys.board.mapper;


import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.account.sys.board.to.BoardTO;

import java.util.ArrayList;

@Mapper

public interface BoardSqlMapper {
    ArrayList<BoardTO> selectBoardList();

    ArrayList<BoardTO> selectBoardId(String id);

    void deleteBoardList(String id);

    void insertBoard(BoardTO boardTO);

    void updateBoard(BoardTO boardTO);

    ArrayList<BoardTO> selectBoardReplyId(String id);

    void insertReplyBoard(BoardTO boardTO);

    void deleteReplyBoardList(String replyId);

}
