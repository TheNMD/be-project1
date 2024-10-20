package be_project1.pet_project.service.implementation;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.dto.request.AccountLoginReq;
import be_project1.pet_project.dto.request.AccountCreateReq;
import be_project1.pet_project.dto.request.AccountReadReq;
import be_project1.pet_project.dto.request.AccountUpdateReq;
import be_project1.pet_project.dto.response.AccountRes;

@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {
    // Login
    @Override
    public Object login(AccountLoginReq request) {
        return request;
    }

    // Logout
    @Override
    public Object logout(String accountID) {

        return accountID;
    }

    // Create
    @Override
    public Object create(AccountCreateReq request) {
        request.setStatus("active");
        Instant currentTimestamp = Instant.now();
        String createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setCreatedDate(createdDate);

        return request;
    }

    // Read
    @Override
    public Object read(String sort, int page, int size, AccountReadReq request) {

        AccountRes response = new AccountRes();
        response.setUsername(request.getUsername());
        response.setName(request.getName());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Update
    @Override
    public Object update(String accountID, AccountUpdateReq request) {
        Instant currentTimestamp = Instant.now();
        String updatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(currentTimestamp);
        request.setUpdatedDate(updatedDate);

        return request;
    }

    // Delete
    @Override
    public Object delete(String accountID) {
        return accountID;
    }
}
