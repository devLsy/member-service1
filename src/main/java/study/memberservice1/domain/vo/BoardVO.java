package study.memberservice1.domain.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardVO {
    private Long boardId;
    private String title;
    private String content;
    private String name;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    /**
     * 객체 생성 메서드
     * @param title
     * @param content
     * @param name
     */
    public static BoardVO createBoard(String title, String content, String name) {
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setContent(content);
        boardVO.setName(name);
        return boardVO;
    }

    /**
     * 수정 메서드
     * @param title
     * @param content
     * @param name
     */
    public void updateBoard(String title, String content, String name) {
        this.title = title;
        this.content = content;
        this.name = name;
    }
}
