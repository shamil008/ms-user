package com.example.users.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ExceptionConstants {
    USER_NOT_FOUND("USER_NOT_FOUND","User not found"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION","Unexpected exception occurred");
    private String code;
    private String message;
}
