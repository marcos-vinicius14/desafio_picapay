package br.marcos.infraescruture.controllers;

import br.com.marcos.usecase.TransferCase;
import br.com.marcos.usecase.UserConsultBalanceCase;
import br.marcos.infraescruture.dto.request.TransferRequest;
import br.marcos.infraescruture.dto.response.BaseResponse;
import br.marcos.infraescruture.dto.response.ConsultBalanceResponse;
import org.springframework.web.bind.annotation.*;

import static br.marcos.infraescruture.utils.Utilities.log;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private final UserConsultBalanceCase consultBalanceCase;
    private final TransferCase transferCase;

    public WalletController(UserConsultBalanceCase consultBalanceCase, TransferCase transferCase) {
        this.consultBalanceCase = consultBalanceCase;
        this.transferCase = transferCase;
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

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transfer) {
        transferCase.transfer(transfer.fromTaxNumber(), transfer.toTaxNumber(), transfer.value(), transfer.pin());
    }
}
