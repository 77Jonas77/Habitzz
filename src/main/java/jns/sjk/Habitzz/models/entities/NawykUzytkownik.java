package jns.sjk.Habitzz.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "nawyk_uzytkownik", schema = "HabitzzDb")
public class NawykUzytkownik {
    @EmbeddedId
    private NawykUzytkownikId id;

    @MapsId("uzytkownikId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    @MapsId("nawykId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nawyk_id", nullable = false)
    private Nawyk nawyk;

    @NotNull
    @Column(name = "data_rozpoczecia", nullable = false)
    private LocalDate dataRozpoczecia;

    @Column(name = "data_zakonczenia")
    private LocalDate dataZakonczenia;

}