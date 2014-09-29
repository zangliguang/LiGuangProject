package com.zang.liguang.service;

import java.util.List;

import com.zang.liguang.po.Poetry;
import com.zang.liguang.po.Poetryclass;
import com.zang.liguang.po.User;

public interface PoetryService {

	public void saveOrupdate(Poetry poetry);

	public List<Poetry> listAllPoetry();

	public List<Poetryclass> listAllPoetryClass();

	public boolean getPoetry(Poetry poetry);

	public List<Poetry> getPoetryByContent(String poetry);

	public List<Poetry> listAllPoetryByPage(int pageNum, int pageSize);

	public Poetry getPoetryById(String poetryId);

	
}
