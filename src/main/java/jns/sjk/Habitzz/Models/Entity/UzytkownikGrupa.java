package jns.sjk.Habitzz.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "uzytkownik_grupa", schema = "HabitzzDb")
public class UzytkownikGrupa {
    @EmbeddedId
    private UzytkownikGrupaId id;

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