package br.edu.ifpi.springflyway.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Position position;
    private LocalDate birthDate;
    @ManyToOne @JsonIgnoreProperties(value = "tournaments")
    private Team team;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "id", allowSetters = true)
    private Statistics statistics;
//    @UpdateTimestamp
//    private LocalDateTime lastUpdate;
}
