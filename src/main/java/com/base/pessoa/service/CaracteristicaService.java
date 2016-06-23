package com.base.pessoa.service;

import java.util.List;

import com.base.pessoa.dao.CaracteristicaDAOInterface;
import com.base.pessoa.entity.Caracteristica;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CaracteristicaService {

	@Inject
	private CaracteristicaDAOInterface caracteristicaDAO;

	public void gravarPessoa(Caracteristica caracteristica) {
		caracteristicaDAO.gravarCaracteristica(caracteristica);
	}

	public List<Caracteristica> retornarFisicaCaracteristica() {
		return caracteristicaDAO.retornarCaracteristicas();
	}

	public Caracteristica buscarCaracteristica(Long id) {
		return caracteristicaDAO.buscarCaracteristica(id);
	}

	public void excluirCaracteristica(Long id) {
		caracteristicaDAO.excluirCaracteristica(id);
	}

	public List<Caracteristica> buscarCategoria(Caracteristica categoria) {
		return caracteristicaDAO.buscarCaracteristica(categoria);
	}
	public void alterarPessoa(Caracteristica caracteristica) {
		caracteristicaDAO.alterarCaracteristica(caracteristica);
	}

}
