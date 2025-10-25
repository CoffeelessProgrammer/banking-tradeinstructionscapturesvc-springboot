package ex.microsvc.banking.tradeinstructions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class TradeDetails {

    private String account_no;
    private String security;
    private Character type;         // trade_type, i.e. (B)uy, (S)ell
    private Integer amount;
    private String timestamp;

}
