package com.epes.demo.tool.exception;

/**
 * Description:
 * Date: 2018/1/12
 * Time: 9:53
 *
 * @Author lixingjie
 * @Modifice
 */
public class ColumnIsNullException extends Exception{

    public ColumnIsNullException() {
    }

    public ColumnIsNullException(String message) {
        super(message);
    }

    public ColumnIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnIsNullException(Throwable cause) {
        super(cause);
    }

    public ColumnIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
