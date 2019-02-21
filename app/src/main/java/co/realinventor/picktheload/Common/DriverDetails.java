package co.realinventor.picktheload.Common;

public class DriverDetails {
    public String uid, driverName, surName, licenseNo, vehicleNo, place, phone;

    public DriverDetails(String uid, String driverName, String surName, String licenseNo, String vehicleNo, String place, String phone) {
        this.uid = uid;
        this.driverName = driverName;
        this.surName = surName;
        this.licenseNo = licenseNo;
        this.vehicleNo = vehicleNo;
        this.place = place;
        this.phone = phone;
    }

    public DriverDetails() {
    }


    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getSurName() {
        return surName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getPlace() {
        return place;
    }

    public String getPhone() {
        return phone;
    }


}
