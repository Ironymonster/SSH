package com.ssh.demo.staff.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.demo.staff.entity.Asset;
import com.ssh.demo.staff.service.IAssetService;
import com.ssh.demo.util.web.ExtjsAjaxResult;
import com.ssh.demo.util.web.ExtjsPageable;

@Controller
@RequestMapping("/asset")
public class AssetController {
	@Autowired
	private IAssetService assetService;

	@RequestMapping("/findAll")
	public @ResponseBody List<Asset> findAll()
	{
		return assetService.findAll();
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Asset> findAll(ExtjsPageable pageable)
	{
		return assetService.findAll(pageable.getPageable());
	}
	
	@PostMapping("/saveOrUpdate")
	public @ResponseBody ExtjsAjaxResult saveOrUpdate(Asset asset)
	{
		try {
			assetService.save(asset);
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
			assetService.delete(ids);
			 return new ExtjsAjaxResult(true,"操作成功！");
		} catch (Exception e) {
			 e.printStackTrace();
			 return new ExtjsAjaxResult(false,"操作失败！");
		}
	}
}
