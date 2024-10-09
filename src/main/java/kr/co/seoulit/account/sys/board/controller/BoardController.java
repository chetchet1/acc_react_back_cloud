package kr.co.seoulit.account.sys.board.controller;

import kr.co.seoulit.account.sys.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kr.co.seoulit.account.sys.board.to.BoardTO;

import java.util.ArrayList;

@RestController
@RequestMapping("/Board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping("/selectBoardList")
    public ArrayList<BoardTO> selectBoardList(){
        ArrayList<BoardTO> data = boardService.selectBoardList();
        return data;
    }

    @RequestMapping("/selectBoardId")
    public ArrayList<BoardTO> selectBoardId(@RequestParam String id){
        ArrayList<BoardTO> data = boardService.selectBoardId(id);
        return data;
    }
    @RequestMapping("/deleteBoardList")
    public void deleteBoardList(@RequestParam String id){
        boardService.deleteBoardList(id);
    }
    @RequestMapping("/insertBoard")
    public void insertBoard(@RequestBody BoardTO boardTO){
        boardService.insertBoard(boardTO);
    }
    @RequestMapping("/updateBoard")
    public void updateBoard(@RequestBody BoardTO boardTO){
        boardService.updateBoard(boardTO);
    }

    @RequestMapping("/selectBoardReplyId")
    public ArrayList<BoardTO> selectBoardReplyId(@RequestParam String id){
        ArrayList<BoardTO> replyData = boardService.selectBoardReplyId(id);
        return replyData;
    }
    @RequestMapping("/insertReplyBoard")
    public void insertReplyBoard(@RequestBody BoardTO boardTO){
        boardService.insertReplyBoard(boardTO);
    }
    @RequestMapping("/deleteReplyBoardList")
    public void deleteReplyBoardList(@RequestParam String replyId){
        boardService.deleteReplyBoardList(replyId);
    }}
