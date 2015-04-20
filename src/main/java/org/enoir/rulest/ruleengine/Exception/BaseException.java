package org.enoir.rulest.ruleengine.Exception;

/**
 * Created by frank on 2015/4/20.
 */
public class BaseException extends Exception {
    private String errorCode;
    public BaseException(String errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
