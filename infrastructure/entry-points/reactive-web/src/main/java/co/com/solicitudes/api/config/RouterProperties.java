package co.com.solicitudes.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "entries.web")
public class RouterProperties {
    private String pathBase;
    private String pathSolicitudes;
    private String save;

}
