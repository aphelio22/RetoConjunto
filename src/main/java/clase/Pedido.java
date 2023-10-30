package clase;

import java.util.ArrayList;

public class Pedido {
    private Integer id;
    private String codigo_pedido;
    private String fecha;
    private Integer usuarioId;
    private Integer total;
    private ArrayList<Item> items = new ArrayList<>();

    public Pedido(Integer id, String codigo_pedido, String fecha, Integer usuarioId, Integer total, ArrayList<Item> items) {
        this.id = id;
        this.codigo_pedido = codigo_pedido;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.total = total;
        this.items = items;
    }

    public Pedido() {
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", codigo_pedido='" + codigo_pedido + '\'' +
                ", fecha='" + fecha + '\'' +
                ", usuarioId=" + usuarioId +
                ", total=" + total +
                '}';
    }
}
