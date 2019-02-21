package co.realinventor.picktheload.Common;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class LorryPost {
    public String unique_id, capacity, date, location_from, location_to, truck_no, name, phone, from_uid, approved;

    public LorryPost(String unique_id, String capacity, String date, String location_from, String location_to, String truck_no, String name, String phone, String from_uid, String approved) {
        this.capacity = capacity;
        this.date = date;
        this.location_from = location_from;
        this.location_to = location_to;
        this.truck_no = truck_no;
        this.name = name;
        this.phone = phone;
        this.from_uid = from_uid;
        this.approved = approved;
        this.unique_id = unique_id;
    }

    public void makeLorryPost(String capacity, String date, String  location_from, String location_to, String truck_no, String name, String phone) {
        this.unique_id = UUID.randomUUID().toString();
        this.capacity = capacity;
        this.date = date;
        this.location_from = location_from;
        this.location_to = location_to;
        this.truck_no = truck_no;
        this.name = name;
        this.phone = phone;
        this.from_uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.approved = "no";

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Post_Lorry").child(unique_id).setValue(this);
    }

    public LorryPost(){}



    public void setCapacity(String capacity) {
        this.capacity = capacity;
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

    public void settruck_no(String truck_no) {
        this.truck_no = truck_no;
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

    public String getCapacity() {
        return capacity;
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

    public String gettruck_no() {
        return truck_no;
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
