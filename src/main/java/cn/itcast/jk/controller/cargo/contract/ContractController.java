package cn.itcast.jk.controller.cargo.contract;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractService;

/**
 * @Description 购销合同控制类
 * @author Administrator
 * @CreateTime 2017年12月25日
 */
@Controller
public class ContractController extends BaseController{
	@Resource
	ContractService contractService;
	
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model){
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList",dataList);
		return "/cargo/contract/jContractList.jsp";
	}
	
	@RequestMapping("/cargo/contract/tocreate.action")
	public String tocreate(){
		return "/cargo/contract/jContractCreate.jsp";
	}
	
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract){
		contractService.insert(contract);
		
		return "redirect:/cargo/contract/list.action";		
	}
	
	@RequestMapping("/cargo/contract/toupdate.action")
	public String toupdate(String id,Model model){
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);
		return "/cargo/contract/jContractUpdate.jsp";
	}
	
	@RequestMapping("/cargo/contract/update.action")
	public String update(Contract contract){
		contractService.update(contract);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/delete.action")
	public String delete(String[] id){
		contractService.delete(id);

		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id,Model model){
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);

		return "/cargo/contract/jContractView.jsp";	
		
	}
	
	@RequestMapping("/cargo/contract/submit.action")
	public String submit(String[] id){
		contractService.submit(id);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/cancel.action")
	public String cancel(String[] id){
		contractService.cancel(id);
		return "redirect:/cargo/contract/list.action";
	}
}
