package fr.epita.assistants.jws.domain.service;

import fr.epita.assistants.jws.data.model.GameModel;
import fr.epita.assistants.jws.data.model.PlayerModel;
import fr.epita.assistants.jws.data.repository.GameRepository;
import fr.epita.assistants.jws.data.repository.PlayerRepository;
import fr.epita.assistants.jws.presentation.rest.request.CreateGameRequest;
import fr.epita.assistants.jws.presentation.rest.response.GameDetailResponse;
import fr.epita.assistants.jws.utils.GameState;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class Service {
    @Inject
    public GameRepository gameRepo;
    @Inject
    public PlayerRepository playerRepo;

    @ConfigProperty(name = "JWS_MAP_PATH", defaultValue = "src/test/resources/map1.rle")
    public String fileName;

    public GameModel createGame(String name)
    {
        List<String> map;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            map = stream.toList();
        } catch (IOException e) {
            map = new ArrayList<>();
        }
        GameModel game = new GameModel(Timestamp.from(Instant.now()), GameState.STARTING, new ArrayList(), map);
        PlayerModel player = new PlayerModel(null, null, 3, name, 1, 1, game);
        game.players.add(player);
        gameRepo.persist(game);
        playerRepo.persist(player);
        return game;
    }
    public GameModel getGame(Long id)
    {
        return gameRepo.findById(id);
    }

}
