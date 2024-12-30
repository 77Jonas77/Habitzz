package jns.sjk.Habitzz.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "nawyk_grupa", schema = "HabitzzDb")
public class NawykGrupa {
    @EmbeddedId
    private NawykGrupaId id;

    @MapsId("nawykId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nawyk_id", nullable = false)
    private Nawyk nawyk;

    @MapsId("grupaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grupa_id", nullable = false)
    private Grupa grupa;

    @NotNull
    @Column(name = "data_rozpoczecia", nullable = false)
    private LocalDate dataRozpoczecia;

    @Column(name = "data_zakonczenia")
    private LocalDate dataZakonczenia;

}