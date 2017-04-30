package com.brotherd.poemtrip.dao;

import com.brotherd.poemtrip.model.Passport;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
@Repository
public interface IPassportDao {
  public Long selectUserIdByLogin(Passport passport);
  public void insertPassport(Passport passport);
  public Passport selectPassportByPhone(String phone);
}
