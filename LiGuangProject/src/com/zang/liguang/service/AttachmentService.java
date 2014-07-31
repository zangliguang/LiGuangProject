package com.zang.liguang.service;

import java.util.List;

import com.zang.liguang.po.Attachment;
import com.zang.liguang.po.Information;

public interface AttachmentService {

	void save(Attachment att);

	void updateAttachmentBelongid(String belongid, String ownerid);

	void removeByNameAndSize(String filename, Long filesize);

	List<Attachment>  getAlldeleteOrRemoveFile();

	void deleteAlldeleteOrRemoveFile();


	


}
