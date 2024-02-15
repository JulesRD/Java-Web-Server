package fr.epita.assistants.jws.data.model;

import fr.epita.assistants.jws.utils.GameState;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
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

    public PlayerModel(Timestamp lastbomb, Timestamp lastmovement, int lives, String name, int posX, int posY, GameModel game) {
        this.lastbomb = lastbomb;
        this.lastmovement = lastmovement;
        this.lives = lives;
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.position = 1;
        this.game = game;
    }
}
