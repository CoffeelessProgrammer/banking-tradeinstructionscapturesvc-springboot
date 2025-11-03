package ex.microsvc.banking.tradeinstructions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ex.microsvc.banking.tradeinstructions.model.CanonicalTrade;
import ex.microsvc.banking.tradeinstructions.service.TradeSvc;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trade")
public class TradeController {

    private final TradeSvc tradeService;

    private final Validator validator;
    private final ObjectMapper objectMapper;

    public TradeController(Validator validator, TradeSvc tradeService) {
        this.tradeService = tradeService;

        this.validator = validator;
        this.objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();  // Enable date/time support (for timestamp field)
    }

    @GetMapping
    public ResponseEntity<String> tradeFormat() {
        return ResponseEntity.ok("Use the following format...");
    }

    @PostMapping("/json")
    public ResponseEntity<?> uploadJson(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty file... GET /api/trade for valid request format");
        }

        try {
            CanonicalTrade trade = objectMapper.readValue(file.getInputStream(), CanonicalTrade.class);     // Parse json file to bean
            Set<ConstraintViolation<CanonicalTrade>> violations = validator.validate(trade);                // Validate bean

            if (!violations.isEmpty()) {
                List<String> errors = violations.stream()
                        .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }

            this.tradeService.processTrade(trade);

            return ResponseEntity.ok("Trade processed successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing JSON");
        }
    }
}
