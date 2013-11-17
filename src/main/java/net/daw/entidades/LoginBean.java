package net.daw.entidades;

/**
 * POJO LoginBean para guardar los datos de logueo del usuario 
 * (modelo a nivel de sesión)
 * @author rafael aznar
 */
public class LoginBean {

    private String strUser;
    private String strPass;

    static final String strLogin = "rafa";
    static final String strPassword = "rafa";

    /**
     * Este método responde se el usuario introducido con login y password
     * está autenticado o no
     * @return true si está autenticado y false si no
     */
    public boolean autenticado() {
        if (strLogin.equals(strUser)) {
            if (strPassword.equals(strPass)) {
                return true;
            }
        }
        return false;
    }

    public String getUser() {
        return strUser;
    }

    public void setUser(String user) {
        this.strUser = user;
    }

    public String getPass() {
        return strPass;
    }

    public void setPass(String pass) {
        this.strPass = pass;
    }
}
