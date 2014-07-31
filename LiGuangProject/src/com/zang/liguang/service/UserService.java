package com.zang.liguang.service;

import java.util.List;

import com.zang.liguang.po.User;

public interface UserService {

	public boolean loginByNameAndPwd(String loginname,String pwd);

	public User login(User user);

	public void addNewUser(User user);

	public List<User> listAll();

	public void saveOrupdate(User user);

	public void deleteUser(User user);

}
