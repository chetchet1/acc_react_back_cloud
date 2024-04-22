package kr.co.seoulit.account.operate.funds.service;

import kr.co.seoulit.account.operate.funds.dao.NoteDAO;
import kr.co.seoulit.account.operate.funds.to.NoteBean;
import kr.co.seoulit.account.operate.funds.to.NoteStatusBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@RequiredArgsConstructor
@Component
public class NoteServiceImpl implements NoteService {

    private final NoteDAO noteDAO;

    //어음명세서 조회
    @Override
    public ArrayList<NoteBean> findNoteList(String accountCode) {
        return noteDAO.findNoteList(accountCode);
    }

    //어음현황 조회
    @Override
    public HashMap<String, Object> fetchNoteStatus(String date){
        HashMap<String, Object> map = new HashMap<>();

        HashMap<String, Object> payNoteMap = new HashMap<>();
        payNoteMap.put("selectDate", date);
        payNoteMap.put("selectAccount", "0252");

        noteDAO.fetchNoteStatus(payNoteMap);
        ArrayList<NoteStatusBean> payableNoteStatusList = (ArrayList<NoteStatusBean>) payNoteMap.get("RESULT");

        HashMap<String, Object> receiveNoteMap = new HashMap<>();
        receiveNoteMap.put("selectDate", date);
        receiveNoteMap.put("selectAccount", "0110");

        noteDAO.fetchNoteStatus(receiveNoteMap);
        ArrayList<NoteStatusBean> receivableNoteStatusList = (ArrayList<NoteStatusBean>) receiveNoteMap.get("RESULT");

        map.put("payableNoteStatusList", payableNoteStatusList);
        map.put("receivableNoteStatusList", receivableNoteStatusList);

        return map;
    }
}
