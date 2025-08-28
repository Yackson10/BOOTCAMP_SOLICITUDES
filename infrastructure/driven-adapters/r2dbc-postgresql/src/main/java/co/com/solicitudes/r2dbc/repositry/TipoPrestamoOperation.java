package co.com.solicitudes.r2dbc.repositry;

import co.com.solicitudes.r2dbc.entity.TipoPrestamoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface TipoPrestamoOperation extends R2dbcRepository<TipoPrestamoEntity, Long> {

    Mono<TipoPrestamoEntity> findById(Integer id);

}
