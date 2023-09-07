package cn.mindray.showtime.base.entity;

import lombok.Data;

/**
 * @author: heshiye
 * @date 2023年08月12日
 * @email: heshiye@mindray.com
 * @description: 
 */
@Data
public class Result<T> {

    private int status;
    private String msg;
    private T data;

    public Result(){}

    public Result(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result success(){
        return new Result(0, null, null);
    }

    public static <T> Result success(T data){
        return new Result(0, null, data);
    }

    public static <T> Result failed(Exception exception){
        return new Result(-1, exception.getMessage(), null);
    }

    public static <T> Result failed(String msg){
        return new Result(-1, msg, null);
    }

    public static <T> Result notice(String msg, T data){
        return new Result(1, msg, data);
    }

}
