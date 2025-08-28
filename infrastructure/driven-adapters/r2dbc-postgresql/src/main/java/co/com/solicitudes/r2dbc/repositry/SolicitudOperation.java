package co.com.solicitudes.r2dbc.repositry;

import co.com.solicitudes.r2dbc.entity.SolicitudEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface SolicitudOperation extends R2dbcRepository<SolicitudEntity, Long> {

    Mono<SolicitudEntity> findById(Integer id);

}
