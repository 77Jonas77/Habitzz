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
@Table(name = "grupa", schema = "HabitzzDb")
public class Grupa {
    @Id
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

}