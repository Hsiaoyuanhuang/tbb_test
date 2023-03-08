//是實現一個 RESTful API，提供查詢所有 CRNC 匯率的功能
package com.example.rate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //宣告一個 RESTful API 的控制器類別
public class CrncRateController {
    @Autowired //告訴 Spring Boot 在啟動時自動注入 CrncRateRepository 介面的實例
    private CrncRateRepository crncRateRepository;

    /**
     * @return
     */
    @GetMapping("/crncrate") //標註 HTTP GET 請求的路徑
    //當收到 /crncrate 的 GET 請求時，會執行 getAllCrncRates() 方法
    //並回傳一個 List<CrncRate>，這裡的 CrncRate 就是前面定義的實體類別
    public List<CrncRate> getAllCrncRates() {
        return crncRateRepository.findAll();
    }
}