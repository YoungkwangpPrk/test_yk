package com.com4in.testbackend.controller;

import com.com4in.testbackend.dto.BasicResponse;
import com.com4in.testbackend.dto.WpiDto;
import com.com4in.testbackend.dto.response.Response;
import com.com4in.testbackend.service.WpiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.com4in.testbackend.dto.response.Response.success;

@RestController
@Api(tags = {"조회 API"})
@RequiredArgsConstructor
public class Apicontroller {
    private final WpiService wpiService;


    @GetMapping("/api/hello")
    public Object test() {
        return "Hello World!";
    }


    @ApiOperation(
            value = "조회"
            , notes = "데이터조회")
    @GetMapping("/api/db")
    public List<WpiDto> testdb() {
        return wpiService.getWpiList();
    }

    @GetMapping("/api/result2")
    public Response testResult2() {
        return success(wpiService.getWpiList());
    } //end of readUserInfoByAdmin()

    @GetMapping("/api/result")
    public ResponseEntity<BasicResponse> testResult() {
        BasicResponse basicResponse = new BasicResponse();

        if (wpiService.getWpiList() != null) {
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .message("사용자 조회 성공")
                    .result(Arrays.asList(wpiService.getWpiList()))
                    .count(1).build();

        } else {
            basicResponse = BasicResponse.builder()
                    .code(HttpStatus.NOT_FOUND.value())
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .message("사용자를 찾을 수 없습니다.")
                    .result(Collections.emptyList())
                    .count(0).build();
        }

        return new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }
}
