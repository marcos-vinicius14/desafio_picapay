package br.marcos.infraescruture.controllers;

import br.com.marcos.usecase.UserConsultBalanceCase;
import br.marcos.infraescruture.dto.response.BaseResponse;
import br.marcos.infraescruture.dto.response.ConsultBalanceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static br.marcos.infraescruture.utils.Utilities.log;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private final UserConsultBalanceCase consultBalanceCase;

    public WalletController(UserConsultBalanceCase consultBalanceCase) {
        this.consultBalanceCase = consultBalanceCase;
    }

    @GetMapping("/consult/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBalance(
            @PathVariable String taxNumber
    ) {
        try {
            log.info("Consulting balance for tax number {} :: {}", taxNumber, WalletController.class.getSimpleName());
            BigDecimal balance = consultBalanceCase.consultBalance(taxNumber);
            log.info("Consulting sucessful for tax number {} :: {}", taxNumber, WalletController.class.getSimpleName());
            return BaseResponse.<ConsultBalanceResponse>builder()
                    .success(true)
                    .result(new ConsultBalanceResponse(balance)).build();

        } catch (Exception e) {
            log.error("Error while consult balance for tax number {} :: {}", taxNumber, e.getMessage());
            return BaseResponse.<ConsultBalanceResponse>builder().result(new ConsultBalanceResponse(BigDecimal.ZERO)).build();
        }
    }
}
