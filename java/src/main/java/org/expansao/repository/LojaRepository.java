package org.expansao.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.expansao.model.Loja;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LojaRepository implements PanacheRepository<Loja> {
}
