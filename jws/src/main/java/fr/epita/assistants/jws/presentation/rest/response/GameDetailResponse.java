package fr.epita.assistants.jws.presentation.rest.response;

import fr.epita.assistants.jws.data.model.PlayerModel;
import fr.epita.assistants.jws.utils.GameState;
import fr.epita.assistants.jws.utils.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class GameDetailResponse {
    public String startTime;
    public GameState state;
    public List<PlayerModel> players;
    public List<String> map;
    public Long id;
}
