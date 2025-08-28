package co.com.solicitudes.model.solicitud.gateways;

import co.com.solicitudes.model.solicitud.Solicitud;
import reactor.core.publisher.Mono;

public interface ISolicitudRepositorio {

    Mono<Solicitud> save(Solicitud solicitud);

    Mono<Boolean> existsTipoPrestamo(Long idTipoPrestamo);
}
