package com.techendear.api.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.techendear.api.entity.dto.Errordto;

@Component
public class ErrorMapUtil {
    public Errordto getError(String message, int status, String details) {
	return Errordto.builder().time(LocalDateTime.now()).message(message).status(status).uri(details).build();
    }
}
