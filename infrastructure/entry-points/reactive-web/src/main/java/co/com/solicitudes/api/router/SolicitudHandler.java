package co.com.solicitudes.api.router;


import co.com.solicitudes.model.solicitud.Solicitud;
import co.com.solicitudes.usecase.solicitud.SolicitudUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Log4j2
public class SolicitudHandler {

    private final SolicitudUseCase solicitudUseCase;

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Solicitud.class)
                .flatMap(solicitudUseCase::registrar)
                .flatMap(msg -> ServerResponse.ok().bodyValue(msg))
                .onErrorResume(RuntimeException.class, ex ->
                        ServerResponse.badRequest().bodyValue(ex.getMessage())
                );

    }
}
