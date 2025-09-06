package co.com.solicitudes.consumer.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.experimental.UtilityClass;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

@UtilityClass
public class RestConsumerUtils {
    public static ClientHttpConnector getClientHttpConnector(Long timeout) {
        return new ReactorClientHttpConnector(HttpClient.create()
                .compress(true)
                .keepAlive(true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout.intValue())
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(timeout, MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(timeout, MILLISECONDS));
                }));
    }
}
