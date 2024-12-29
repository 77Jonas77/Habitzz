package jns.sjk.Habitzz.Models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "administrator", schema = "HabitzzDb")
public class Administrator {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Uzytkownik uzytkownik;

    @NotNull
    @Column(name = "data_utworzenia", nullable = false)
    private LocalDate dataUtworzenia;

}