package com.malex.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Schema(description = "Client")
public record ClientRequest(

        @Schema(description = "First name") @Size(min = 3, max = 80) String firstName,

        @Schema(description = "First name") @Size(min = 3, max = 80) String lastName,

        @Schema(description = "Phone number") String phoneNumber,

        @Schema(description = "Additional info") @Size(max = 80) String info) {

    public ClientRequest {
        Objects.requireNonNull(firstName, "firstName cannot be null");
        Objects.requireNonNull(lastName, "lastName cannot be null");
    }
}
