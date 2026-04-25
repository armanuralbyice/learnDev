package com.darkcoder.backend.utils;

import com.darkcoder.backend.dto.Response;
import org.springframework.http.HttpStatus;

import java.util.Date;

public final class ResponseBuilder {
    private ResponseBuilder(){}

    public static Response getFailResponse(HttpStatus httpStatus, String message){
        return Response.builder()
                .timestamp(new Date().getTime())
                .statusCode(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .build();
    }
    public static Response getSuccessResponse(HttpStatus httpStatus, Object content, String message){
        return Response.builder()
                .timestamp(new Date().getTime())
                .statusCode(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .content(content)
                .build();
    }

}
