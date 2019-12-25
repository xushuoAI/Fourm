package com.fourm.fourm.result.entity;


import com.fourm.fourm.fourmenum.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@Data//使用这个注解，就不用再去手写Getter,Setter,equals,canEqual,hasCode,toString等方法了，注解后在编译时会自动加进去。
public class ResultArticleJson<T> {

    private Integer code;
    private String msg;
    private T data;

    //操作成功，没有data数据
    public static ResultArticleJson suc() {
        ResultArticleJson result = new ResultArticleJson();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }
    //操作成功，有data数据
    public static ResultArticleJson suc(Object data) {
        ResultArticleJson result = new ResultArticleJson();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败，指定status、desc
     */
    public static ResultArticleJson fail(Integer status, String msg) {
        ResultArticleJson result = new ResultArticleJson();
        result.setCode(status);
        result.setMsg(msg);
        return result;
    }


    /**
     * 失败，指定ResultCode枚举
     */
    public static ResultArticleJson fail() {
        ResultArticleJson result = new ResultArticleJson();
        result.setResultCode(ResultCode.FAILED);
        return result;
    }
    /**
     * 失败，指定ResultCode枚举
     */
    public static ResultArticleJson notFoundUser() {
        ResultArticleJson result = new ResultArticleJson();
        result.setResultCode(ResultCode.NOTFOUND_USER);
        return result;
    }

    public static ResultArticleJson notFound(Object data) {
        ResultArticleJson result = new ResultArticleJson();
        result.setResultCode(ResultCode.NOTFOUND);
        result.setData(data);
        return result;
    }



    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

