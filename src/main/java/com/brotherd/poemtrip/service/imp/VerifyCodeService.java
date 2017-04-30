package com.brotherd.poemtrip.service.imp;

import com.brotherd.poemtrip.service.IVerifyCodeService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
@Service
public class VerifyCodeService implements IVerifyCodeService{
  public String getVerifyCode(String phone) {
    return "123456";
  }

  public boolean validVerfifyCode(String phone, String code) {
    return true;
  }
}
