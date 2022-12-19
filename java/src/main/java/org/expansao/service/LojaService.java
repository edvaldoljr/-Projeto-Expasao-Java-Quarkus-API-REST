package org.expansao.service;


import org.expansao.dto.LojaDto;
import org.expansao.model.Loja;
import org.expansao.repository.LojaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LojaService {

    @Inject
    private LojaRepository lojaRepository;

    public List<LojaDto> buscaLojas() throws Exception {

        List<Loja> lojas = lojaRepository.findAll().list();

        if(lojas.isEmpty()){
            throw new Exception();
        }

        return mapLojaDto(lojas);
    }

    public void adicionaLoja(LojaDto loja){

        Loja lojaEntity = new Loja();

        lojaEntity.setNome(loja.getNome());
        lojaEntity.setEndereco(loja.getEndereco());
        lojaEntity.setTelefone(loja.getTelefone());

        lojaRepository.persist(lojaEntity);
    }


    private List<LojaDto> mapLojaDto(List<Loja> lojas) {

        List<LojaDto> lojaDtos = new ArrayList<>();

        lojas.forEach(item->{
            LojaDto dto = new LojaDto(item.getNome(), item.getEndereco(), item.getTelefone());
            lojaDtos.add(dto);
        });

       return lojaDtos;
    }

}
