package org.expansao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@Jacksonized
public class LojaDto {

    private String nome;

    private String endereco;

    private String telefone;

}
