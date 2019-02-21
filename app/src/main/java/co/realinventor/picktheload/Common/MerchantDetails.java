package co.realinventor.picktheload.Common;

public class MerchantDetails {
    public String uid, merchantName, surname, shopName, registerNo, place, phone;

    public MerchantDetails() {
    }

    public MerchantDetails(String uid, String merchantName, String surname, String shopName, String registerNo, String place, String phone) {
        this.uid = uid;
        this.merchantName = merchantName;
        this.surname = surname;
        this.shopName = shopName;
        this.registerNo = registerNo;
        this.place = place;
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getSurname() {
        return surname;
    }

    public String getShopName() {
        return shopName;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public String getPlace() {
        return place;
    }

    public String getPhone() {
        return phone;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
