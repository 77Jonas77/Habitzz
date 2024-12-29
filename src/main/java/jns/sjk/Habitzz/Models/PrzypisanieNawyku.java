package jns.sjk.Habitzz.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "przypisanie_nawyku", schema = "HabitzzDb")
public class PrzypisanieNawyku {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nawyk_id", nullable = false)
    private Nawyk nawyk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uzytkownik_id")
    private Uzytkownik uzytkownik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupa_id")
    private Grupa grupa;

}