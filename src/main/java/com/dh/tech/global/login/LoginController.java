package com.dh.tech.global.login;

import com.dh.tech.domain.member.Member;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/loginHome")
    public String loginPage() {
        return "login/loginHome";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "login/join";
    }

    @GetMapping("/dashboard")
    public String dashBoard(@AuthenticationPrincipal Member member, Model model) {
        model.addAttribute("loginId", member.getLoginId());
        model.addAttribute("memberRoles", member.getMemberRoles());
        return "login/dashboard";
    }

}
