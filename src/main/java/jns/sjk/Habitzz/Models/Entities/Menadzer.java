package jns.sjk.Habitzz.Models.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "menadzer", schema = "HabitzzDb")
public class Menadzer {
    @Id
    @Column(name = "uzytkownik_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownikMenadzer;

    @Size(max = 50)
    @NotNull
    @Column(name = "nazwa_firmy", nullable = false, length = 50)
    private String nazwaFirmy;

    @OneToMany(mappedBy = "menadzer", cascade = CascadeType.REMOVE)
    private List<Grupa> grupy;
}