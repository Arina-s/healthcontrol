package com.arinauniversity.healthcontrol.exceptions;

public class SqlInjectionException extends RuntimeException {

    @Override
    public String getMessage() {
        return "An sql-injection attempt may have been made...";
    }

}
