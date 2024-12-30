package jns.sjk.Habitzz.models.entities;

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
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id", nullable = false)
    private Uzytkownik uzytkownikAdmin;

    @NotNull
    @Column(name = "data_utworzenia", nullable = false)
    private LocalDate dataUtworzenia;

}