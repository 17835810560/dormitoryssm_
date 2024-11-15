package com.dxy.service.impl;

import com.dxy.dto.AccountDto;
import com.dxy.entity.DormitoryAdmin;
import com.dxy.entity.SystemAdmin;
import com.dxy.form.AccountForm;
import com.dxy.mapper.DormitoryAdminMapper;
import com.dxy.mapper.SystemAdminMapper;
import com.dxy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private SystemAdminMapper systemAdminMapper;
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public AccountDto login(AccountForm accountForm) {
        AccountDto accountDto = new AccountDto<>();
        switch (accountForm.getType()) {
            case "systemAdmin":
                SystemAdmin systemAdmin = systemAdminMapper.findByUsername(accountForm.getUsername());
                if (systemAdmin == null) {
                    accountDto.setCode(-1);
                } else if (!accountForm.getPassword().equals(systemAdmin.getPassword())) {
                    accountDto.setCode(-2);
                } else {
                    accountDto.setCode(0);
                    accountDto.setAdmin(systemAdmin);
                }
                break;
            case "dormitoryAdmin":
                DormitoryAdmin dormitoryAdmin = dormitoryAdminMapper.findByUsername(accountForm.getUsername());
                if (dormitoryAdmin == null) {
                    accountDto.setCode(-1);
                } else if (!accountForm.getPassword().equals(dormitoryAdmin.getPassword())) {
                    accountDto.setCode(-2);
                } else {
                    accountDto.setCode(0);
                    accountDto.setAdmin(dormitoryAdmin);
                }
                break;
        }
        return accountDto;
    }
}
