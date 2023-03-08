//CrncRateRepository 是由 Spring Boot 自動幫我們生成的 CRUD 介面
//繼承自 Spring Data JPA 中的 JpaRepository 泛型介面
//提供了許多 CRUD 方法，像是 findAll() 方法可以取得所有資料。
package com.example.rate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// public class CrncRateRepository {

// }

// 定義了一個接口 CrncRateRepository，用於操作 CrncRate 實體類對應的數據庫表
public interface CrncRateRepository extends JpaRepository<CrncRate, String> {
    // 定義了一個方法 findAll，用於查詢 CrncRate 表中的所有數據，返回類型為 List<CrncRate>
    List<CrncRate> findAll();
}