package dao;

public class CriteriaCustomer {
    public int id;
    public String name;
    public String address;
    public String phone;

    public CriteriaCustomer(){

    }

    public CriteriaCustomer(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public CriteriaCustomer( String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }



    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setAddress(String address) {
        this.address = address;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        System.out.println("name=========="+name);
        return name == null ? "%%": "%"+name+"%";
    }

    public String getAddress() {
        return address == null ? "%%": "%"+address+"%";
    }

    public String getPhone() {
        return phone == null ? "%%": "%"+phone+"%";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
