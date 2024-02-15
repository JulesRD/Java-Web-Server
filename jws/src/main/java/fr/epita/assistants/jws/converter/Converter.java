package fr.epita.assistants.jws.converter;

import fr.epita.assistants.jws.data.model.GameModel;
import fr.epita.assistants.jws.presentation.rest.response.GameDetailResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Converter {
    public GameDetailResponse gameToGameDetail(GameModel game)
    {
        return new GameDetailResponse(game.starttime.toString(), game.state, game.players, game.map, game.id);
    }
}
