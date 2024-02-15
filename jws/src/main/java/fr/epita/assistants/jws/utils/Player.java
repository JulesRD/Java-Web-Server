package fr.epita.assistants.jws.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private int id;
    private String name;
    private int lives;
    private int posX;
    private int posY;
}
