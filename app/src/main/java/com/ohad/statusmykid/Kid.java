package com.ohad.statusmykid;

public class Kid {

    public String className, kidId, firstName, lastName, parent01, parentPhone01, parent02, parentPhone02, email;
    public Boolean isPresent;

    public Kid(String className, String kidId, String firstName, String lastName, String parent01, String parentPhone01,String parent02, String parentPhone02, String email, Boolean isPresent){
        this.className = className;
        this.kidId = kidId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parent01 = parent01;
        this.parentPhone01 = parentPhone01;
        this.parent02 = parent02;
        this.parentPhone02 = parentPhone02;
        this.email = email;
        this.isPresent = isPresent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getKidId() {
        return kidId;
    }

    public void setKidId(String kidId) {
        this.kidId = kidId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getParent01() {
        return parent01;
    }

    public void setParent01(String parent01) {
        this.parent01 = parent01;
    }

    public String getParentPhone01() {
        return parentPhone01;
    }

    public void setParentPhone01(String parentPhone01) {
        this.parentPhone01 = parentPhone01;
    }

    public String getParent02() {
        return parent02;
    }

    public void setParent02(String parent02) {
        this.parent02 = parent02;
    }

    public String getParentPhone02() {
        return parentPhone02;
    }

    public void setParentPhone02(String parentPhone02) {
        this.parentPhone02 = parentPhone02;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }
}
