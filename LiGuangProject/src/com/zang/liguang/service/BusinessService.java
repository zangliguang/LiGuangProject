package com.zang.liguang.service;

import java.util.List;

import com.zang.liguang.po.Attachment;
import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.User;

public interface BusinessService {

	public List<Bussiness> listAllBusiness();

	public List<Bussinessclass> listAllBusinessClass();

	public void saveOrupdateBusinessClass(Bussinessclass businessclass);

	public void deletebusinessClass(Bussinessclass businessclass);

	public List<Bussiness> listBusinessByClassid(String classid);

	public void deletebusiness(Bussiness business);

	public void saveOrupdateBusiness(Bussiness business);

	public Bussiness getBusinessById(String bid);

	public List<Attachment> getBusinessPic(String bid);

	public List<Bussiness> getMyBusinessByMasterId(String uid);

}
