package com.tmh.web.service.realm;

import java.util.Random;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.tmh.web.domain.User;

public class PasswordCreate {
	
	private String hashAlgorithmName;
	private String hashIterations;
	private String storedCredentialsHexEncoded;
	
	public String getHashAlgorithmName() {
		return hashAlgorithmName;
	}

	public void setHashAlgorithmName(String hashAlgorithmName) {
		this.hashAlgorithmName = hashAlgorithmName;
	}

	public String getHashIterations() {
		return hashIterations;
	}

	public void setHashIterations(String hashIterations) {
		this.hashIterations = hashIterations;
	}

	public String getStoredCredentialsHexEncoded() {
		return storedCredentialsHexEncoded;
	}

	public void setStoredCredentialsHexEncoded(String storedCredentialsHexEncoded) {
		this.storedCredentialsHexEncoded = storedCredentialsHexEncoded;
	}

	public void createPassword(User user){
		Random r = new Random();
		int nextInt = r.nextInt(10);
		String salt = nextInt+user.getUsername();
		user.setSalt(salt);//生成加密用的salt
		String password = null;
		if("true".equalsIgnoreCase(storedCredentialsHexEncoded)){
			password = new SimpleHash(hashAlgorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), Integer.parseInt(hashIterations)).toHex();
		}else{
			password = new SimpleHash(hashAlgorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), Integer.parseInt(hashIterations)).toString();
		}
		user.setPassword(password);
	}
	
}
