package com.brotherd.poemtrip.service;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
public interface IVerifyCodeService {

  public String getVerifyCode(String phone);
  public boolean validVerfifyCode(String phone,String code);

}
