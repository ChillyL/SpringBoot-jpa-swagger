package com.chilly.jpademo.exception;

/**
 *  业务异常提示信息枚举类
 */
public enum BusinessMsgEnum {
    /** 参数异常 */
    PARMETER_EXCEPTION("102", "参数异常!"),
    /** 等待超时 */
    SERVICE_TIME_OUT("103", "服务调用超时！"),
    /** 参数过大 */
    PARMETER_BIG_EXCEPTION("102", "传入参数过大!"),
    /** 500 : 发生异常 */
    UNEXPECTED_EXCEPTION("500", "系统发生异常，请联系管理员！");

    /**
     * 消息码
     */
    private String code;
    /**
     * 消息内容
     */
    private String msg;

    private BusinessMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
