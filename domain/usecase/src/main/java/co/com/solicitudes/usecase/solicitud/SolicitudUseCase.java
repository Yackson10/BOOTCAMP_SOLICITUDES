package co.com.solicitudes.usecase.solicitud;

import co.com.solicitudes.model.solicitud.Solicitud;
import co.com.solicitudes.model.solicitud.gateways.ISolicitudRepositorio;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RequiredArgsConstructor
public class SolicitudUseCase {

    private static final double MIN_MONTO = 500_000;
    private static final double MAX_MONTO = 100_000_000;
    private static final int MIN_PLAZO = 6;
    private static final int MAX_PLAZO = 84;

    private final ISolicitudRepositorio solicitudRepositorio;

    public Mono<Solicitud> registrar(Solicitud solicitud) {
        return Mono.just(solicitud)
                .filter(s->s.getEmail() != null && !s.getEmail().isEmpty())
                .switchIfEmpty(Mono.error(new RuntimeException("El email del cliente es obligatorio")))
                .filter(s -> s.getPlazo() != null && s.getPlazo() > 0)
                .switchIfEmpty(Mono.error(new RuntimeException("El plazo debe ser mayor a 0")))
                .filter(s -> s.getIdTipoPrestamo() != null)
                .switchIfEmpty(Mono.error(new RuntimeException("El tipo de préstamo es obligatorio")))
                .filter(s -> s.getMonto() >= MIN_MONTO && s.getMonto() <= MAX_MONTO)
                .switchIfEmpty(Mono.error(new RuntimeException(
                        "El monto debe estar entre " + MIN_MONTO + " y " + MAX_MONTO)))
                .filter(s -> s.getPlazo() >= MIN_PLAZO && s.getPlazo() <= MAX_PLAZO)
                .switchIfEmpty(Mono.error(new RuntimeException(
                        "El plazo debe estar entre " + MIN_PLAZO + " y " + MAX_PLAZO + " meses")))
                .flatMap(s -> solicitudRepositorio.existsTipoPrestamo(s.getIdTipoPrestamo())
                        .filter(Boolean::booleanValue)
                        .switchIfEmpty(Mono.error(new RuntimeException("El tipo de préstamo no existe")))
                        .thenReturn(s))
                .map(s -> Solicitud.builder()
                        .email(s.getEmail())
                        .monto(s.getMonto())
                        .plazo(s.getPlazo())
                        .idTipoPrestamo(s.getIdTipoPrestamo())
                        .idEstado(1L)
                        .build())

                .flatMap(solicitudRepositorio::save);

    }

}
