package org.expansao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Jacksonized
public class ProdutoDto {

    private Long id;

    private Long idLoja;

    private String marca;

    private String modelo;

    private String descricao;

    private BigDecimal preco;

}
