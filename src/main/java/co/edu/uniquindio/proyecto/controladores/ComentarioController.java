package co.edu.uniquindio.proyecto.controladores;


import co.edu.uniquindio.proyecto.dto.ActualizarComentarioDTO;
import co.edu.uniquindio.proyecto.dto.ComentarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.seguridad.modelo.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.implementacion.ComentarioSericioImpl;
import co.edu.uniquindio.proyecto.servicios.implementacion.UsuarioServicioImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comentario")
@SecurityRequirement(name = "bearerAuth")
@AllArgsConstructor
public class ComentarioController {


    @Autowired
    private ComentarioSericioImpl comentarioSericio;

    @Autowired
    private ComentarioRepo comentarioRepo;

    @PostMapping("/crear")
    public ResponseEntity<?> crearComentario(@RequestBody ComentarioDTO comentarioDTO){
        try {
            comentarioSericio.crearComentario(comentarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "Se creo correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/comentarios-producto/{codigo}")
    public ResponseEntity<?> listarComentariosProducto(@PathVariable(name = "codigo") int codigo){
        try {
            return ResponseEntity.status(200).body(comentarioSericio.listarComentariosProducto(codigo));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarComentario(ActualizarComentarioDTO actualizarComentarioDTO){
        try {
            comentarioSericio.actualizarComentario(actualizarComentarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "Se actualizo correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<?> eliminarComentario(@PathVariable(name = "codigo") int codigo){
        try {
            comentarioSericio.eliminarComentario(codigo);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO<>(HttpStatus.CREATED,
                    false, "Se elimino correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
