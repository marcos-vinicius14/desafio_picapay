package br.marcos.infraescruture.controllers;

import br.com.marcos.usecase.CreateUserCase;
import br.marcos.infraescruture.dto.request.CreateUserRequest;
import br.marcos.infraescruture.dto.response.BaseResponse;
import br.marcos.infraescruture.mappers.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import static br.marcos.infraescruture.utils.Utilities.log;
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final CreateUserCase createUserCase;
    private final UserMapper userMapper;
    private final RestClient.Builder builder;

    public UserController(CreateUserCase createUserCase, UserMapper userMapper, RestClient.Builder builder) {
        this.createUserCase = createUserCase;
        this.userMapper = userMapper;
        this.builder = builder;
    }

    @PostMapping("/create")
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {
        log.info("Initializing creation of user::UserController");
        log.info("Dados da Requisição: " + createUserRequest.toString());
        createUserCase.create(userMapper.toUser(createUserRequest), createUserRequest.transactionPin().getPin());
        return BaseResponse.<String>builder()
                .success(true)
                .message("Usuário criado com sucesso!")
                .build();
    }
}
