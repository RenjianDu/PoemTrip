package com.brotherd.poemtrip.controller;

import com.brotherd.poemtrip.model.Passport;
import com.brotherd.poemtrip.service.IPassportService;
import com.brotherd.poemtrip.service.IVerifyCodeService;
import com.brotherd.poemtrip.utils.ErrorCode;
import com.brotherd.poemtrip.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
@Controller
public class PassportController {

  @Autowired
  private IPassportService passportService;

  @Autowired
  private IVerifyCodeService verifyCodeService;

  @RequestMapping(value = "/login", method = {RequestMethod.POST})
  @ResponseBody
  public JsonResult login(Passport passport) throws Exception {
    System.out.println(passport);
    System.out.println(JsonResult.getSuccessBody(passportService.loginByPassport(passport)));
    return JsonResult.getSuccessBody(new Passport(null, null, passportService.loginByPassport(passport)));
  }

  @RequestMapping(value = "/fastLogin", method = {RequestMethod.POST})
  @ResponseBody
  public JsonResult fastLogin(String phone,String verifyCode) throws Exception {
    if (!passportService.isExistUser(phone)) {
      return JsonResult.getFailBody(ErrorCode.USER_NOT_EXIST_ERROR);
    }
    if(!verifyCodeService.validVerfifyCode(phone,verifyCode)){
      return JsonResult.getFailBody(ErrorCode.VERIFY_ERROR);
    }
    Passport passport=passportService.getPassportByPhone(phone);
    passport.setUserNullExceptId();
    return JsonResult.getSuccessBody(passport);
  }

  @RequestMapping(value = "/getRegisterVerifyCode", method = RequestMethod.GET)
  @ResponseBody
  public JsonResult getVerifyCode(String phone) throws Exception {
    if (passportService.isExistUser(phone)) {
      return JsonResult.getFailBody(ErrorCode.USER_EXIST_ERROR);
    }
    return JsonResult.getSuccessBody(Passport.getVerifyPassport(verifyCodeService.getVerifyCode(phone)));
  }

  @RequestMapping(value = "/getLoginVerifyCode", method = RequestMethod.GET)
  @ResponseBody
  public JsonResult getLoginVerifyCode(String phone) throws Exception {
    if (!passportService.isExistUser(phone)) {
      return JsonResult.getFailBody(ErrorCode.USER_NOT_EXIST_ERROR);
    }
    return JsonResult.getSuccessBody(Passport.getVerifyPassport(verifyCodeService.getVerifyCode(phone)));
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public JsonResult register(String phone, String verifyCode, String password) throws Exception {
    if (passportService.isExistUser(phone)) {
      return JsonResult.getFailBody(ErrorCode.USER_EXIST_ERROR);
    }
    if (!verifyCodeService.validVerfifyCode(phone, verifyCode)) {
      return JsonResult.getFailBody(ErrorCode.VERIFY_ERROR);
    }
    passportService.registerUser(new Passport(phone,verifyCode,123l));
    // TODO: 2017/4/30 用户profile生成
    return JsonResult.getSuccessBody(new Passport(null, null, 123l));
  }
}
