package net.marcoreis.ecommerce.util;

import java.sql.Timestamp;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import net.marcoreis.ecommerce.entidades.IPersistente;

public class UltimaAtualizacaoListener {
    @PreUpdate
    @PrePersist
    public void setLastUpdate(IPersistente objeto) {
        objeto.setDataAtualizacao(new Timestamp(System.currentTimeMillis()));
    }
}
