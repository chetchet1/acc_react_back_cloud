package kr.co.seoulit.account.sys.board.service;

import kr.co.seoulit.account.sys.board.mapper.BoardSqlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kr.co.seoulit.account.sys.board.to.BoardTO;

import java.util.ArrayList;

@Transactional
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardSqlMapper boardSqlMapper;


    @Override
    public ArrayList<BoardTO> selectBoardList(){
        ArrayList<BoardTO> data;
        data = boardSqlMapper.selectBoardList();
        return data;
    }

    @Override
    public ArrayList<BoardTO> selectBoardId(String id){
        ArrayList<BoardTO> data;
        data = boardSqlMapper.selectBoardId(id);
        return data;
    }

    @Override
        public void deleteBoardList(String id){
        boardSqlMapper.deleteBoardList(id);
    }

    @Override
    public void insertBoard(BoardTO boardTO){
        boardSqlMapper.insertBoard(boardTO);
    }
    @Override
    public void updateBoard(BoardTO boardTO){
        boardSqlMapper.updateBoard(boardTO);
    }

    @Override
    public ArrayList<BoardTO> selectBoardReplyId(String id) {
        ArrayList<BoardTO> replyData;
        replyData = boardSqlMapper.selectBoardReplyId(id);
        return replyData;
    }

    @Override
    public void insertReplyBoard(BoardTO boardTO) {
        boardSqlMapper.insertReplyBoard(boardTO);
    }

    @Override
    public void deleteReplyBoardList(String replyId) {
        boardSqlMapper.deleteReplyBoardList(replyId);
    }

}
