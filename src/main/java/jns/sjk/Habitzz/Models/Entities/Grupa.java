package jns.sjk.Habitzz.Models.Entities;

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
@Table(name = "grupa", schema = "HabitzzDb")
public class Grupa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menadzer_id", nullable = false)
    private Menadzer menadzer;

    @NotNull
    @Column(name = "data_utworzenia", nullable = false)
    private LocalDate dataUtworzenia;

    @Size(max = 200)
    @Column(name = "opis", length = 200)
    private String opis;

    @ManyToMany
    @JoinTable(name = "nawyk_grupa",
            joinColumns = @JoinColumn(name = "grupa_id"),
            inverseJoinColumns = @JoinColumn(name = "nawyk_id"))
    private List<Nawyk> nawyki;

    @ManyToMany(mappedBy = "grupy")
    private List<Uzytkownik> uzytkownicy;
}