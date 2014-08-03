package net.marcoreis.ecommerce.controlador.conversor;

import javax.faces.convert.FacesConverter;

import net.marcoreis.ecommerce.entidades.Usuario;

@FacesConverter(forClass = Usuario.class)
public class ConversorUsuario extends GenericConverter {

    public Class<?> getClasse() {
        return Usuario.class;
    }

}
