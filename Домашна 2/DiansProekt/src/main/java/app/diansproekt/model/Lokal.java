package app.diansproekt.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lokal")
public class Lokal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String barOrClub;
    double xCoordinates, yCoordinates;
}
