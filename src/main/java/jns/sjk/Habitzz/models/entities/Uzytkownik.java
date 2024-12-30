package jns.sjk.Habitzz.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "uzytkownik", schema = "HabitzzDb")
public class Uzytkownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nazwa_uzytkownika", nullable = false, length = 50)
    private String nazwaUzytkownika;

    @NotNull
    @Column(name = "haslo", nullable = false)
    @Size(max = 50)
    private String haslo;

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

    @ManyToMany(mappedBy = "uzytkownicy")
    private List<Nawyk> nawyki;

    @OneToOne(mappedBy = "uzytkownikMenadzer", cascade = CascadeType.REMOVE)
    private Menadzer menadzer;

    @ManyToMany()
    @JoinTable(name = "uzytkownik_grupa",
            joinColumns = @JoinColumn(name = "uzytkownik_id"),
            inverseJoinColumns = @JoinColumn(name = "grupa_id"))
    private List<Grupa> grupy;

    @OneToOne(mappedBy = "uzytkownikAdmin", cascade = CascadeType.REMOVE)
    private Administrator administrator;
}