package com.page.entity;

/**
 * Created by 聪 on 2017/4/10.
 */
public class Employee {

    private int empId;			// 员工id
    private String empName;		// 员工名称
    private int dept_id;		// 部门id

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
    public int getDept_id() {
        return dept_id;
    }
    public void setDept_id(int deptId) {
        dept_id = deptId;
    }


}

