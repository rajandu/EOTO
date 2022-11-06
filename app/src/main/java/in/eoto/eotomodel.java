package in.eoto;

public class eotomodel {

    String picture;
    String fullName;
    String age;
    String address;
    String phoneNo;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }



    public eotomodel(String picture, String fullName, String age, String address, String phoneNo) {
        this.picture = picture;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.phoneNo = phoneNo;
    }





}
