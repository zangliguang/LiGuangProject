package com.zang.liguang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zang.liguang.po.BaseHibernateDAO;
import com.zang.liguang.po.Poetry;
import com.zang.liguang.po.PoetryDAO;
import com.zang.liguang.po.Poetryclass;
import com.zang.liguang.po.UserDAO;
import com.zang.liguang.service.PoetryService;
@Service
public class PoetryServiceImpl implements PoetryService {

	@Autowired
	PoetryDAO pd;
	@Autowired
	BaseHibernateDAO basedao;
	@Override
	public void saveOrupdate(Poetry poetry) {
		basedao.saveOrUpdate(poetry);	

	}
	@Override
	public List<Poetry> listAllPoetry() {
		return basedao.executebysql("select s from Poetry s ORDER BY s.creationdate ");
	}
	@Override
	public List<Poetryclass> listAllPoetryClass() {
		return basedao.executebysql("select s from Poetryclass s ");
		}
	@Override
	public boolean getPoetry(Poetry poetry) {
		
		return pd.findByExample(poetry).size()>0;
	}
	@Override
	public List<Poetry> getPoetryByContent(String poetry) {
		return basedao.findByProperty(Poetry.class,"poetry",poetry);
	}
	@Override
	public List<Poetry> listAllPoetryByPage(int pageNum, int pageSize) {
		return basedao.findByPage("from Poetry p order by p.creationdate asc",(pageNum-1)*pageSize,pageNum*pageSize-1);
	}
	@Override
	public Poetry getPoetryById(String poetryId) {
		return (Poetry) basedao.findById(Poetry.class, poetryId);
	}

}
