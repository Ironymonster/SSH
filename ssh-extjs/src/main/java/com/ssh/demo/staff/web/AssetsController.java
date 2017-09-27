package com.ssh.demo.staff.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.demo.staff.entity.Assets;
import com.ssh.demo.staff.service.IAssetsService;
import com.ssh.demo.util.web.ExtjsAjaxResult;
import com.ssh.demo.util.web.ExtjsPageable;

@Controller
@RequestMapping("/assets")
public class AssetsController {
	@Autowired
	private IAssetsService assetsService;

	@RequestMapping("/findAll")
	public @ResponseBody List<Assets> findAll()
	{
		return assetsService.findAll();
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Assets> findAll(ExtjsPageable pageable)
	{
		return assetsService.findAll(pageable.getPageable());
	}
	
	@PostMapping("/saveOrUpdate")
	public @ResponseBody ExtjsAjaxResult saveOrUpdate(Assets assets)
	{
		try {
			assetsService.save(assets);
			 return new ExtjsAjaxResult(true,"操作成功！");
		} catch (Exception e) {
			 e.printStackTrace();
			 return new ExtjsAjaxResult(false,"操作失败！");
		}
	}
	
	@PostMapping("/delete")
	public @ResponseBody ExtjsAjaxResult delete(Long[] ids)
	{
		try {
			assetsService.delete(ids);
			 return new ExtjsAjaxResult(true,"操作成功！");
		} catch (Exception e) {
			 e.printStackTrace();
			 return new ExtjsAjaxResult(false,"操作失败！");
		}
	}
}
