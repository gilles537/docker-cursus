package be.pxl.gilles.courseapi.support;

import be.pxl.gilles.courseapi.models.GameLobby;
import be.pxl.gilles.courseapi.models.Player;

public class DeleteLobbyCatch {
    private Player player;
    private GameLobby gameLobby;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameLobby getGameLobby() {
        return gameLobby;
    }

    public void setGameLobby(GameLobby gameLobby) {
        this.gameLobby = gameLobby;
    }
}
