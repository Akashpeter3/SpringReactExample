package com.api.SpringReactExample;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<?> stringMono = Mono.just("akashPeter")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
        stringMono.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("SpringBoot", "Kafka", "MicroServices", "Oracle DB")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred")))
                .log();
        fluxString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }
}
