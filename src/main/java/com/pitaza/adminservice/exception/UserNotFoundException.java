package com.pitaza.adminservice.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException{
    private long id;
    private static final String ERROR_MESSAGE = "Пользователеь с id %d не найден";

    @Override
    public String getMessage() {
        return String.format(ERROR_MESSAGE,id);
    }
}
