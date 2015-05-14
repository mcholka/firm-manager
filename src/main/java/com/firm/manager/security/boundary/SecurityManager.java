package com.firm.manager.security.boundary;

import com.firm.manager.FacesUtil;
import com.firm.manager.security.entity.SessionUser;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.IOException;

@ManagedBean
@ViewScoped
public class SecurityManager {
    private static final Logger logger = Logger.getLogger(SecurityManager.class);
    private static final String SESSION_USER_PARAM = "user";
    private static final String HOME_PAGE = "/";

    @NotNull(message = "Login jest wymagany")
    private String username;
    @NotNull(message = "Haslo jest wymagane")
    private String password;
    private String forwardURL;

    @Inject
    private FacesUtil facesUtil;

    @PostConstruct
    public void init() {
        logger.info("Init security manager");
        ExternalContext externalContext = facesUtil.externalContext();
        String requestedUrl = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
        if (requestedUrl == null) {
            forwardURL = externalContext.getRequestContextPath() + HOME_PAGE;
        } else {
            String queryString = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_QUERY_STRING);
            forwardURL = requestedUrl + (queryString == null ? "" : "?" + queryString);
        }
        logger.info("ForwardURL: " + forwardURL);
    }

    public void login() {
        logger.info("Process login user: " + username + " with pass: " + password);
        ExternalContext externalContext = facesUtil.externalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            request.login(username, password);
            externalContext.getSessionMap().put(SESSION_USER_PARAM, new SessionUser(username));
            externalContext.redirect(forwardURL);
            logger.info("User logged in!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            facesUtil.putErrorMessage("Niepoprawny login lub/i haslo");
        }
    }

    public void logout() throws IOException {
        logger.info("Process logout");
        ExternalContext externalContext = facesUtil.externalContext();
        externalContext.invalidateSession();
        externalContext.redirect(externalContext.getRequestContextPath());
        logger.info("User logged out!");
    }

    public SessionUser getUser() {
        ExternalContext externalContext = facesUtil.externalContext();
        return (SessionUser) externalContext.getSessionMap().get(SESSION_USER_PARAM);
    }

    public boolean isUserLoggedIn() {
        return getUser() != null;
    }

    public boolean isUserInRole(String role) {
        ExternalContext externalContext = facesUtil.externalContext();
        return externalContext.isUserInRole(role);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
