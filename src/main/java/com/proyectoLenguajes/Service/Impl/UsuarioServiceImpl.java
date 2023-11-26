
package com.proyectoLenguajes.Service.Impl;

import com.proyectoLenguajes.Service.UsuarioService;
import com.proyectoLenguajes.dao.RolDao;
import com.proyectoLenguajes.dao.UsuarioDao;
import com.proyectoLenguajes.domain.Rol;
import com.proyectoLenguajes.domain.Usuario;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private RolDao rolDao;
    
    @Autowired
    public UsuarioServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;        
    }
    
    @Override
    public void insertarUsuario(String username, String contrasena, String correo, String telefono, int estado) {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String contrasenaCifrada = passwordEncoder.encode(contrasena);

            int filasAfectadas = jdbcTemplate.update("CALL insertar_usuarios(?, ?, ?, ?, ?)", username, contrasenaCifrada, correo, telefono, estado);
            System.out.println("Filas afectadas: " + filasAfectadas);

            Long idUsuario = jdbcTemplate.queryForObject("SELECT id_usuario FROM usuarios WHERE username = ?", Long.class, username);

            insertarRol("user", idUsuario);

        } catch (Exception e) {
            System.err.println("Error al insertar los datos en la tabla de usuarios");
            e.printStackTrace();
        }
    }

    

    @Override
    public void insertarRol(String nombreRol, Long idUsuario) {
        try{

            jdbcTemplate.update("CALL insertar_roles(?, ?)", nombreRol, idUsuario);
            System.out.println("Datos agregados correctamente en la tabla de rol");
        }catch (Exception e) {
            System.err.println("Error al insertar los datos en la tabla de rol");
            e.printStackTrace();
        }    
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarios = usuarioDao.findByUsername(username);

        if (usuarios == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usuarios.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombreRol()));
        }

        if (roles.isEmpty()) {
            throw new InsufficientAuthenticationException("Usuario no tiene roles asignados: " + username);
        }

        return new User(usuarios.getUsername(), usuarios.getContrasena(), roles);
    }

}
