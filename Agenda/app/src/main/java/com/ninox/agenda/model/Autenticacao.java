package com.ninox.agenda.model;

public class Autenticacao {

    private String user;
    private String pass;

    //@Header("token") String token

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
