package jns.sjk.Habitzz.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "przynaleznosc", schema = "HabitzzDb")
public class Przynaleznosc {
    @EmbeddedId
    private PrzynaleznoscId id;

    @MapsId("uzytkownikId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    @MapsId("grupaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grupa_id", nullable = false)
    private Grupa grupa;

    @NotNull
    @Column(name = "data_dolaczenia", nullable = false)
    private LocalDate dataDolaczenia;

    @Size(max = 50)
    @Column(name = "nazwa_uzytkownika_w_grupie", length = 50)
    private String nazwaUzytkownikaWGrupie;

}