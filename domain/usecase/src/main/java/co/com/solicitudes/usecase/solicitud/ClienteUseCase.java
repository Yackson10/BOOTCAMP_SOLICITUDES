package co.com.solicitudes.usecase.solicitud;

import co.com.solicitudes.model.solicitud.RequestData;
import co.com.solicitudes.model.solicitud.ResponseUser;
import co.com.solicitudes.model.solicitud.gateways.IClienteGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClienteUseCase {

    private final IClienteGateway iClienteGateway;

    public Mono<ResponseUser> validateDocument(RequestData.Cliente cliente) {
        return iClienteGateway.validateUser(cliente);
    }
}
