package com.firm.manager.validator;

import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


@FacesValidator("OwnEmailValidator")
public class EmailValidator implements Validator {
    private static final Logger logger = Logger.getLogger(EmailValidator.class);

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null) {
            return;
        }
        try {
            InternetAddress internetAddress = new InternetAddress(o.toString());
            internetAddress.validate();
            logger.info("Email: " + o + " validated");
        } catch (AddressException e) {
            logger.error(e.getMessage(), e);
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email: " + o + " jest niepoprawny!", null));
        }
    }
}
