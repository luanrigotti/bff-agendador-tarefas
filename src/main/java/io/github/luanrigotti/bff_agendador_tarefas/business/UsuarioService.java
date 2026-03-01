package io.github.luanrigotti.bff_agendador_tarefas.business;

import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import io.github.luanrigotti.bff_agendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO){
        return usuarioClient.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO loginRequestDTO){
        return  usuarioClient.login(loginRequestDTO);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token){
        usuarioClient.deletaUsuarioPorEmail(email, token);
    }


    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto){
       return usuarioClient.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long id, EnderecoDTORequest enderecoDTO, String token){
        return usuarioClient.atualizaEndereco(enderecoDTO, id, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long id, TelefoneDTORequest telefoneDTO, String token){
        return usuarioClient.atualizaTelefone(telefoneDTO, id, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
        return usuarioClient.cadastraTelefone(dto, token);
    }
}
