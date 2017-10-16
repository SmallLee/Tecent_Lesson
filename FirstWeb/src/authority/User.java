package authority;

import java.util.List;

public class User {
    private String name;
    private List<Authority> authorities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
    public User(){

    }
    public User(String name,List<Authority> authorities) {
        this.name = name;
        this.authorities = authorities;
    }
}
