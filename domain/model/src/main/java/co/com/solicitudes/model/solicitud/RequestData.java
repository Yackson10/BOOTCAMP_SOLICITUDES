package co.com.solicitudes.model.solicitud;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RequestData {

    private Cliente cliente;
    private Solicitud solicitud;

    @Data
    public static class Cliente {
        private String NumeroDocumento;
    }
}
