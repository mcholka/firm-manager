package com.firm.manager;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

    public ExternalContext externalContext() {
        return facesContext().getExternalContext();
    }

    public FacesContext facesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void putErrorMessage(String localizedMessage) {
        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, localizedMessage, localizedMessage));
    }

    public void putWarnMessage(String localizedMessage) {
        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, localizedMessage, localizedMessage));
    }

    public void putInfoMessage(String localizedMessage) {
        facesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, localizedMessage, localizedMessage));
    }
}
