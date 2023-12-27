package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemsForSaleDTO {
    private Long itemId;
    private String itemName;
    private String sellerName;
    private int price;
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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


    public ItemsForSaleDTO(String itemName, String sellerName, int price, String contents) {
        this.itemId = itemIdValue++;
        this.itemName = itemName;
        this.sellerName = sellerName;
        this.price = price;
        this.contents = contents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "ItemsForSaleDTO{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", price=" + price +
                ", contents='" + contents + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
