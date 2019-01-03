package com.jeonguk.api.enums;


import lombok.Getter;

@Getter
public enum AppHeader {
    // @formatter:off
    USER_NM,
    AUTH_TOKEN,
    ;
    // @formatter:on

    private String fieldName;

    AppHeader() {
        this.fieldName = "X-API-GATEWAY-HEADER-" + name();
    }

    AppHeader(String fieldName) {
        this.fieldName = fieldName;
    }
}
