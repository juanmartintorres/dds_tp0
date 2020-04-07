import com.sun.org.apache.xpath.internal.operations.Or;
import excepciones.EgresoInvalidoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrganizacionTest {
    private Organizacion organizacion;
    private List<Articulo> articulos;
    private DocumentoComercial documentoComercial;

    @Before
    public void init(){
        Articulo lapiz = new Articulo("lapiz",1.5);
        Articulo goma = new Articulo("goma",5.3);
        articulos = new ArrayList<>();
        articulos.add(lapiz);
        articulos.add(goma);
        organizacion = new Organizacion("Puma");
        documentoComercial = new DocumentoComercial("Documento.doc");
    }

    @Test
    public void realizarEgreso(){
            Egreso egreso = organizacion.realizarEgreso(articulos,documentoComercial);
            Assert.assertEquals(egreso.totalEgreso(),new Double(6.8));
    }

    @Test(expected = EgresoInvalidoException.class)
    public void realizarEgresoIncompleto(){
        Egreso egreso = organizacion.realizarEgreso(new ArrayList<>(),documentoComercial);
    }

}
