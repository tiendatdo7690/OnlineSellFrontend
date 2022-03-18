package com.example.demo.services;

import com.example.demo.apis.APIConfiguration;
import com.example.demo.apis.AccountAPI;
import com.example.demo.apis.RoleAPI;
import com.example.demo.entities.Role;
import com.example.demo.entities.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImplement implements AccountService{


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AccountAPI accountAPI = APIConfiguration.getClient().create(AccountAPI.class);
        RoleAPI roleAPI = APIConfiguration.getClient().create(RoleAPI.class);

        Response<UserAccount> responseAccountAPI = null;
        Response<List<Role>> roleResponse = null;
        try {
            responseAccountAPI = accountAPI.findByUsername(username).execute();
            roleResponse = roleAPI.findRoleByUsername(username).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserAccount userAccount = responseAccountAPI.body();
        List<Role> roles = roleResponse.body();

//        System.out.println("User Name:" + userAccount.getUserName());
//        System.out.println("Pass:" + userAccount.getPassWord());
        if (userAccount == null){
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(userAccount.getUserName(),userAccount.getPassWord(),grantedAuthorities);
    }
}
