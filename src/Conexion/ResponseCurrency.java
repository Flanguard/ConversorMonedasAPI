package Conexion;

import java.util.Map;

public record  ResponseCurrency(
        Map<String, Double> conversion_rates
) {}
