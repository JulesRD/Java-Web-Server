package fr.epita.assistants.jws.presentation.rest;

import fr.epita.assistants.jws.converter.Converter;
import fr.epita.assistants.jws.data.model.GameModel;
import fr.epita.assistants.jws.domain.service.Service;
import fr.epita.assistants.jws.presentation.rest.request.CreateGameRequest;
import fr.epita.assistants.jws.presentation.rest.response.GameDetailResponse;
import org.apache.thrift.server.TServer;

import javax.inject.Inject;
import javax.ws.rs.*;

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

    @Path("/games/{id}")
    @GET
    public GameDetailResponse getGame(@PathParam("id") Long id) {
        GameModel game = service.getGame(id);
        return (game == null) ? null : converter.gameToGameDetail(game);
    }
}
