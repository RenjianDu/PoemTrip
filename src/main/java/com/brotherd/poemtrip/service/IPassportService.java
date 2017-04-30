package com.brotherd.poemtrip.service;

import com.brotherd.poemtrip.model.Passport;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
public interface IPassportService {
  public long loginByPassport(Passport passport);

  public boolean isExistUser(String phone);

  public boolean registerUser(Passport passport);

  public Passport getPassportByPhone(String phone);
}
