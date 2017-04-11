package com.hibernate.entity;

/**
 * Created by htc on 2017/4/11.
 */
import java.util.Date;

//一、 对象
public class Employees {

    private int empId;
    private String empName;
    private Date workDate;

    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public Date getWorkDate() {
        return workDate;
    }
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }
    @Override
    public String toString() {
        return "Employees [empId=" + empId + ", empName=" + empName
                + ", workDate=" + workDate + "]";
    }

}

