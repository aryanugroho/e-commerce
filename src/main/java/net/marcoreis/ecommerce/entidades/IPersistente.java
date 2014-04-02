package net.marcoreis.ecommerce.entidades;

import java.io.Serializable;

public interface IPersistente extends Serializable {
    Long getId();

    void setId(Long id);
}
