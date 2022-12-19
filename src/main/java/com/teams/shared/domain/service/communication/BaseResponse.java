package com.teams.shared.domain.service.communication;

import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
//Genera un objeto-respuesta para mostrarlo en el JSON por cada petición
@Getter
public class BaseResponse<T> {
    private boolean success;
    private String message;
    private T resource;

    public BaseResponse(String message) {
        this.success = false;
        this.message = message;
        this.resource = null;
    }

    public BaseResponse(T resource) {
        this.success = true;
        this.message = Strings.EMPTY;
        this.resource = resource;
    }
}
