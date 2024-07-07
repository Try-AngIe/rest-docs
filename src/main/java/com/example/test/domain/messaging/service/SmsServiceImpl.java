package com.example.test.domain.messaging.service;

import com.example.test.domain.messaging.dto.SmsRequestDto;
import com.example.test.domain.messaging.dto.SmsVerifyDto;
import com.example.test.domain.messaging.repository.SmsRepository;
import com.example.test.domain.messaging.util.SmsCertificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {
    private final SmsCertificationUtil smsCertificationUtil;
    private final SmsRepository smsRepository;

    @Autowired
    public SmsServiceImpl(SmsCertificationUtil smsCertificationUtil,
                          SmsRepository smsRepository) {
        this.smsCertificationUtil = smsCertificationUtil;
        this.smsRepository = smsRepository;
    }

    @Override
    public void SendSms(SmsRequestDto smsRequestDto) {
        String phoneNum = smsRequestDto.getPhoneNum();
        String certificationCode = Integer.toString((int)(Math.random() * (999999 - 100000 + 1)) + 100000);
        smsCertificationUtil.sendSMS(phoneNum, certificationCode);
        smsRepository.createSmsCertification(phoneNum, certificationCode);
    }

    @Override
    public boolean verifyCode(SmsVerifyDto smsVerifyDto) {
        if (isVerify(smsVerifyDto.getPhoneNum(), smsVerifyDto.getCertificationCode())) {
            smsRepository.deleteSmsCertification(smsVerifyDto.getPhoneNum());
            return true;
        } else {
            return false;
        }
    }

    public boolean isVerify(String phoneNum, String certificationCode) {
        return smsRepository.hasKey(phoneNum) &&
                smsRepository.getSmsCertification(phoneNum).equals(certificationCode);
    }
}
