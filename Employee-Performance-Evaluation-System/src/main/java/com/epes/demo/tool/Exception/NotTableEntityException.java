package com.epes.demo.tool.Exception;

/**
 * Description:
 * Date: 2018/1/12
 * Time: 9:23
 *
 * @Author lixingjie
 * @Modifice
 */
public class NotTableEntityException extends Exception {

    public NotTableEntityException() {
    }

    public NotTableEntityException(String message) {
        super(message);
    }

    public NotTableEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotTableEntityException(Throwable cause) {
        super(cause);
    }

    public NotTableEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
