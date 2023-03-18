package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;

public interface UsuarioServicio {

    int registarUsuario(UsuarioDTO usuarioDTO);

    int actualizarUsuario(int cedula, UsuarioDTO usuarioDTO );

    UsuarioDTO obtenerUsuarioCodigo(int cedula);


}
