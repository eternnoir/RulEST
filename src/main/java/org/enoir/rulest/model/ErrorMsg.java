package org.enoir.rulest.model;

/**
 * Created by frank on 2015/4/1.
 */
public class ErrorMsg extends RulESTBaseModel{
    private String errorMessage;
    private String errorCode;

    public ErrorMsg(String errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage=errorMessage;
    }

    public ErrorMsg(){}

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
