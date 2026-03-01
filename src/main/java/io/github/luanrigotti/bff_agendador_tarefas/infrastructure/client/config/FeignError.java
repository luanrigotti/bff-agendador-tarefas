package io.github.luanrigotti.bff_agendador_tarefas.infrastructure.client.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import io.github.luanrigotti.bff_agendador_tarefas.infrastructure.exceptions.BusinessException;
import io.github.luanrigotti.bff_agendador_tarefas.infrastructure.exceptions.ConflictException;
import io.github.luanrigotti.bff_agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import io.github.luanrigotti.bff_agendador_tarefas.infrastructure.exceptions.UnauthorizedException;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()){
            case 409:
                return new ConflictException("Erro atributo já existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");
            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
