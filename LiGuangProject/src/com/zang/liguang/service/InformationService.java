package com.zang.liguang.service;

import java.util.List;

import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.Information;
import com.zang.liguang.po.User;

public interface InformationService {

	void saveOrupdate(Information information);

	List<Information> getInformationlistBybid(String bid);


}
