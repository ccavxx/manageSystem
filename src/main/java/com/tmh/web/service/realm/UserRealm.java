package com.tmh.web.service.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.tmh.web.domain.User;
import com.tmh.web.service.user.UserService;
/**
 * 继承了AuthenticatingRealm  注入  private CredentialsMatcher credentialsMatcher;
 * @author zsnewlife
 *
 */
@Service
public class UserRealm extends AuthorizingRealm {

	@Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	
        User user = (User)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        
        authorizationInfo.setRoles(userService.findRoles(user.getUsername()));//查询用户的角色信息
        
        authorizationInfo.setStringPermissions(userService.findPermissions(user.getUsername()));
        
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        User user = userService.findByUsername(username);

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        
        if("2".equals(user.getStatus())) {
            throw new LockedAccountException(); //帐号锁定
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配 
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,//Object可以写入自己需要的对象 principals.getPrimaryPrincipal()就是这里取出来的对象
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()  //realm name
                /*{
                this.principals = new SimplePrincipalCollection(principal, realmName);
                this.credentials = hashedCredentials;
                this.credentialsSalt = credentialsSalt;
              }*/

        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
    	
        clearAllCachedAuthenticationInfo();
        
        clearAllCachedAuthorizationInfo();
    }

}
