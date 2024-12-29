package jns.sjk.Habitzz.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PrzynaleznoscId implements Serializable {
    @Serial
    private static final long serialVersionUID = 5244548898807426433L;

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
        PrzynaleznoscId entity = (PrzynaleznoscId) o;
        return Objects.equals(this.uzytkownikId, entity.uzytkownikId) &&
                Objects.equals(this.grupaId, entity.grupaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uzytkownikId, grupaId);
    }

}