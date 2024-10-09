package kr.co.seoulit.account.sys.board.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BoardTO {
    private String id;
    private String title;
    private String contents;
    private String writtenBy;
    private String writeDate;

    private String replyId;
}
