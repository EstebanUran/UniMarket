package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.Categoria;
import co.edu.uniquindio.proyecto.modelo.Estado;
import co.edu.uniquindio.proyecto.modelo.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductoServicio {

    int crearProducto(ProductoDTO productoDTO) throws Exception;

    void eliminarProducto(int codigoProducto) throws Exception;

    ProductoGetDTO actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception;

    void actualizarProductoEstado(int codigoProducto, boolean estado) throws Exception;

    int actualizarProductoCantidad(int codigoProducto, int unidades);

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;

    Producto obtener(int codigoProducto) throws Exception;
    List<ProductoGetDTO> listarProductoCategoria(Categoria categoria);

    List<ProductoGetDTO>  listarProductosUsuario(String cedulaUsuario) throws Exception;

    List<ProductoGetDTO> listarProductosEstadoModerador(Estado estado);

    List<ProductoGetDTO>  listarProductosNombre(String nombre) throws Exception;

    List<ProductoGetDTO>  listarProductosPrecio(float precioMin, float precioMax) throws Exception;

    List<ProductoGetDTO> listarProductosFavoritos();

    void crearFavorito(int codigoUsuario, int codigoProducto) throws Exception;

    void eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception;


    int actualizarUnidades(Producto producto, int unidades) throws Exception;
}
