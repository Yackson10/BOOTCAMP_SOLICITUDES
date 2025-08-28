package co.com.solicitudes.model.solicitud;

import lombok.Data;

public class RequestData {

    private Cliente cliente;
    private Solicitud solicitud;

    @Data
    public static class Cliente {
        private String NumeroDocumento;
    }

    @Data
    public static class Solicitud {
        private Integer monto;
        private Integer plazo;
        private Integer tipoPrestamo;
    }
}
