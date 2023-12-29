package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class buyItemInforDTO {
    private Long itemId;
    private String itemName;
    private String sellerEmail;
    private int price;
    private String buyedMemberId;
    private String itemcount;
    private String createdAt;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBuyedMemberId() {
        return buyedMemberId;
    }

    public void setBuyedMemberId(String buyedMemberId) {
        this.buyedMemberId = buyedMemberId;
    }

    public String getItemcount() {
        return itemcount;
    }

    public void setItemcount(String itemcount) {
        this.itemcount = itemcount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public buyItemInforDTO(Long itemId, String itemName, String sellerEmail, int price, String buyedMemberId, String itemcount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.sellerEmail = sellerEmail;
        this.price = price;
        this.buyedMemberId = buyedMemberId;
        this.itemcount = itemcount;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "buyItemInforDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", price=" + price +
                ", buyedMemberId='" + buyedMemberId + '\'' +
                ", itemcount='" + itemcount + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
