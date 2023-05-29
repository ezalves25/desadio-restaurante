package br.com.desafio.msdesafio.mappers;

import br.com.desafio.msdesafio.controller.request.UserRequest;
import br.com.desafio.msdesafio.model.UserModel;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class UserRequestToUserMapper implements Converter<UserRequest, UserModel> {


    @Override
    @NonNull
    public UserModel convert(final UserRequest request) {
        try {
            return UserModel.builder()
                    .username(request.getUsername())
                    .password(request.getPassword())
                    .build();
        } catch (final Exception ex) {
            log.error("Mapper Error Bind");
            throw new RuntimeException(ex);
        }
    }
}