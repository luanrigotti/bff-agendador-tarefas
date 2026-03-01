package io.github.luanrigotti.bff_agendador_tarefas.infrastructure.client;

import io.github.luanrigotti.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    Void enviarEmail(@RequestBody TarefasDTOResponse dto);
}
