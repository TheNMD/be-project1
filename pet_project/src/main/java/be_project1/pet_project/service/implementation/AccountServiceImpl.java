package be_project1.pet_project.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.service.validator.AccountServiceVal;
import be_project1.pet_project.dto.request.LoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;
import be_project1.pet_project.dto.response.AccountManageRes;

@Service("userServiceImpl")
public class AccountServiceImpl implements AccountService {

    // Init
    private final AccountServiceVal userServiceVal;

    @Autowired
    public AccountServiceImpl(@Qualifier("userServiceVal") AccountServiceVal userServiceVal) {
        this.userServiceVal = userServiceVal;
    }

    // Login
    @Override
    public Object login(LoginReq request) {
        String error = userServiceVal.loginVal(request);
        if (error != null) {
            return error;
        }
        // TODO
        return request;
    }

    // Logout
    @Override
    public Object logout(String accountID) {
        String error = userServiceVal.logoutVal(accountID);
        if (error != null) {
            return error;
        }
        // TODO
        return accountID;
    }

    // create
    @Override
    public Object create(AccountManageReq request) {
        // TODO
        return request;
    }

    // delete
    @Override
    public Object delete(String accountID) {
        // TODO
        return accountID;
    }

    // update
    @Override
    public Object update(String accountID, AccountManageReq request) {
        // TODO
        return request;
    }

    // search
    @Override
    public Object search(String sort, int page, int size, AccountManageReq request) {
        // TODO

        AccountManageRes response = new AccountManageRes();

        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }
}
