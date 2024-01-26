package com.example.schoolmanagementsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "guardian")
public class Guardian {

    @Id
    @Column(name = "guardian-id")
    private long guardianId;

    @Column(name ="guardian-name")
    private String name;

    @Column(name = "guardian-mobile")
    private String mobile;

    public Guardian() {
    }

    public Guardian(long guardianId, String name, String mobile) {
        this.guardianId = guardianId;
        this.name = name;
        this.mobile = mobile;
    }

    public long getGuardianId() {
        return guardianId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setGuardianId(long guardianId) {
        this.guardianId = guardianId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
