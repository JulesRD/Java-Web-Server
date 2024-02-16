package fr.epita.assistants.jws.presentation.rest;

import fr.epita.assistants.jws.converter.Converter;
import fr.epita.assistants.jws.data.model.GameModel;
import fr.epita.assistants.jws.domain.service.Service;
import fr.epita.assistants.jws.presentation.rest.request.CreateGameRequest;
import fr.epita.assistants.jws.presentation.rest.request.JoinGameRequest;
import fr.epita.assistants.jws.presentation.rest.response.GameDetailResponse;
import fr.epita.assistants.jws.presentation.rest.response.GameListResponse;
import org.apache.thrift.server.TServer;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Endpoints {

    @Inject
    public Service service;
    @Inject
    public Converter converter;

    @Path("/games")
    @POST
    public GameDetailResponse createGame(CreateGameRequest req)
    {
        if (req == null || req.getName() == null)
            throw new BadRequestException();
        return converter.gameToGameDetail(service.createGame(req.getName()));
    }

    @Path("/games")
    @GET
    public GameListResponse getAllGames() {
        return converter.gamesToListGames(service.getAllGames());
    }

    @Path("/games/{id}")
    @GET
    public GameDetailResponse getGame(@PathParam("id") Long id) {
        GameModel game = service.getGame(id);
        return (game == null) ? null : converter.gameToGameDetail(game);
    }

    @Path("/games/{id}")
    @POST
    public GameDetailResponse joinGame(@PathParam("id") Long id, JoinGameRequest req) {
        if (req == null || req.getName() == null)
            throw new BadRequestException();
        GameModel game = service.joinGame(id, req.getName());
        if (game == null)
            throw new // TODO exception 404 here;
        return converter.gameToGameDetail(game);
    }

    @Path("/games/{id}/start")
    @PATCH
    public GameDetailResponse startGame(@PathParam("id") Long id) {
        try {
            return converter.gameToGameDetail(service.startGame(id));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
