package io.github.luanrigotti.bff_agendador_tarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTORequest {

    private String rua;
    private Long numero;
    private String cidade;
    private String estado;
    private String cep;
}
