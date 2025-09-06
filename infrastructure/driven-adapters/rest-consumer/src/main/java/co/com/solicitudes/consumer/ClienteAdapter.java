package co.com.solicitudes.consumer;

import co.com.solicitudes.consumer.porperties.RestConsumerProperties;
import co.com.solicitudes.model.solicitud.RequestData;
import co.com.solicitudes.model.solicitud.ResponseUser;
import co.com.solicitudes.model.solicitud.gateways.IClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClienteAdapter implements IClienteGateway {

    private final WebClient webClientConfig;

    public ClienteAdapter(@Qualifier(value = "webClientConfig") WebClient webClientConfig
                            ){
        this.webClientConfig = webClientConfig.mutate().build();

    }

    @Override
    public Mono<ResponseUser> validateUser(RequestData.Cliente cliente) {
        return webClientConfig.get()
                .uri(cliente.getNumeroDocumento())
                .retrieve()
                .bodyToMono(ResponseUser.class);
    }

}