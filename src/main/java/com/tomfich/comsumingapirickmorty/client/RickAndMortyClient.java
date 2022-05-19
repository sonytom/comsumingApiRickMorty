package com.tomfich.comsumingapirickmorty.client;

import com.tomfich.comsumingapirickmorty.response.CharacterResponse;
import com.tomfich.comsumingapirickmorty.response.EpisodeResponse;
import com.tomfich.comsumingapirickmorty.response.ListOfEpisodesResponse;
import com.tomfich.comsumingapirickmorty.response.LocationResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Service
@AllArgsConstructor
public class RickAndMortyClient {

    private static final String RICKMORTY = "https://rickandmortyapi.com/api";


    // depois alterar @Config

    //   private final WebClient webClient;
    //public RickAndMortyClient(WebClient.Builder builder) {
    //      webClient = builder.baseUrl("https://rickandmortyapi.com/api")
    //            .build();
    //   }

    public Mono<CharacterResponse> findACharacterById(String id) {
        log.info("Buscando personagem com o id [{}]", id);
        return WebClient.create().get()
                .uri(RICKMORTY +"/character/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(CharacterResponse.class);

    }

    public Mono<LocationResponse> findALocationById(String id) {
        log.info("Buscando location com o id [{}]", id);
        return WebClient.create().get()
                .uri(RICKMORTY +"/location/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findAEpisodesById(String id) {
        log.info("Buscando location com o id [{}]", id);
        return WebClient.create().get()
                .uri(RICKMORTY +"/episode/"+ id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodesResponse> listAllEpisodes() {
        return WebClient.create().get()
                .uri(RICKMORTY +"/episode/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("verifique os parâmetros informados")))
                .bodyToFlux(ListOfEpisodesResponse.class);
    }


}
