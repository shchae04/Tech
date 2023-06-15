package com.dh.tech.global.view;

import com.dh.tech.global.config.auth.AdminAuth;
import com.dh.tech.global.config.auth.DevAuth;
import com.dh.tech.global.config.auth.UserAuth;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "login/join";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        System.out.println(user.getUsername());
        System.out.println(user.getAuthorities());
        return "view/dashboard";
    }

    @GetMapping("/setting/admin")
    @PreAuthorize("hasAnyRole('DEV','ADMIN')")
//    @AdminAuth
    public String adminSettingPage() {
        return "view/admin_setting";
    }

    @GetMapping("/setting/user")
    @PreAuthorize("hasAnyRole('DEV','USER')")
//    @UserAuth
    public String userSettingPage() {
        return "view/user_setting";
    }

}
