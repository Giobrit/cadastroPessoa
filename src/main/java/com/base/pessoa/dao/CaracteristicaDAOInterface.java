package com.base.pessoa.dao;

import java.util.List;

import com.base.pessoa.entity.Caracteristica;

public interface CaracteristicaDAOInterface{

    Caracteristica gravarCaracteristica(Caracteristica caracteristica);
    List<Caracteristica> retornarCaracteristicas();
    Caracteristica buscarCaracteristica(Long id);
    List<Caracteristica> buscarCaracteristica(Caracteristica caracteristica);
    void excluirCaracteristica(Long id);
    Caracteristica alterarCaracteristica(Caracteristica caracteristica);


}
