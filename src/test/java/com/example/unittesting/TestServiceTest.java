package com.example.unittesting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.example.unittesting.services.TestService;
import com.example.unittesting.utils.CheckProfilesUtil;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
public class TestServiceTest{

    static Logger log = LoggerFactory.getLogger(TestService.class); 

    @Autowired
    CheckProfilesUtil checkProfilesUtil;

    @Autowired
    TestService testService;

    @Test
    public void checkingTest() throws Exception {
        String result;

        //when
        result = testService.checkEnvironment();
        log.info("Result >>> " + result);
        //then
        assertEquals("false", checkProfilesUtil.isCheck());
    }
}