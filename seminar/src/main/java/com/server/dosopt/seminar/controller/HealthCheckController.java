package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.common.dto.CommonApiResponse;
import com.server.dosopt.seminar.dto.response.HealthCheckResponse;
import com.server.dosopt.seminar.exception.CommonSuccess;
import com.server.dosopt.seminar.exception.CommonError;
import com.server.dosopt.seminar.sample.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/v1")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }
    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }
    @GetMapping("/v3")
    public String healthCheckV3() {
//        Person person = new Person("윤한", "최");
//        Person person2 = new Person("최", "윤한"); //파라미터 순서가 기억안날 때..! 빌더패턴
        Person person = Person.builder()
                .lastName("최")
                .firstName("윤한")
                .build();
        return "OK";
    }
    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public CommonApiResponse<HealthCheckResponse> healthCheckV5(){
            // 어떤 작업을 수행하는 코드
        return CommonApiResponse.success(CommonSuccess.HEALTH_CHECK_SUCCESS, HealthCheckResponse.of(true));
            //처음에 try catch문 쓰려다보니 생각해보니까 나중에 exception은 다같이 서비스단에서 처리하는게 좋을 것 같음.
            //그리고 500 에러를 커스텀 에러에 넣고 생각을 해보니.. 그냥 healthcheck라서 서버가 죽었으면 생각해보니 커스텀에러로 처리할 이유가 없음..ㅎ
    }
}
