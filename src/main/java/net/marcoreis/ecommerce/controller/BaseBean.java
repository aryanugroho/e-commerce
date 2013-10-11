package net.marcoreis.ecommerce.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.marcoreis.ecommerce.entidades.Usuario;

import org.apache.log4j.Logger;

public class BaseBean implements Serializable {
    private static final long serialVersionUID = -5895396595360064610L;
    protected static final Logger logger = Logger.getLogger(BaseBean.class);
    private Usuario usuario;

    @PostConstruct
    public void init() {
	usuario = new Usuario();
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    protected void infoMsg(String message) {
	FacesMessage msg = new FacesMessage(message);
	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    protected void errorMsg(Throwable t) {
	logger.error(t);
	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
		t.getLocalizedMessage(), "Erro");
	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    protected void errorMsg(String message) {
	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
		message, "Erro");
	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
