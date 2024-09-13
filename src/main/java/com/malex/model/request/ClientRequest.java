package com.malex.model.request;

import java.util.Objects;

public record ClientRequest(String firstName, String lastName, String phoneNumber, String info) {

    public ClientRequest {
        Objects.requireNonNull(firstName, "firstName cannot be null");
        Objects.requireNonNull(lastName, "lastName cannot be null");
    }
}
