package ex.microsvc.banking.tradeinstructions.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class PlatformTrade {

    private String platform_id;
    private TradeDetails trade;

    public PlatformTrade(CanonicalTrade canonical) {
        platform_id = canonical.getPlatform_id();

        trade = new TradeDetails();
        trade.setAccount_no(
                String.format("*%s", canonical.getAccount_no().substring(canonical.getAccount_no().length()-4))
        );
        trade.setSecurity(canonical.getSecurity_id().toUpperCase());
        trade.setType(TradeType.getCodeFromOp(canonical.getTrade_type()));
        trade.setAmount(canonical.getQuantity());
        trade.setTimestamp(Instant.now().toString());
    }

    public static PlatformTrade fromCanonicalTrade(CanonicalTrade canonical) {
        return new PlatformTrade(canonical);
    }

}
