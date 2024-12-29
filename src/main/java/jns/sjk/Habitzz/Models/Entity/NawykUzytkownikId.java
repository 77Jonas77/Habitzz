package jns.sjk.Habitzz.Models.Entity;

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
public class NawykUzytkownikId implements Serializable {
    private static final long serialVersionUID = -5232618309245772908L;
    @NotNull
    @Column(name = "uzytkownik_id", nullable = false)
    private Integer uzytkownikId;

    @NotNull
    @Column(name = "nawyk_id", nullable = false)
    private Integer nawykId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NawykUzytkownikId entity = (NawykUzytkownikId) o;
        return Objects.equals(this.uzytkownikId, entity.uzytkownikId) &&
                Objects.equals(this.nawykId, entity.nawykId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uzytkownikId, nawykId);
    }

}