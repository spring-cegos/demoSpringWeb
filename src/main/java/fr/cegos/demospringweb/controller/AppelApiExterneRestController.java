package fr.cegos.demospringweb.controller;

import fr.cegos.demospringweb.bo.Phone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/appelAPI")
class AppelApiExterneRestController {
    private static final String API_URL = "https://api.restful-api.dev/objects";

    @GetMapping
    List<Phone> appelAPI() {

        // J'utilise RestClient pour appeler une API externe
        RestClient restClient = RestClient.create();
        List<Phone> telephones = restClient
                // requête GET sur https://api.restful-api.dev/objects
                .get().uri(API_URL)
                // conversion du JSON recupéré en instance de  List<Phone>
                .retrieve().body(List.class);
        // conversion du JSON recupéré

        return telephones;
    }

}
