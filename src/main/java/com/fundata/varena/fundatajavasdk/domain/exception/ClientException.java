package com.fundata.varena.fundatajavasdk.domain.exception;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public class ClientException extends Exception{
    private static final long serialVersionUID = -1602605447490163734L;
    /** HTTP异常默认状态编码 */
    public static final int DEFAULT_CLIENT_EXCEPTION_CODE = 400;
    /** 异常编码 */
    public final int code;

    public ClientException(int code) {
        this.code = code;
    }

    public ClientException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ClientException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ClientException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
