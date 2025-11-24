package io.github.marrafon91.crud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.marrafon91.crud.entity.Client;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record ClientDTO(

        Long id,

        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 100, message = "Campo fora do tamanho padrão")
        String name,

        @NotBlank(message = "Campo obrigatório")
        @CPF(message = "CPF inválido!")
        String cpf,

        @NotNull(message = "Campo obrigatório")
        @Positive(message = "O valor deve ser positivo")
        Double income,

        @NotNull(message = "Campo obrigatório")
        @PastOrPresent(message = "Não pode ser uma data futura")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate birthDate,

        @NotNull(message = "Campo obrigatório")
        Integer children
) {
        public ClientDTO(Client client) {
                this(
                        client.getId(),
                        client.getName(),
                        client.getCpf(),
                        client.getIncome(),
                        client.getBirthDate(),
                        client.getChildren()
                );
        }
}
