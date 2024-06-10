package com.catalogservice.application.domain;

import java.math.BigDecimal;
import java.util.Currency;

public record Price(BigDecimal value, Currency currency) {

}
