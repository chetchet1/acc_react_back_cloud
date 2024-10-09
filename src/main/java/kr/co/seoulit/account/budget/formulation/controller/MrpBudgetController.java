package kr.co.seoulit.account.budget.formulation.controller;

import kr.co.seoulit.account.operate.system.to.OpenMrpBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MrpBudgetController {

    private List<OpenMrpBean> storedOpenMrpList = new ArrayList<>(); // 데이터 저장소

    @PostMapping("/account/budget/mrp/list")
    public ResponseEntity<Void> handleBudgetList(@RequestBody List<OpenMrpBean> openMrpList) {
        // 받은 데이터 처리 로직
        System.out.println("Kafka 데이터 응답 완료 : " + openMrpList);

        // 데이터 저장
        this.storedOpenMrpList = openMrpList; // 저장된 데이터를 갱신

        // 데이터 처리 후 성공 응답
        return ResponseEntity.ok().build();
    }

    @GetMapping("/account/budget/mrp/mrplist")
    public ResponseEntity<List<OpenMrpBean>> getBudgetList() {
        System.out.println("반환도 했음!");
        // 저장된 데이터를 클라이언트에게 반환
        return ResponseEntity.ok(storedOpenMrpList);
    }
}
