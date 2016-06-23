package com.base.pessoa.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import com.base.pessoa.entity.Caracteristica;
import com.base.pessoa.entity.Pessoa;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class PessoaDAO implements PessoaDAOInterface{

    @Inject
    private Provider<EntityManager> entityManagerP;

    @Transactional
    @Override
    public void gravarPessoa(Pessoa pessoa) {
        Set<Caracteristica> categoriasSalvas = new HashSet<>();
        for(Caracteristica categoria : pessoa.getCaracteristicas()){
            try{
                Caracteristica categoriaSalva = (Caracteristica) entityManagerP.get()
                        .createQuery("SELECT c FROM Caracteristica c WHERE c.id = :id")
                        .setParameter("id", categoria.getId())
                        .getSingleResult();
                categoriasSalvas.add(categoriaSalva);
            }catch(Exception ex){
                entityManagerP.get().persist(categoria);
                categoriasSalvas.add(categoria);
            }
        }

        pessoa.setCaracteristicas(categoriasSalvas);
        entityManagerP.get().persist(pessoa);
    }

    @Transactional
    @Override
    public List<Pessoa> retornarPessoas() {
        return entityManagerP.get()
                .createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Pessoa buscarPessoa(Long id) {
        return entityManagerP.get()
                .createQuery("SELECT p FROM Pessoa p "
                        + "WHERE p.id = :id ",Pessoa.class)
                .setParameter("id", id)
                .getSingleResult();
    }


    @Transactional
    @Override
    public List<Pessoa> buscarPessoas(Pessoa pessoa) {
        return null; /*
        entityManagerP.get()
                .createQuery("SELECT p FROM Pessoa p "
                        + "WHERE p.documentoFederal LIKE :documentoFederal "
                        + "AND p.idPai = :idPai ",Pessoa.class)
                .setParameter("documentoFederal", "%"+pessoa.getDocumentoFederal()+"%")
                .setParameter("idPai",pessoa.getIdPai())
                .getResultList();
    */}


    @Transactional
    @Override
    public void excluirPessoa(Long id) {
        entityManagerP.get()
                .createQuery("DELETE FROM Pessoa p "
                        + "WHERE p.id = :id",Pessoa.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void alterarPessoa(Pessoa pessoa) {
        entityManagerP.get()
                .merge(pessoa);
    }

}
