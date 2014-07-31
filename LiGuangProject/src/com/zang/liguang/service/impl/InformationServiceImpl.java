package com.zang.liguang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zang.liguang.po.BaseHibernateDAO;
import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.BussinessDAO;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.BussinessclassDAO;
import com.zang.liguang.po.Information;
import com.zang.liguang.po.InformationDAO;
import com.zang.liguang.service.BusinessService;
import com.zang.liguang.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	InformationDAO id;
	@SuppressWarnings("rawtypes")
	@Autowired
	BaseHibernateDAO basedao;
	
	@Override
	public void saveOrupdate(Information information) {
		basedao.saveOrUpdate(information);
	}

	@Override
	public List<Information> getInformationlistBybid(String bid) {
		return basedao.findByProperty(Information.class, "bid", bid);
	}



}
