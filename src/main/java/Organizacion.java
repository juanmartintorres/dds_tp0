import excepciones.EgresoInvalidoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Organizacion {
    private String nombre;

    public Organizacion(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Egreso realizarEgreso(List<Articulo> articulos, List<ItemServicio> itemServicio) throws EgresoInvalidoException{
        if(articulos == null || articulos.isEmpty()){
            throw new EgresoInvalidoException();
        }
        return new Egreso(articulos,itemServicio,this);
    }
}
