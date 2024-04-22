package kr.co.seoulit.account.operate.funds.controller;

import kr.co.seoulit.account.operate.funds.service.NoteService;
import kr.co.seoulit.account.operate.funds.to.NoteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/funds")
public class NoteController {

    @Autowired
    private NoteService noteService;

    //GET 어음명세서 조회
    @GetMapping("/bills")
    public ResponseEntity<Map<String, Object>> findNoteList(@RequestParam("accountCode") String accountCode){
        HashMap<String, Object> map = new HashMap<>();

        ArrayList<NoteBean> noteList = noteService.findNoteList(accountCode);
        if(noteList.size()==0){
            return ResponseEntity.notFound().build(); //없을경우
        }
        map.put("noteList", noteList);

        return ResponseEntity.ok(map);
    }

    //GET 어음현황 조회
    @GetMapping("/notes")
    public ResponseEntity<Map<String, Object>> fetchNoteStatus(@RequestParam("date") String date){

        HashMap<String, Object> noteStatusMap = noteService.fetchNoteStatus(date);
        if(noteStatusMap.size()==0){
            return ResponseEntity.notFound().build(); //없을경우
        }
        return ResponseEntity.ok(noteStatusMap);
    }
}
