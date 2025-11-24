package io.github.marrafon91.crud.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private List<FieldMessage> err = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return err;
    }

    public void addError(String fieldName, String message) {
        err.add(new FieldMessage(fieldName, message));
    }
}
