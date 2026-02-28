package io.github.luanrigotti.bff_agendador_tarefas.business.dto.in;

import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTORequest {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTOResponse> enderecos;
    private List<TelefoneDTOResponse> telefones;

}
