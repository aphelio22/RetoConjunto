package domain;

import clase.Producto;

/**
 * Interfaz que define las operaciones para acceder a objetos de tipo Producto en la base de datos.
 */
public interface ProductoDAO {

    /**
     * Recupera un producto de la base de datos en función de su identificador único.
     *
     * @param id El identificador único del producto que se desea recuperar.
     * @return El producto encontrado en la base de datos, o null si no se encuentra.
     */
    public Producto loadProduct(Integer id);
}