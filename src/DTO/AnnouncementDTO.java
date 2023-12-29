package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AnnouncementDTO {
    private Long announcementId;
    private String managerEmail;
    private String title;
    private String contents;
    private String createdAt;

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    private static Long announcementIdValue = 1L;

    public AnnouncementDTO(){}

    public AnnouncementDTO( String managerEmail, String title, String contents) {
        this.announcementId = announcementIdValue++;
        this.managerEmail = managerEmail;
        this.title = title;
        this.contents = contents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "AnnouncementDTO{" +
                "announcementId=" + announcementId +
                ", managerEmail='" + managerEmail + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
