package net.marcoreis.ecommerce.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

public interface IPersistente extends Serializable {
    Long getId();

    void setId(Long id);

    Timestamp getDataAtualizacao();

    void setDataAtualizacao(Timestamp dataAtualizacao);
}
