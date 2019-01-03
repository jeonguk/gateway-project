package com.jeonguk.gateway.config;

import java.time.LocalDateTime;

public interface HeaderInfoProvider {
    String getUserName();
    LocalDateTime getRequestDateTime();
}
