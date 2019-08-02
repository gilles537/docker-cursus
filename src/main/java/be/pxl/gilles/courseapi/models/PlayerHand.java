package be.pxl.gilles.courseapi.models;

import be.pxl.gilles.courseapi.gameModels.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class PlayerHand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private List<Card> cardList;

}
