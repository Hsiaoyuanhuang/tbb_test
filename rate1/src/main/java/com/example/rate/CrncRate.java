//這段程式碼定義了一個 Java 類別CrncRate，並且使用了 JPA 標註這個類別對應的資料庫表以及表中的欄位名稱
//可以方便地透過這個類別來存取和修改資料庫中的資料
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
    private Double buyRate;

    @Column(name = "SELL_RATE")
    private Double sellRate;

    @Column(name = "BOOK_RATE")
    private Double bookRate;

    // 每個屬性都有對應的 getter 和 setter 方法，以方便存取和修改
    public String getCrncId() {
        return crncId;
    }

    public void setCrncId(String crncId) {
        this.crncId = crncId;
    }

    public Double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(Double buyRate) {
        this.buyRate = buyRate;
    }

    public Double getSellRate() {
        return sellRate;
    }

    public void setSellRate(Double sellRate) {
        this.sellRate = sellRate;
    }

    public Double getBookRate() {
        return bookRate;
    }

    public void setBookRate(Double bookRate) {
        this.bookRate = bookRate;
    }

}