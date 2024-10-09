//package kr.co.seoulit.account.sys.base.controller;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import kr.co.seoulit.account.sys.base.to.BoardFIleBean;
//import org.apache.catalina.connector.Response;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.lang.RandomStringUtils;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import kr.co.seoulit.account.sys.base.service.BaseService;
//import kr.co.seoulit.account.sys.base.to.BoardBean;
//import org.springframework.web.util.WebUtils;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@RestController
//@RequestMapping("/base")
//public class BoardControllerOrigin {
//	@Autowired
//	private BaseService baseService;
//
//	//쓸거임
//	@GetMapping("/boardlist")
//	public ArrayList<BoardBean> findParentboardList() {
//		return baseService.selectParentBoardList();
//	}
//
//
//	//78 복잡한 페이지 유기하고 필수기능만 새로 구현함 나중에 필요하면 가져다 쓰면 됨.
//	//==CRUD==//
//
//
//
//	@RequestMapping("/insertBoard")
//	@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true",allowedHeaders = {"Content-Type", "Authorization"})
//	public void insertBoard(@RequestParam("title")String title,
//							@RequestParam("contents")String contents, @RequestParam("writtenBy")String writtenBy
//	){
//		BoardBean boardbean = new BoardBean();
//		boardbean.setTitle(title);
//		boardbean.setContents(contents);
//		boardbean.setWrittenBy(writtenBy);
//		baseService.insertBoard(boardbean);
//	}
//
//
//
//
//	@GetMapping("/selectBoardId")
//	public BoardBean selectBoardId(@RequestParam String id)  {
//		BoardBean boardBean;
//		boardBean = baseService.selectBoardId(id);
//		return  boardBean;
//	}
//
//
//
//	@RequestMapping ("/boardDelete")
//	@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true",allowedHeaders = {"Content-Type", "Authorization"})
//	public void deleteBoard(@RequestParam("id") String id) {
//		System.out.println("컨트롤러는왓다2222222222222222222222222222"); //이새끼 처음에 해놓은거 레전드였음
//		baseService.deleteBoard(id);
//	}
//
//	//쓸거임
//	@RequestMapping ("/updateBoard")
//	@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true",allowedHeaders = {"Content-Type", "Authorization"})
//	public void updateBoard(@RequestParam("id")String id,@RequestParam("title")String title,
//							@RequestParam("contents")String contents
//	){
//
//		BoardBean boardbean = new BoardBean();
//		boardbean.setId(id);
//		boardbean.setTitle(title);
//		boardbean.setContents(contents);
//		baseService.updateBoard(boardbean);
//	}
//
//
//
//	@PostMapping("/boardModify")
//	public ModelAndView boardModify(
//			@RequestParam("id")String id
//			,@RequestParam("title") String title
//			,@RequestParam("contents")String contents) {
//
//		ModelAndView mav=new ModelAndView("redirect:/base/board");
//		BoardBean boardbean = new BoardBean();
//		boardbean.setTitle(title);
//		boardbean.setId(id);
//		boardbean.setContents(contents);
//		System.out.println("@@글번호"+id+"@@@제목:"+title+"@@@내용 :"+contents+"@@@@@@@@@@@@@");
//		baseService.boardModify(boardbean);
//		return mav;
//	}
//
//	@PostMapping("/board_re_insert")
//	public Map<String, Object> insertreply(
//			@RequestParam("reply") String reply
//			,@RequestParam("id") String id
//			,@RequestParam("writer")String writer) {
//		HashMap<String, Object> map = new HashMap<>();
//		BoardBean boardbean = new BoardBean();
//		boardbean.setBid(id);
//		boardbean.setReContents(reply);
//		boardbean.setReWritter(writer);
//		map.put("Msg","성공ㅎㅎ");
////		   SYSTEM.OUT.PRINTLN("작성자:"+WRITTENBY+"@@@제목:"+TITLE+"@@@내용 :"+CONTENTS+"@@@@@@@@@@@@@");
//		baseService.insertReBoard(boardbean);
//		return map;
//	}
//
//	@GetMapping("replyDelete")
//	public void redeleteBoard(@RequestParam String rid) {
//		baseService.deletereBoard(rid);
//
//	}
//
//}
