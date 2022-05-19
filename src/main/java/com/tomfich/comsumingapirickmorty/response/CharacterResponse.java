package com.tomfich.comsumingapirickmorty.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CharacterResponse {
    private String name;
    private String status;
    private String species;
    private List<String> episode;
}
