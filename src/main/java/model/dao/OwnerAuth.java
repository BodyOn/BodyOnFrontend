package model.dao;

public final class OwnerAuth {
    private static OwnerAuth instance;
    private  boolean isLogged;

    private OwnerAuth() {
        this.isLogged = false;
    }

    public static OwnerAuth getInstance() {
        if (instance == null) {
            instance = new OwnerAuth();
        }
        return instance;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
