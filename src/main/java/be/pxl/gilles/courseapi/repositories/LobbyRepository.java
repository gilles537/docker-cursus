package be.pxl.gilles.courseapi.repositories;

import be.pxl.gilles.courseapi.models.GameLobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LobbyRepository extends JpaRepository<GameLobby, Long> {

}
