package com.ucmo.virtualclassroom.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.ucmo.virtualclassroom.config.MyUserPrincipal;

public class UCMUtils {
	
	public static MyUserPrincipal getUser()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MyUserPrincipal userData = null;
		if (principal instanceof MyUserPrincipal)
		{
			userData =(MyUserPrincipal) principal;
		}
		return userData;
	}
}

