package com.example.unittesting.controller;

import com.example.unittesting.services.TestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/test")
@Api(value = "Testing Service", tags="test controller", description="for testing purpose")
public class TestController{
    final TestService testService;

    @GetMapping("/checkProf")
    @ApiOperation(value = "Check current profiles")
    public String checkProfiles() throws Exception{
        return testService.checkEnvironment();
    }
}