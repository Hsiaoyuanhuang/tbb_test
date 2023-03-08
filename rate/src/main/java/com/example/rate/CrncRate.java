package com.example.rate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // 表示這是一個實體類別，會映射到資料庫的一個表格
@Table(name = "CRNC_RATE") // 標註了這個類別映射到的資料庫表名稱為 CRNC_RATE
public class CrncRate {
    @Id // 表示這是資料庫表格的主鍵
    // 表示這個屬性對應到資料庫表格中的 CRNC_ID 欄位
    // 類別中定義了 CrncRate 資料表中的 8 個欄位的對應 Java 屬性
    @Column(name = "CRNC_ID")
    private String crncId;

    @Column(name = "BUY_RATE")
    private Float buyRate;

    @Column(name = "SELL_RATE")
    private Float sellRate;

    @Column(name = "BOOK_RATE")
    private Float bookRate;

    @Column(name = "MESSAGE_CODE")
    private String messageCode;

    @Column(name = "DOT")
    private String dot;

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @Column(name = "UPDATE_TIME")
    private String updateTime;

    // 每個屬性都有對應的 getter 和 setter 方法，以方便存取和修改
    public String getCrncId() {
        return crncId;
    }

    public void setCrncId(String crncId) {
        this.crncId = crncId;
    }

    public Float getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Float buyRate) {
        this.buyRate = buyRate;
    }

    public Float getSellRate() {
        return sellRate;
    }

    public void setSellRate(Float sellRate) {
        this.sellRate = sellRate;
    }

    public Float getBookRate() {
        return bookRate;
    }

    public void setBookRate(Float bookRate) {
        this.bookRate = bookRate;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
