package com.lyz.osp.finance.exception;



/**
 * audit-detector-wiki root exception
 */
public class FinanceException extends RuntimeException {

    public FinanceException() {
        super();
    }

    public FinanceException(String message) {
        super(message);
    }

    public FinanceException(Throwable cause) {
        super(cause);
    }

    public FinanceException(String message, Throwable cause) {
        super(message, cause);
    }
}

