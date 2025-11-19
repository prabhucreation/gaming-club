package com.prabu.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabu.project2.Dto.DoRechargeDto;
import com.prabu.project2.entities.Recharge;
import com.prabu.project2.services.RechargeService;

@RestController
@RequestMapping("/recharges")

public class RechargeController {
	@Autowired
	private RechargeService rechargeService;
	
	@PostMapping()
	public Recharge doRecharge(@RequestBody DoRechargeDto recharge) {
		return rechargeService.doRecharge(recharge);	
	}
}
