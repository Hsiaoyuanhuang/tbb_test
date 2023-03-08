package com.example.demo;

// 載入以下兩個Library
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {
    // 標記HTTP Get方法，並設定URL的路由
    @GetMapping("/hello")
    public String Hello() {
        // 回傳Hello World字串
        return "Hello World";
    }
}
