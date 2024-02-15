package fr.epita.assistants.jws.data.model;

import fr.epita.assistants.jws.utils.GameState;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "player")
public class PlayerModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    public Timestamp lastbomb;
    public Timestamp lastmovement;

    public int lives;
    public String name;
    public int posX;
    public int posY;
    public int position;
    @ManyToOne public GameModel game;
}
