package sn.exo.controller;

import sn.exo.entities.User;

import java.util.List;

public interface IUser {
    public int Add(User u) throws Exception;
    public int Delete(int id) throws Exception;
    public int update(User u) throws  Exception;
    public User get(int id) throws  Exception;
    public List<User> liste() throws Exception;
}
