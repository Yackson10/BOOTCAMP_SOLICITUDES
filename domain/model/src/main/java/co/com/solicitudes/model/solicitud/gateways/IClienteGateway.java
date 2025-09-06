package co.com.solicitudes.model.solicitud.gateways;

import co.com.solicitudes.model.solicitud.RequestData;
import co.com.solicitudes.model.solicitud.ResponseUser;
import reactor.core.publisher.Mono;

public interface IClienteGateway {

    Mono<ResponseUser> validateUser(RequestData.Cliente cliente);
}
