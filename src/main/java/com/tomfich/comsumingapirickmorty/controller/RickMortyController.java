package com.tomfich.comsumingapirickmorty.controller;


import com.tomfich.comsumingapirickmorty.client.RickAndMortyClient;
import com.tomfich.comsumingapirickmorty.response.CharacterResponse;
import com.tomfich.comsumingapirickmorty.response.EpisodeResponse;
import com.tomfich.comsumingapirickmorty.response.ListOfEpisodesResponse;
import com.tomfich.comsumingapirickmorty.response.LocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/rick")
public class RickMortyController {


    RickAndMortyClient rickAndMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findACharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono<LocationResponse> getLocationById(@PathVariable String id) {
        return rickAndMortyClient.findALocationById(id);
    }

    @GetMapping("/episode/{id}")
    public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id) {
        return rickAndMortyClient.findAEpisodesById(id);
    }

    @GetMapping("/episodes")
    public Flux<ListOfEpisodesResponse> getAllEpisodes() {
        return rickAndMortyClient.listAllEpisodes();
    }

}
