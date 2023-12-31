package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SyupingmolDTO {
    private String buyMember;
    private String sellSeller;
    private Long transactionItemId;
    private int sellItemPrice;
    private int sellItemCount;
    private String createdAt;

    public String getBuyMember() {
        return buyMember;
    }

    public void setBuyMember(String buyMember) {
        this.buyMember = buyMember;
    }

    public String getSellSeller() {
        return sellSeller;
    }

    public void setSellSeller(String sellSeller) {
        this.sellSeller = sellSeller;
    }

    public Long getTransactionItemId() {
        return transactionItemId;
    }

    public void setTransactionItemId(Long transactionItemId) {
        this.transactionItemId = transactionItemId;
    }

    public int getSellItemPrice() {
        return sellItemPrice;
    }

    public void setSellItemPrice(int sellItemPrice) {
        this.sellItemPrice = sellItemPrice;
    }

    public int getSellItemCount() {
        return sellItemCount;
    }

    public void setSellItemCount(int sellItemCount) {
        this.sellItemCount = sellItemCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public SyupingmolDTO(){}

    public SyupingmolDTO(String buyMember, String sellSeller, Long transactionItemId, int sellItemPrice, int sellItemCount) {
        this.buyMember = buyMember;
        this.sellSeller = sellSeller;
        this.transactionItemId = transactionItemId;
        this.sellItemPrice = sellItemPrice;
        this.sellItemCount = sellItemCount;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
    }

    @Override
    public String toString() {
        return "SyupingmolDTO{" +
                "buyMember='" + buyMember + '\'' +
                ", sellSeller='" + sellSeller + '\'' +
                ", transactionItemId=" + transactionItemId +
                ", sellItemPrice=" + sellItemPrice +
                ", sellItemCount=" + sellItemCount +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
