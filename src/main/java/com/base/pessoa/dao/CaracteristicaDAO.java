package com.base.pessoa.dao;

import com.base.pessoa.entity.Caracteristica;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Singleton
public class CaracteristicaDAO implements CaracteristicaDAOInterface{

    @Inject
    private Provider<EntityManager> entityManagerP;

    @Transactional
    @Override
    public void gravarCaracteristica(Caracteristica caracteristica) {
        entityManagerP.get()
                .persist(caracteristica);
    }

    @Transactional
    @Override
    public List<Caracteristica> retornarCaracteristicas() {
        return entityManagerP.get()
                .createQuery("SELECT c FROM Caracteristica c",Caracteristica.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Caracteristica buscarCaracteristica(Long id) {
        return entityManagerP.get()
                .createQuery("SELECT c FROM Caracteristica c "
                        + "WHERE p.id = :id",Caracteristica.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public List<Caracteristica> buscarCaracteristica(Caracteristica caracteristica) {
        return entityManagerP.get()
                .createQuery("SELECT c FROM Caracteristica c "
                        + "WHERE c.descricao LIKE :descricao",Caracteristica.class)
                .setParameter("descricao", "%"+ caracteristica.getDescricao()+"%")
                .getResultList();
    }

    @Transactional
    @Override
    public void excluirCaracteristica(Long id) {
        entityManagerP.get()
                .createQuery("DELETE FROM Caracteristica c "
                        + "WHERE c.id = :id",Caracteristica.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void alterarCaracteristica(Caracteristica caracteristica) {
        entityManagerP.get()
                .merge(caracteristica);
    }

}
