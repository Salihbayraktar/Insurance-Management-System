package Address;

public abstract class AddressAbstract implements Address {

    int id;
    String address;
    int postCode;

    public AddressAbstract(int id, String addressName, int postCode) {
        this.id = id;
        this.address = addressName;
        this.postCode = postCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
