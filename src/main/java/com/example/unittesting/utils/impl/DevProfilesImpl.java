package com.example.unittesting.utils.impl;

import com.example.unittesting.utils.CheckProfilesUtil;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class DevProfilesImpl implements CheckProfilesUtil{
    @Override
    public boolean isCheck() throws Exception{
        return false;
    }
}