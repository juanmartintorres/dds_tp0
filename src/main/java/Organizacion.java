import excepciones.EgresoInvalidoException;

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

    public Egreso realizarEgreso(List<Articulo> articulos, DocumentoComercial documentoComercial) throws EgresoInvalidoException{
        if(articulos == null || articulos.isEmpty()){
            throw new EgresoInvalidoException();
        }
        Egreso egreso = new Egreso(articulos,documentoComercial,this);
        return egreso;
    }
}
