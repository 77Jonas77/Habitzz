package jns.sjk.Habitzz.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UzytkownikGrupaId implements Serializable {
    private static final long serialVersionUID = -6043655679259702498L;
    @NotNull
    @Column(name = "uzytkownik_id", nullable = false)
    private Integer uzytkownikId;

    @NotNull
    @Column(name = "grupa_id", nullable = false)
    private Integer grupaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UzytkownikGrupaId entity = (UzytkownikGrupaId) o;
        return Objects.equals(this.uzytkownikId, entity.uzytkownikId) &&
                Objects.equals(this.grupaId, entity.grupaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uzytkownikId, grupaId);
    }

}