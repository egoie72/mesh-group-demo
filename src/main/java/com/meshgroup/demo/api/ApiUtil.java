package com.meshgroup.demo.api;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@UtilityClass
public class ApiUtil {
    public static <S, D> ResponseEntity<D> getResult(final Supplier<S> supplier, final Function<S, D> converter) {
        return Optional.ofNullable(supplier.get())
                       .map(converter)
                       .map(body -> ResponseEntity.ok()
                                                  .body(body))
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public static <S, D> ResponseEntity<List<D>> getResults(final Supplier<List<S>> supplier, final Function<S, D> converter) {
        return Optional.ofNullable(supplier.get())
                       .map(l -> l.stream()
                                  .map(converter)
                                  .collect(Collectors.toList()))
                       .map(body -> ResponseEntity.ok()
                                                  .body(body))
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
