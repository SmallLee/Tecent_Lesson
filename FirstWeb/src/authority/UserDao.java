package authority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDao {
    private static HashMap<String,User> users;
    private static List<Authority> authorities;
    static {
        users = new HashMap<String,User>();
        authorities = new ArrayList<Authority>();
        authorities.add(new Authority("Article-1","article-1.jsp"));
        authorities.add(new Authority("Article-2","article-2.jsp"));
        authorities.add(new Authority("Article-3","article-3.jsp"));
        authorities.add(new Authority("Article-4","article-4.jsp"));
        User user1 = new User("AAA",authorities.subList(0,2));
        users.put("AAA",user1);

        User user2 = new User("BBB",authorities.subList(2,4));
        users.put("BBB",user2);
    }

    public static User get(String name){
        return users.get(name);
    }

    public static void update(String name, List<Authority>  authorities) {
        users.get(name).setAuthorities(authorities);
    }
    //获得所有的权限

    public static List<Authority> getAuthorities() {
        return authorities;
    }
    public static List<Authority> getAuthorities(String[] urls) {
        List<Authority> authorityList = new ArrayList<Authority>();
        for (Authority authority : authorities) {
            if (urls != null) {
                for (String url : urls) {
                    System.out.println("url: "+url);
                    if (url.equals(authority.getUrl())) {
                        authorityList.add(authority);
                    }
                }
            }
        }
        return authorityList;
    }
}
