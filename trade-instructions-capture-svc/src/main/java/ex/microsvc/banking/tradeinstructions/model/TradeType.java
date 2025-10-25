package ex.microsvc.banking.tradeinstructions.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum TradeType {
    BUY('B', "buy"),
    SELL('S', "sell");

    @Getter private final String op;
    @Getter private final Character code;

    TradeType(Character code, String op) {
        this.op = op;
        this.code = code;
    }

    //#region map operation to code

    public static final Map<String, TradeType> TRADE_TYPE_OP_MAP = new HashMap<>(values().length);

    static {
        for(TradeType type : values()) {
            TRADE_TYPE_OP_MAP.put(type.getOp(), type);
        }
    }

    @Override
    public String toString() {
        return code.toString();
    }

    public static Character getCodeFromOp(String op) {
        return TRADE_TYPE_OP_MAP.get(op.toLowerCase()).getCode();
    }
}
