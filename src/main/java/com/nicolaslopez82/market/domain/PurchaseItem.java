package com.nicolaslopez82.market.domain;

public class PurchaseItem {
    private Integer productId;
    private Integer quantity;
    private Double totalPrice;
    private Boolean purchased;

    public PurchaseItem(){}
    public PurchaseItem(Integer productId, Integer quantity, Double totalPrice, Boolean purchased) {}

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }
}
