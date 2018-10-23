package ru.job4j.store;

import ru.job4j.generic.SimpleArray;

public class UserStore extends Base implements Store<User>{

    private SimpleArray<User> simpleArray;

    protected UserStore(String id) {
        super(id);
    }

    @Override
    public void add(User model) {
        //super.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        //return super.replace(id, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        //return super.delete(id);\
        return true;
    }

    @Override
    public User findById(String id) {
        return simpleArray.get(0);
    }
}