import excepciones.EgresoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Egreso {
    private List<Articulo> articulos;
    private List<ItemServicio> itemServicio;
    private DocumentoComercial documentoComercial;
    private Organizacion organizacion;
    private EstadoOperacion estado;

    public Double totalEgreso(){
        if(articulos == null || articulos.isEmpty()){
            return 0.0;
        }
        return articulos.stream().
                mapToDouble(articulo -> articulo.getPrecio()).
                sum();
    }

    public void cerrarOperacion(){
        if(this.estado == EstadoOperacion.CERRADA){
            throw new EgresoInvalidoException();
        }
        this.estado= EstadoOperacion.CERRADA;
        List<Articulo> articulosCopia = new ArrayList<>();
        this.articulos.stream().forEach(articulo-> articulosCopia.add(new Articulo(articulo.getNombre(),articulo.getPrecio())));
        this.articulos = articulosCopia;
    }

    public Egreso(List<Articulo> articulos, List<ItemServicio> itemServicio, Organizacion organizacion) {
        this.articulos = articulos;
        this.organizacion = organizacion;
        this.itemServicio = itemServicio;
        this.estado = EstadoOperacion.ABIERTA;
        if(itemServicio != null && !itemServicio.isEmpty()){
            this.documentoComercial = new DocumentoComercial("remito.doc");
        }
    }

    public EstadoOperacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperacion estado) {
        this.estado = estado;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public DocumentoComercial getDocumentoComercial() {
        return documentoComercial;
    }

    public void setDocumentoComercial(DocumentoComercial documentoComercial) {
        this.documentoComercial = documentoComercial;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public List<ItemServicio> getItemServicio() {
        return itemServicio;
    }

    public void setItemServicio(List<ItemServicio> itemServicio) {
        this.itemServicio = itemServicio;
    }
}
