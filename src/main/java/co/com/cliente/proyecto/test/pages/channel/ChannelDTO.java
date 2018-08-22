package co.com.cliente.proyecto.test.pages.channel;

import org.openqa.selenium.support.FindBy;

public class ChannelDTO {

    private String cuenta;
    private String tipocanal;
    private String direccion;
    private String estado;
    private String row;

    public ChannelDTO(String cuenta, String tipocanal, String direccion, String estado, String row) {
        this.cuenta = cuenta;
        this.tipocanal = tipocanal;
        this.direccion = direccion;
        this.estado = estado;
        this.row = row;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public ChannelDTO() {

    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipocanal() {
        return tipocanal;
    }

    public void setTipocanal(String tipocanal) {
        this.tipocanal = tipocanal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
