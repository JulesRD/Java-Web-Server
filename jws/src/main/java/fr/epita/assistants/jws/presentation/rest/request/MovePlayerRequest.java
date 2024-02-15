package fr.epita.assistants.jws.presentation.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovePlayerRequest {
    public int posX;
    public int posY;
}
