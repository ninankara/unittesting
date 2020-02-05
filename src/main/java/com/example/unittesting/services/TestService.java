package com.example.unittesting.services;

import com.example.unittesting.utils.CheckProfilesUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService{

    @Autowired
    Environment env;

    final CheckProfilesUtil checkProfilesUtil;

    public String checkEnvironment() throws Exception{
        log.info("Profiles : " + env.getActiveProfiles());

        if (checkProfilesUtil.isCheck()){
            return "This environment is production environment";
        }
        return "This environmnet is Development environment";
    }
}