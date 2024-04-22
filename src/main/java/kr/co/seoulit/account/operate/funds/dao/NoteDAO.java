package kr.co.seoulit.account.operate.funds.dao;

import kr.co.seoulit.account.operate.funds.to.NoteBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface NoteDAO {

    //어음명세서 조회
    public ArrayList<NoteBean> findNoteList(String accountCode);

    //어음 한개 조회
    public NoteBean findNoteByJournalNo(String journalNo);

    //어음상세 삭제
    public void deleteNote(String journalNo);

    //어음상세 수정
    public void updateNote(NoteBean noteBean);

    //어음현황 조회
    public HashMap<String, Object> fetchNoteStatus(HashMap<String, Object> map);
}
