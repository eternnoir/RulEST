package org.enoir.rulest.ruleengine.Exception;

/**
 * Created by frank on 2015/4/20.
 */
public class ParseJsonException extends BaseException {
    public ParseJsonException(String errorCode, String message) {
        super("02", message);
    }
}
