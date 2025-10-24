package ex.microsvc.banking.tradeinstructions.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class CanonicalTrade {

    @NotBlank String platform_id;
    @NotBlank String account_no;
    @NotBlank String security_id;
    @NotBlank String trade_type;
    @NotNull Integer amount;
    @NotNull Instant timestamp;
}
