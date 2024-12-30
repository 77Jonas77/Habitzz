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
public class NawykGrupaId implements Serializable {
    private static final long serialVersionUID = 422853731580874119L;
    @NotNull
    @Column(name = "nawyk_id", nullable = false)
    private Integer nawykId;

    @NotNull
    @Column(name = "grupa_id", nullable = false)
    private Integer grupaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NawykGrupaId entity = (NawykGrupaId) o;
        return Objects.equals(this.nawykId, entity.nawykId) &&
                Objects.equals(this.grupaId, entity.grupaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nawykId, grupaId);
    }

}