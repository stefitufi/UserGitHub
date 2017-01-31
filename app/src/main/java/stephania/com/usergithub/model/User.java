package stephania.com.usergithub.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representacion de la clase Usario
 *
 * @author <a href="stefiluna@gmail.com">Stephania Moreno</a>
 */
public class User {

    /**
     * Entero que contiene total de registros
     */
    private int total_count;

    /**
     * Boolean que contiene la validacion
     */
    private boolean incomplete_results;

    /**
     * Variable de tipo List {@link Items}
     */
    private List<Items> items = new ArrayList<>();

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
