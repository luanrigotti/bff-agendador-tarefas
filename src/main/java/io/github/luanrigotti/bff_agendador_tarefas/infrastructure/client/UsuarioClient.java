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

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO loginRequestDTO);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required=false) String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadosUsuario(@RequestBody UsuarioDTORequest usuarioDTO,
                                            @RequestHeader(value = "Authorization", required=false) String token );

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token );

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest enderecoDTO,
                                         @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest telefoneDTO,
                                         @RequestHeader(value = "Authorization", required=false) String token );
}
