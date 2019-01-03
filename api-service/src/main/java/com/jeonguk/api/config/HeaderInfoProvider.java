package com.jeonguk.api.config;

import java.time.LocalDateTime;

public interface HeaderInfoProvider {
    String getUserNm();
    String getAuthToken();
    LocalDateTime getRequestDateTime();
}
