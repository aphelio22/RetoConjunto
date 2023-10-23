package clase;

import java.util.Date;

public class Pedido {
    private Integer id;
    private String codigo_pedido;
    private Date fecha;
    private Usuario usuario;
    private Integer total;

    public Pedido(Integer id, String codigo_pedido, Date fecha, Usuario usuario, Integer total) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.fecha = fecha;
        this.usuario = usuario;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
