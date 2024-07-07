package com.example.test.domain.messaging.service;

import com.example.test.domain.messaging.dto.SmsRequestDto;
import com.example.test.domain.messaging.dto.SmsVerifyDto;

public interface SmsService {
    void SendSms(SmsRequestDto smsRequestDto);
    boolean verifyCode(SmsVerifyDto smsVerifyDto);
}
