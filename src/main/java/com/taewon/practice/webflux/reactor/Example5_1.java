package com.taewon.practice.webflux.reactor;

import reactor.core.publisher.Flux;

public class Example5_1 {

    public static void main(String[] args) {

        Flux<String> sequnce = Flux.just("Hello", "Reactor");

        sequnce.map(String::toLowerCase)
                .subscribe(System.out::println);
    }
}
