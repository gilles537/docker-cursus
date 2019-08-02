package be.pxl.gilles.courseapi.controllers;

import be.pxl.gilles.courseapi.models.GameLobby;
import be.pxl.gilles.courseapi.repositories.LobbyRepository;
import be.pxl.gilles.courseapi.services.GameLobbyService;
import be.pxl.gilles.courseapi.support.DeleteLobbyCatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lobbies")
public class GameLobbiesController {

    @Autowired
    private GameLobbyService gameLobbyService;

    @GetMapping
    public List<GameLobby> list() {
        return gameLobbyService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody GameLobby lobby) {
        gameLobbyService.create(lobby);
    }

    @GetMapping("/{id}")
    public GameLobby get(@PathVariable("id") long id) {
        return gameLobbyService.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id, @RequestBody DeleteLobbyCatch deleteLobbyCatch) {
        gameLobbyService.delete(id,deleteLobbyCatch);
    }

}
