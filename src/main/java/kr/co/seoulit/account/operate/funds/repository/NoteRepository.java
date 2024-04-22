package kr.co.seoulit.account.operate.funds.repository;

import kr.co.seoulit.account.operate.funds.to.NoteBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteBean, String> {
}
