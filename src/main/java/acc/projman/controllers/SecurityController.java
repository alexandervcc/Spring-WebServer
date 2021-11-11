package acc.projman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import acc.projman.entity.UserAccount;
import acc.projman.services.UserAccountService;

@Controller
public class SecurityController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	@Autowired
	private UserAccountService userService;
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		UserAccount userAccount= new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/sign-up";
	}
	
	@PostMapping("/register/save")
	public String postSignUp(Model model, UserAccount userAccount) {
		//Encrypt password, before it is encoded	
		userAccount.setPassword(bCryptEncoder.encode(userAccount.getPassword()));
		userService.save(userAccount);
		return "redirect:/";
	}
}
