package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDTO {
    private Long id;
    private Long itemId;
    private String memberId;
    private String contents;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    private static Long idVlaue = 1L;
    public CommentDTO(){}
    public CommentDTO(Long itemId, String memberId, String contents) {
        this.id = idVlaue++;
        this.itemId = itemId;
        this.memberId = memberId;
        this.contents = contents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", memberId='" + memberId + '\'' +
                ", contents='" + contents + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
