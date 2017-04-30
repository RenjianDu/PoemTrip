package com.brotherd.poemtrip.model;

/**
 * @Description 登陆通行证
 * @Author rjdu
 * @Create-at 2017/4/30
 */
public class Passport {
  private String password;
  private String phone;
  private Long userId;


  private String verifyCode;

  public Passport() {
  }

  public Passport(String phone, String password, Long userId) {
    this.password = password;
    this.phone = phone;
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getVerifyCode() {
    return verifyCode;
  }

  public void setVerifyCode(String verifyCode) {
    this.verifyCode = verifyCode;
  }

  @Override
  public String toString() {
    return "Passport{" +
            "password='" + password + '\'' +
            ", phone='" + phone + '\'' +
            ", userId=" + userId +
            '}';
  }

  public static Passport getVerifyPassport(String verifyCode) {
    Passport passport = new Passport();
    passport.setVerifyCode(verifyCode);
    return passport;
  }

  public void setUserNullExceptId() {
    this.setPhone(null);
    this.setPassword(null);
  }

}
