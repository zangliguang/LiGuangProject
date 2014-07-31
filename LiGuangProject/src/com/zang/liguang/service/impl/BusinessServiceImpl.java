package com.zang.liguang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zang.liguang.po.BaseHibernateDAO;
import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.BussinessDAO;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.BussinessclassDAO;
import com.zang.liguang.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	BussinessDAO bd;
	@Autowired
	BussinessclassDAO bcd;
	@SuppressWarnings("rawtypes")
	@Autowired
	BaseHibernateDAO basedao;


	@Override
	public List<Bussiness> listAllBusiness() {
		return basedao.executebysql("select s from Bussiness s ORDER BY s.classid  ");
	}

	@Override
	public List<Bussinessclass> listAllBusinessClass() {
		return basedao.executebysql("select s from Bussinessclass s ORDER BY s.ordernum ");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void saveOrupdateBusinessClass(Bussinessclass businessclass) {
		basedao.saveOrUpdate(businessclass);	
	}

	@Override
	public void deletebusinessClass(Bussinessclass businessclass) {
		bcd.delete(bcd.findById(businessclass.getBclassid()));		
	}

	@Override
	public List<Bussiness> listBusinessByClassid(String classid) {
		 return basedao.findByProperty(Bussiness.class, "classid", classid);
	}

	@Override
	public void deletebusiness(Bussiness business) {
		bd.delete(bd.findById(business.getBid()));		
		
	}

	@Override
	public void saveOrupdateBusiness(Bussiness business) {
		basedao.saveOrUpdate(business);	
		
	}

}
