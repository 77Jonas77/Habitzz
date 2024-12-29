package jns.sjk.Habitzz.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jednostka_czasu", schema = "HabitzzDb")
public class JednostkaCzasu {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "nazwa", nullable = false, length = 20)
    private String nazwa;

}