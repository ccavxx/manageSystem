package com.tmh.web.service.realm;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	/**
	 * 用于记录用户登录错误的次数 
	 */
    private Cache<String, AtomicInteger> passwordRetryCache;
    
    private Integer excessiveCount;
    

    public Integer getExcessiveCount() {
		return excessiveCount;
	}

	public void setExcessiveCount(Integer excessiveCount) {
		this.excessiveCount = excessiveCount;
	}

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");//没有就创建
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();//从登陆凭证中用户名
        AtomicInteger retryCount = passwordRetryCache.get(username);//查看当前缓存中改用户是否有登陆错误记录
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > excessiveCount) {//如果登陆5次错误 就不让登陆 直接抛出一场
            throw new ExcessiveAttemptsException();//错误次数过多
        }
        //成功登陆  则清楚缓存记录
        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
