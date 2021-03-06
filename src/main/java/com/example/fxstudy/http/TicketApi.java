package com.example.fxstudy.http;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @Author: D7-Dj
 * @Date: 2018/12/3 22:18
 */
public interface TicketApi {

    /**
     *  初始化cookie 不然无法登陆
     * @Param req 其实不需要
     */
    @GET("/otn/HttpZF/logdevice")
    Call<String> getInitCookie(@QueryMap Map<String,String> req);


    /**
     * 获取qr64验证码
     * @param req appid=otn
     * @return
     */
    @POST("/passport/web/create-qr64")
    @FormUrlEncoded
    Call<String> getQr64(@FieldMap Map<String,String> req);

    @POST("/passport/web/checkqr")
    @FormUrlEncoded
    Call<String> checkQr(@FieldMap Map<String,String> req);

    /**
     * 获取验证码
     * @param req
     * @return
     */
    @GET("/passport/captcha/captcha-image64")
    public Call<String> getCaptcja(@QueryMap Map<String,String> req);


    /**
     * 验证验证码答案
     * @param req
     * @return
     */
    @GET("/passport/captcha/captcha-check")
    public Call<String> checkCaptcja(@QueryMap Map<String,String> req);

    /**
     * 登录
     * @param req
     * @return
     */
    @POST("/passport/web/login")
    @FormUrlEncoded
//    @Headers("Content-Type:application/x-www-form-urlencoded; charset=UTF-8")
    Call<String> login(@FieldMap Map<String, String> map);



    /**
     * 用户登录
     * @return
     */
    @GET("/otn/login/userLogin")
    public Call<String> loginUser();

    /**
     * 查票接口
     * @param req
     * @return
     */
    /*
    第一个方法的请求连接会不定时的改变，需要不停修改代码，不建议使用，建议第二种.
     */
    @Deprecated
    @GET("/otn/leftTicket/queryX")
    public Call<String> queryTicket(@QueryMap Map<String,String> req);

    @GET
    public Call<String> queryTicket(@Url String url, @QueryMap Map<String,String> req);

    @GET("/otn/leftTicket/init")
    public Call<String> getQueryUrl();

    /**
     * 订票时检测用户是否登录
     * @param req
     * @return
     */
    @POST("/otn/login/checkUser")
    public Call<String> checkUser(@QueryMap Map<String,String> req);


    /**
     * @param req
     * @return
     */
    @GET("/otn/passport")
    public Call<String> passport(@QueryMap Map<String,String> req);


    /**
     * 获取登录的凭证
     * @param req
     * @return
     */
    @POST("/passport/web/auth/uamtk")
    public Call<String> uamtk(@QueryMap Map<String,String> req);

    /**
     * 将凭证传给12306服务器
     * @param req
     * @return
     */
    @POST("/otn/uamauthclient")
    public Call<String> uamauthclient(@QueryMap Map<String,String> req);

    /**
     * 提交订票请求
     * @param req
     * @return
     */
    @POST("/otn/leftTicket/submitOrderRequest")
    public Call<String> submitOrderRequest(@QueryMap Map<String,String> req);

    /**
     * 获取一个DOC 内含许多关键信息
     * @param req
     * @return
     */
    @POST("/otn/confirmPassenger/initDc")
    public Call<String> initDc(@QueryMap Map<String,String> req);

    /**
     * 获取账号的所有可购票人的身份信息
     * @param req
     * @return
     */
    @POST("/otn/confirmPassenger/getPassengerDTOs")
    public Call<String> getPassengerDTOs(@QueryMap Map<String,String> req);

    /**
     * 确认车票信息
     * @param req
     * @return
     */
    @POST("/otn/confirmPassenger/checkOrderInfo")
    public Call<String> checkOrderInfo(@QueryMap Map<String,String> req);

    /**
     * 获取买票排队号，大概吧
     * @param req
     * @return
     */
    @POST("/otn/confirmPassenger/getQueueCount")
    public Call<String> getQueueCount(@QueryMap Map<String,Object> req);

    /**
     * 提交订单吧，大概
     * @param req
     * @return
     */
    @POST("/otn/confirmPassenger/confirmSingleForQueue")
    public Call<String> confirmSingleForQueue(@QueryMap Map<String,String> req);

}
