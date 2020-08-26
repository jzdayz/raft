package io.github.jzdayz.raft;

import lombok.Data;

import java.util.Map;

@Data
public class R<T> {

    private int code = 200;
    private T data;

    public static final int ERROR_CODE = 9000;

    public static <T> R<T> ok(T t){
        R<T> rs = new R<>();
        rs.setData(t);
        return rs;
    }

    public static <T> R<T> error(T t){
        R<T> rs = new R<>();
        rs.setCode(ERROR_CODE);
        rs.setData(t);
        return rs;
    }

    public static R<String> error(){
        return error("错误");
    }

}
