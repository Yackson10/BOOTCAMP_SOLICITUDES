package co.com.solicitudes.r2dbc;

import co.com.solicitudes.model.solicitud.Solicitud;
import co.com.solicitudes.model.solicitud.gateways.ISolicitudRepositorio;
import co.com.solicitudes.r2dbc.mapper.SolicitudEntityMapper;
import co.com.solicitudes.r2dbc.repositry.ISolicitudOperation;
import co.com.solicitudes.r2dbc.repositry.ITipoPrestamoOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SolicitudAdapter implements ISolicitudRepositorio {

    private final SolicitudEntityMapper mapper;
    private final ISolicitudOperation ISolicitudOperation;
    private final ITipoPrestamoOperation ITipoPrestamoOperation;

    @Override
    public Mono<Solicitud> save(Solicitud solicitud) {
        return Mono.just(solicitud)
                .map(mapper::toEntityFromModel)
                .flatMap(ISolicitudOperation::save)
                . map(mapper::toModelFromEntity);
    }

    @Override
    public Mono<Boolean> existsTipoPrestamo(Long idTipoPrestamo) {
        return ITipoPrestamoOperation.existsById(idTipoPrestamo);
    }

}
