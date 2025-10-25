package ex.microsvc.banking.tradeinstructions.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class CanonicalTrade {

    @NotBlank private String account_no;
    @NotBlank private String platform_id;
    @NotBlank private String security_id;
    @NotBlank private String trade_type;
    @NotBlank private String order_type;
    @NotNull private Integer quantity;
    @NotNull private Instant expiration;
}
