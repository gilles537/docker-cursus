package be.pxl.gilles.courseapi.services;

import be.pxl.gilles.courseapi.models.GameLobby;
import be.pxl.gilles.courseapi.repositories.LobbyRepository;
import be.pxl.gilles.courseapi.support.DeleteLobbyCatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameLobbyService {

    @Autowired
    private LobbyRepository lobbyRepository;

    public List<GameLobby> getAll() {
        return lobbyRepository.findAll();
    }

    public void create(GameLobby gameLobby) {
        if (gameLobby.getId() != null) {
            throw new IllegalArgumentException("The ID must be null or empty");
        }
        lobbyRepository.save(gameLobby);
    }

    public void update(GameLobby gameLobby) {
        lobbyRepository.save(gameLobby);
    }

    public GameLobby find(long id) {
        return lobbyRepository.getOne(id);
    }

    public void delete(long id, DeleteLobbyCatch deleteLobbyCatch) {
        if (deleteLobbyCatch.getPlayer().getId() != deleteLobbyCatch.getGameLobby().getCreatorId()) {
            throw new IllegalArgumentException("The id of the user requesting must be the same as the creatorID");
        }
        lobbyRepository.delete(lobbyRepository.getOne(id));
    }

}
