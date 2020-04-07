import java.util.ArrayList;
import java.util.List;

public class Egreso {
    private List<Articulo> articulos;
    private DocumentoComercial documentoComercial;
    private Organizacion organizacion;

    public Double totalEgreso(){
        if(articulos == null || articulos.isEmpty()){
            return 0.0;
        }
        return articulos.stream().
                mapToDouble(articulo -> articulo.getPrecio()).
                sum();
    }

    public Egreso(List<Articulo> articulos, DocumentoComercial documentoComercial, Organizacion organizacion) {
        this.articulos = articulos;
        this.documentoComercial = documentoComercial;
        this.organizacion = organizacion;
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
}
