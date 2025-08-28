package co.com.solicitudes.model.solicitud;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Solicitud {

    private Double monto;
    private Integer plazo;
    private String email;
    private Long idEstado;
    private Long idTipoPrestamo;
}
