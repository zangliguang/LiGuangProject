package com.zang.liguang.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zang.liguang.po.BaseHibernateDAO;
import com.zang.liguang.po.User;
import com.zang.liguang.po.UserDAO;
import com.zang.liguang.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO ud;
	@SuppressWarnings("rawtypes")
	@Autowired
	BaseHibernateDAO basedao;
	@Override
	public boolean loginByNameAndPwd(String loginname, String pwd) {
		return false;
	}

	@Override
	public User login(User user) {
		String hql="select s from User s where s.loginname=:loginname and s.pwd =:pwd" ;
		if(null!=user.getPhonenum()){
			hql="select s from User s where s.phonenum='"+user.getPhonenum()+"'and s.pwd ='"+user.getPwd()+"'" ;
		}
		if(null!=user.getEmail()){
			hql="select s from User s where s.email='"+user.getEmail()+"'and s.pwd ='"+user.getPwd()+"'";
		}
		
/*		HashMap<String, Object> params=new HashMap<>();
		params.put("loginname", user.getLoginname());
		params.put("pwd", user.getPwd());
		List<User>list2=(List<User>) basedao.createHQLQuery(hql,params);*/
		List<User>list=basedao.executebysql(hql);
		return list.size() > 0?list.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addNewUser(User user) {
	//	ud.save(user);
		basedao.save(user);
	}

	@Override
	public List<User> listAll() {
		return ud.findAll();
	}

	@Override
	public void saveOrupdate(User user) {
		basedao.saveOrUpdate(user);		
	}

	@Override
	public void deleteUser(User user) {
		ud.delete(ud.findById(user.getUid()));		
	}

}
