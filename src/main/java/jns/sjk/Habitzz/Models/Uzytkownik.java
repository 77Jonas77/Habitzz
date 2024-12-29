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
@Table(name = "uzytkownik", schema = "HabitzzDb")
public class Uzytkownik {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nazwa_uzytkownika", nullable = false, length = 50)
    private String nazwaUzytkownika;

    @NotNull
    @Column(name = "haslo", nullable = false)
    private Integer haslo;

    @Size(max = 50)
    @NotNull
    @Column(name = "imie", nullable = false, length = 50)
    private String imie;

    @Size(max = 50)
    @NotNull
    @Column(name = "nazwisko", nullable = false, length = 50)
    private String nazwisko;

    @NotNull
    @Column(name = "data_urodzenia", nullable = false)
    private LocalDate dataUrodzenia;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rola_id", nullable = false)
    private Rola rola;

}