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
            Egreso egreso = organizacion.realizarEgreso(articulos,null);
            Assert.assertEquals(egreso.totalEgreso(),new Double(6.8));
    }

    @Test
    public void cerrarEgreso(){
        Egreso egreso = organizacion.realizarEgreso(articulos,null);
        Assert.assertEquals(egreso.getEstado(),EstadoOperacion.ABIERTA);
        egreso.cerrarOperacion();
        Assert.assertEquals(egreso.getEstado(),EstadoOperacion.CERRADA);
    }

    @Test(expected = EgresoInvalidoException.class)
    public void cerrarEgresoDosVeces(){
        Egreso egreso = organizacion.realizarEgreso(articulos,null);
        egreso.cerrarOperacion();
        egreso.cerrarOperacion();
    }

    @Test(expected = EgresoInvalidoException.class)
    public void realizarEgresoIncompleto(){
        Egreso egreso = organizacion.realizarEgreso(new ArrayList<>(),null);
    }

    @Test()
    public void modificarPrecioArticuloAbierto(){
        Egreso egreso = organizacion.realizarEgreso(articulos,null);
        articulos.get(0).setPrecio(10.0);
        Assert.assertNotEquals(egreso.totalEgreso(),new Double(6.8));
    }

    @Test()
    public void modificarPrecioArticuloCerrado(){
        Egreso egreso = organizacion.realizarEgreso(articulos,null);
        egreso.cerrarOperacion();
        articulos.get(0).setPrecio(10.0);
        Assert.assertEquals(egreso.totalEgreso(),new Double(6.8));
    }

    @Test()
    public void realizarEgresoSinRemito(){
        Egreso egreso = organizacion.realizarEgreso(articulos,null);
        Assert.assertNull(egreso.getDocumentoComercial());
    }

    @Test()
    public void realizarEgresoConRemito(){
        ItemServicio servicioPrueba = new ItemServicio("servicio1",10.0);
        List<ItemServicio> servicios = new ArrayList<>();
        servicios.add(servicioPrueba);
        Egreso egreso = organizacion.realizarEgreso(articulos,servicios);
        Assert.assertNotNull(egreso.getDocumentoComercial());
    }
}
