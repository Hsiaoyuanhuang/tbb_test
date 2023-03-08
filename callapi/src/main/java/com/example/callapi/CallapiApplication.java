package com.example.callapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

// 設定 Spring Boot 應用程式的配置
@RestController
@SpringBootApplication
public class CallapiApplication {

	// 使用 @GetMapping 註釋指定 API 端點的路徑
	// 這裡指定的路徑是 "/opendata"

	// 主方法用於啟動 Spring Boot 應用程式
	public static void main(String[] args) {
		SpringApplication.run(CallapiApplication.class, args);
	}

	@GetMapping("/opendata")
	public String getOpenData() {
		// 創建一個新的 RestTemplate 對象
		RestTemplate restTemplate = new RestTemplate();
		// 呼叫 OpenData URL 並取得回應資料
		String url = "https://od.moi.gov.tw/api/v1/rest/datastore/301000000A-002073-001";
		// 將回應資料返回給客戶端
		String response = restTemplate.getForObject(url, String.class);
		return response;
	}

}
