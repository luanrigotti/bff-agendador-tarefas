package io.github.luanrigotti.bff_agendador_tarefas.infrastructure.client;

import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.LoginRequestDTO;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO loginRequestDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                         @RequestHeader("Authorization") String token);
}
