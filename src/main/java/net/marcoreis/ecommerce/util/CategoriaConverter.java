package net.marcoreis.ecommerce.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import net.marcoreis.ecommerce.entidades.Categoria;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        Long id = Long.parseLong(value);
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Categoria categoria = em.find(Categoria.class, id);
        em.close();
        return categoria;
    }

    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        Categoria categoria = (Categoria) value;
        return String.valueOf(categoria.getId());
    }

}
