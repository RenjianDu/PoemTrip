package com.brotherd.poemtrip.service.imp;

import com.brotherd.poemtrip.dao.IPassportDao;
import com.brotherd.poemtrip.model.Passport;
import com.brotherd.poemtrip.service.IPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
@Service
public class PassportService implements IPassportService{
  @Autowired
  private IPassportDao passportDao;

  public long loginByPassport(Passport passport) {
    Long userId=passportDao.selectUserIdByLogin(passport);
    if(userId==null||userId==0){
      return 0;
    }
    return userId;
  }

  public boolean isExistUser(String phone) {
    if(passportDao.selectPassportByPhone(phone)!=null){
      return true;
    }else {
      return false;
    }
  }

  public boolean registerUser(Passport passport){
    passportDao.insertPassport(passport);
    return true;
  }

  public Passport getPassportByPhone(String phone) {
    return passportDao.selectPassportByPhone(phone);
  }
}
