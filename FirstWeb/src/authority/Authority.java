package authority;

public class Authority {
    private String displayName;


    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Authority(){

    }
    public Authority(String displayName,String url) {
        this.displayName = displayName;
        this.url = url;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this){
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Authority authority = (Authority) obj;
        if (url == null) {
            if (authority.url != null) {
                return false;
            }
        }else if(!url.equals(authority.url)){
            return false;
        }
        return true;
    }
}
