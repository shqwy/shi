package demo1114.vo;

import java.util.Date;

public class Emp {
	private int empno;
    private String ename;
    private String job;
    private Date hiredate;
    private float sal;
    private float comm;
    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job=job;
    }
    public Date getHiredate() {
        return hiredate;
    }
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
    public float getSal() {
    	return sal;
    }
    public void setSal(float sal) {
    	this.sal=sal;
    }
	public float getComm() {
		return comm;
	}
	public void setComm(float comm) {
		this.comm = comm;
	}

}
