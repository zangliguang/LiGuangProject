package com.zang.liguang.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zang.liguang.po.Attachment;
import com.zang.liguang.po.AttachmentDAO;
import com.zang.liguang.po.BaseHibernateDAO;
import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.BussinessDAO;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.BussinessclassDAO;
import com.zang.liguang.po.User;
import com.zang.liguang.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	AttachmentDAO ad;
	@SuppressWarnings("rawtypes")
	@Autowired
	BaseHibernateDAO basedao;

	@Override
	public void save(Attachment att) {
		basedao.save(att);
	}

	@Override
	public void updateAttachmentBelongid(String belongid, String uid) {
		String hql = "update  Attachment att set att.belongid=:belongid  where att.uid=:uid and att.belongid is NULL";
		HashMap<String, Object> params = new HashMap<>();
		params.put("belongid", belongid);
		params.put("uid", uid);
		basedao.update(hql, params);
	}

	@Override
	public void removeByNameAndSize(String filename, Long filesize) {
		String hql = "select att from Attachment att  where att.filename=:filename and att.filesize=:filesize and att.belongid is NULL";
		HashMap<String, Object> params = new HashMap<>();
		params.put("filename", filename);
		params.put("filesize", filesize);
		@SuppressWarnings("unchecked")
		List<Attachment> list = (List<Attachment>) basedao.createHQLQuery(hql, params);
		if (list.size() > 0) {
			Attachment att = list.get(0);
			att.setBelongid("remove");
			basedao.saveOrUpdate(att);
		}

	}

	@Override
	public List<Attachment> getAlldeleteOrRemoveFile() {
		List<Attachment> list = basedao.findByProperty(Attachment.class, "belongid", "delete");
		list.addAll(basedao.findByProperty(Attachment.class, "belongid", "remove"));
		return list;
	}

	@Override
	public void deleteAlldeleteOrRemoveFile() {
		String hql = "delete  Attachment att  where  att.belongid=:belongid ";
		HashMap<String, Object> params = new HashMap<>();
		params.put("belongid", "remove");
		basedao.update(hql, params);
		params.put("belongid", "delete");
		basedao.update(hql, params);
		
	}

}
