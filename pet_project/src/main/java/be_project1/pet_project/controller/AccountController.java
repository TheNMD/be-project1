package be_project1.pet_project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountCreateReq;
import be_project1.pet_project.dto.request.AccountReadReq;
import be_project1.pet_project.dto.request.AccountUpdateReq;

@RestController("accountController")
@RequestMapping("/api/v1")
public class AccountController {
    // Init
    private final AccountService accountService;

    @Autowired
    public AccountController(@Qualifier("accountServiceImpl") AccountService accountService) {
        this.accountService = accountService;
    }

    // Test
    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }

    // Login
    @PostMapping(URLConst.LOGIN)
    public Object login(@RequestBody AccountLoginReq request) {
        return accountService.login(request);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT)
    public Object logout(@PathVariable("user_id") String accountID) {
        return accountService.logout(accountID);
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT)
    public Object createAccount(@RequestBody AccountCreateReq request) {
        return accountService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT)
    public Object readAccount(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody AccountReadReq request) {
        return accountService.read(sort, page, size, request);
    }

     // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT)
    public Object updateAccount(@PathVariable("user_id") String accountID,
                                @RequestBody AccountUpdateReq request) {
        return accountService.update(accountID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT)
    public Object deleteAccount(@PathVariable("user_id") String accountID) {
        return accountService.delete(accountID);
    }
}
