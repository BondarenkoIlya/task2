package com.epam.ilya.entities;

import org.springframework.http.HttpRequest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = -410831618475608617L;

    private String username;
    private String password;

    public String login() throws ServletException, IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext extenalContext = facesContext.getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest)extenalContext.getRequest()).getRequestDispatcher("/login");
        dispatcher.forward((ServletRequest)extenalContext.getRequest(), (ServletResponse)extenalContext.getResponse());
        facesContext.responseComplete();
        return null;
    }

    private String[] getStringArray(String string) {
        String[] strings = new String[1];
        strings[0] = string;
        return strings;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
