package co.com.solicitudes.api.router;

import co.com.solicitudes.api.config.RouterProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class SolicitudRouterRest {

    private final RouterProperties properties;

    @Bean
    public RouterFunction<ServerResponse> routerCountryFunction(SolicitudHandler solicitudHandler) {
        return RouterFunctions.route()
                .POST(createRoute(properties.getSave()), solicitudHandler::save)
                .build();
    }

    private String createRoute(String route){
        return properties.getPathBase().concat(properties.getPathSolicitudes()).concat(route);
    }

}
