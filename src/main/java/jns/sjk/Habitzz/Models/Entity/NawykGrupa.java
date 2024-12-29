package jns.sjk.Habitzz.Models.Entity;

import jakarta.persistence.*;
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

    @Column(name = "data_zakonczenia")
    private LocalDate dataZakonczenia;

}