package jns.sjk.Habitzz.Models.Entity;

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
@Table(name = "nawyk", schema = "HabitzzDb")
public class Nawyk {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nazwa", nullable = false, length = 50)
    private String nazwa;

    @NotNull
    @Column(name = "czestotliwosc", nullable = false)
    private Integer czestotliwosc;

    @NotNull
    @Column(name = "data_rozpoczecia", nullable = false)
    private LocalDate dataRozpoczecia;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jednostka_czasu_id", nullable = false)
    private JednostkaCzasu jednostkaCzasu;

    @NotNull
    @Column(name = "interwal", nullable = false)
    private Integer interwal;

    @Size(max = 100)
    @Column(name = "opis", length = 100)
    private String opis;

    @ManyToMany(mappedBy = "nawyki")
    private List<Grupa> grupy;

    @ManyToMany()
    @JoinTable(name = "nawyk_uzytkownik",
            joinColumns = @JoinColumn(name = "nawyk_id"),
            inverseJoinColumns = @JoinColumn(name = "uzytkownik_id"))
    private List<Uzytkownik> uzytkownicy;
}