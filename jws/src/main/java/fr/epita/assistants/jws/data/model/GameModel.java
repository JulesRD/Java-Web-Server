package fr.epita.assistants.jws.data.model;

import fr.epita.assistants.jws.utils.GameState;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "game")
public class GameModel {
    @Column(name = "id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    public Timestamp starttime;
    public GameState state;

    @OneToMany(targetEntity = PlayerModel.class, mappedBy = "game")
    public List<PlayerModel> players;
    public @ElementCollection(fetch = FetchType.EAGER) @CollectionTable(name = "game_map", joinColumns = @JoinColumn(name = "id")) List<String> map;

    public GameModel(Timestamp starttime, GameState state, List<PlayerModel> players, List<String> map) {
        this.starttime = starttime;
        this.state = state;
        this.players = players;
        this.map = map;
    }
}
