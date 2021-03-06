package com.service.channel.base;

import com.service.common.enums.code.SysCodeMsgEnum;

/**
 * 返回的结果对象模型，基础对象模型
 *
 */
public class ResultModel<T> {

    /**
     * 业务返回码
     */
    private String bizCode;

    /**
     * 业务返回信息
     */
    private String bizMsg;

    /**
     * 返回的数据模型
     */
    private T data;


    public ResultModel() {
    }

    public ResultModel(String bizCode, String bizMsg) {
        this.bizCode = bizCode;
        this.bizMsg = bizMsg;
    }

    public ResultModel(String bizCode, String bizMsg, T data) {
        this(bizCode, bizMsg);
        this.data = data;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizMsg() {
        return bizMsg;
    }

    public void setBizMsg(String bizMsg) {
        this.bizMsg = bizMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 构造异常返回结果对象
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     * @return
     */
    public static ResultModel buildErrorResult(String errorCode, String errorMsg) {

        return new ResultModel(errorCode, errorMsg);
    }

    public static <T> ResultModel<T> buildSuccessResult(T data) {
        return new ResultModel<>(SysCodeMsgEnum.SUCCESS.getCode(),
                SysCodeMsgEnum.SUCCESS.getMsg(), data);
    }

    public static final ResultModel SUCCESS = new ResultModel(SysCodeMsgEnum.SUCCESS.getCode(),
            SysCodeMsgEnum.SUCCESS.getMsg());
}
