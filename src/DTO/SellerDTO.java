package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SellerDTO {
    private Long id;
    private String name;
    private String pass;
    private String email;
    private String mobile;
    private String account;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    private static Long idValue = 1L;
    public SellerDTO(){}

    public SellerDTO(String name, String pass, String email, String mobile, String account) {
        this.id = idValue++;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.mobile = mobile;
        this.account = account;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "SellerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", account='" + account + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
