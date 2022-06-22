package com.lab34.service;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
@Autowired 
HttpSession session;

@SuppressWarnings("unchecked")
public<T> T get(String name){
    return(T)session.getAttribute(name);
}
public<T> T get(String name,T defaultValue){
    T value = get(name);
    return value!=null?value:defaultValue;
}
/**
 *Thay đổi hoặc tạo mới attribute trong session
 *@param name tên attribute
*@param value giá tri attribute

/**
 *Xóa attribute trong session
 *@param name tên attribute cần xóa
 */
public void set(String name,Object value){
    session.setAttribute(name,value);
}
public void remove(String name){
    session.removeAttribute(name);
}
public void setAttribute(String name, Object value) {
	session.setAttribute(name, value);
}

}
