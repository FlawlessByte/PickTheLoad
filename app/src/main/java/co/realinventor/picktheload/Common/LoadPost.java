package co.realinventor.picktheload.Common;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class LoadPost {
    public String unique_id, truck_type, capacity, goods_type, date, location_from, location_to, expected_price, name, phone, from_uid, approved;

    public LoadPost(String unique_id, String truck_type, String capacity, String goods_type, String date, String location_from,
                    String location_to, String expected_price, String name, String phone, String from_uid, String approved) {
        this.unique_id = unique_id;
        this.truck_type = truck_type;
        this.capacity = capacity;
        this.goods_type = goods_type;
        this.date = date;
        this.location_from = location_from;
        this.location_to = location_to;
        this.expected_price = expected_price;
        this.name = name;
        this.phone = phone;
        this.from_uid = from_uid;
        this.approved = approved;
    }

    public LoadPost() {
    }

    public void makeLoadPost(String truck_type, String capacity,  String goods_type, String date, String location_from,
                             String location_to, String expected_price, String name, String phone){
        this.unique_id = UUID.randomUUID().toString();
        this.truck_type = truck_type;
        this.capacity = capacity;
        this.goods_type = goods_type;
        this.date = date;
        this.location_from = location_from;
        this.location_to = location_to;
        this.expected_price = expected_price;
        this.name = name;
        this.phone = phone;
        this.from_uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.approved = "no";


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Post_Load").child(unique_id).setValue(this);

    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation_from(String location_from) {
        this.location_from = location_from;
    }

    public void setLocation_to(String location_to) {
        this.location_to = location_to;
    }

    public void setExpected_price(String expected_price) {
        this.expected_price = expected_price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFrom_uid(String from_uid) {
        this.from_uid = from_uid;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public String getDate() {
        return date;
    }

    public String getLocation_from() {
        return location_from;
    }

    public String getLocation_to() {
        return location_to;
    }

    public String getExpected_price() {
        return expected_price;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFrom_uid() {
        return from_uid;
    }

    public String getApproved() {
        return approved;
    }
}
