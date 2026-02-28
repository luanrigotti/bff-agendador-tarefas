package io.github.luanrigotti.bff_agendador_tarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTOResponse {

    private Long id;
    private String rua;
    private Long numero;
    private String cidade;
    private String estado;
    private String cep;
}
