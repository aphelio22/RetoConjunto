package domain;

import clase.Item;

import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<Item> loadAll (String codigoPedido);

}
