package com.fourm.fourm.fourmenum;

public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(0, "成功"),
    /* 失败状态码 */
    FAILED(9001,"失败"),

    NOTFOUND(9404,"没有找到该项"),
    NOTFOUND_USER(9405,"不存在该用户"),

    SYSTEM_ERROR(10000, "系统异常，请稍后重试"),


    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),


    /* 用户错误：20001-29999*/
    USER_HAS_EXISTED(20001, "用户已存在");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }


}
