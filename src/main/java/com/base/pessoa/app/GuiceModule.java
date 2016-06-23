package com.base.pessoa.app;

import com.base.pessoa.dao.CaracteristicaDAO;
import com.base.pessoa.dao.CaracteristicaDAOInterface;
import com.base.pessoa.dao.PessoaDAO;
import com.base.pessoa.dao.PessoaDAOInterface;
import com.base.pessoa.service.CaracteristicaService;
import com.base.pessoa.service.PessoaService;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;


@Singleton
public class GuiceModule implements Module {
	    @Override
	    public void configure(Binder binder) {
	        binder.bind(PessoaService.class);
	        binder.bind(CaracteristicaService.class);
	        binder.bind(CaracteristicaDAOInterface.class).to(CaracteristicaDAO.class);
	        binder.bind(PessoaDAOInterface.class).to(PessoaDAO.class);
	    }
}
