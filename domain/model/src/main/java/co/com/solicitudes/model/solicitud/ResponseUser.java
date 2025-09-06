package co.com.solicitudes.model.solicitud;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ResponseUser {

    private Boolean exists;
}
