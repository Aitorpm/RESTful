package edu.upc.eetac.dsa.grouptalk.dao;

/**
 * Created by Aitor on 24/10/15.
 */
public interface UserDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_USER = "insert into users (id, loginid, password,) values (UNHEX(?), ?, UNHEX(MD5(?)));";
    public final static String ASSIGN_ROLE_REGISTERED = "insert into user_roles (loginid, role) values (UNHEX(?), ?)";
    public final static String GET_USER_BY_ID = "select hex(u.id) as id, u.loginid from users u where id=unhex(?)";
    public final static String GET_USER_BY_USERNAME = "select hex(u.id) as id, u.loginid from users u where u.loginid=?";
    public final static String DELETE_USER = "delete from users where id=unhex(?)";
    public final static String GET_PASSWORD =  "select hex(password) as password from users where id=unhex(?)";
    public final static String COMPARE_USER_GROUP =  "select ";
}