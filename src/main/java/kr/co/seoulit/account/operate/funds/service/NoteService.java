package kr.co.seoulit.account.operate.funds.service;

import kr.co.seoulit.account.operate.funds.to.NoteBean;

import java.util.ArrayList;
import java.util.HashMap;

public interface NoteService {
    //어음명세서 조회
    ArrayList<NoteBean> findNoteList(String accountCode);

    //어음현-황 조회
    HashMap<String, Object> fetchNoteStatus(String date);
}
