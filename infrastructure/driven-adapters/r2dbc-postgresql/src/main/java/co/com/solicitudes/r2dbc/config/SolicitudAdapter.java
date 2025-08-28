package co.com.solicitudes.r2dbc.config;

import co.com.solicitudes.model.solicitud.Solicitud;
import co.com.solicitudes.model.solicitud.gateways.SolicitudRepositorio;
import co.com.solicitudes.r2dbc.mapper.SolicitudEntityMapper;
import co.com.solicitudes.r2dbc.repositry.SolicitudOperation;
import co.com.solicitudes.r2dbc.repositry.TipoPrestamoOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SolicitudAdapter implements SolicitudRepositorio {

    private final SolicitudEntityMapper mapper;
    private final SolicitudOperation solicitudOperation;
    private final TipoPrestamoOperation tipoPrestamoOperation;

    @Override
    public Mono<Solicitud> save(Solicitud solicitud) {
        return Mono.just(solicitud)
                .map(mapper::toEntityFromModel)
                .flatMap(solicitudOperation::save)
                . map(mapper::toModelFromEntity);
    }

    @Override
    public Mono<Boolean> existsTipoPrestamo(Long idTipoPrestamo) {
        return tipoPrestamoOperation.existsById(idTipoPrestamo);
    }

}
