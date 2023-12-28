package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemsForSaleDTO {
    private Long itemId;
    private String itemName;
    private String sellerEmail;
    private int price;
    private int stock;
    private String contents;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
    private static Long itemIdValue = 1L;
    public ItemsForSaleDTO(){}

    public ItemsForSaleDTO( String itemName, String sellerEmail, int price, int stock, String contents) {
        this.itemId = itemIdValue++;
        this.itemName = itemName;
        this.sellerEmail = sellerEmail;
        this.price = price;
        this.stock = stock;
        this.contents = contents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "ItemsForSaleDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", contents='" + contents + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}