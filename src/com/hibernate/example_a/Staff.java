package com.hibernate.example_a;

import java.util.Date;

/**
 * Created by htc on 2017/4/11.
 */
public class Staff {
    private String empId ;
    private String empName;
    private Date workDate;
    // 描述
    private String desc;


    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
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
        return "Employee [empId=" + empId + ", empName=" + empName
                + ", workDate=" + workDate + "]";
    }

}
