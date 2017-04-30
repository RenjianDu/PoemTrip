package com.brotherd.poemtrip.utils;

/**
 * @Description
 * @Author rjdu
 * @Create-at 2017/4/30
 */
public class JsonResult {
  public int ret=-1;
  public String msg=null;
  public Object body;
  public static JsonResult getSuccessBody(Object o){
    JsonResult jsonResult=new JsonResult();
    jsonResult.body=o;
    jsonResult.ret=0;
    return jsonResult;
  }

  public static JsonResult getFailBody(int ret){
    JsonResult jsonResult=new JsonResult();
    jsonResult.ret=ret;
    jsonResult.msg=PropertyUtil.getProperty(String.valueOf(ret));
    System.out.println(jsonResult.msg);
    return  jsonResult;
  }

  @Override
  public String toString() {
    return "JsonResult{" +
            "ret=" + ret +
            ", msg='" + msg + '\'' +
            ", body=" + body +
            '}';
  }
}
