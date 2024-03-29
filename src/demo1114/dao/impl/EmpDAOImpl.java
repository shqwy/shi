package demo1114.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import demo1114.dao.IEmpDAO;
import demo1114.vo.Emp;

public class EmpDAOImpl implements IEmpDAO {
    private Connection conn=null;
    private PreparedStatement pstmt=null;
    public EmpDAOImpl(Connection conn) {
        this.conn = conn;
    }


public boolean doCreate(Emp emp) throws Exception{
    boolean flag =false;
    String sql = "INSERT INTO emp(empno,ename,job,hiredate,sal,comm)VALUES(?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,emp.getEmpno());
        this.pstmt.setString(2, emp.getEname());
        this.pstmt.setString(3, emp.getJob());
        this.pstmt.setDate(4, new java.sql.Date(emp.getHiredate().getTime()));
        this.pstmt.setFloat(5, emp.getSal());
        this.pstmt.setFloat(6, emp.getComm());
        
        if(this.pstmt.executeUpdate()>0) {
            flag=true;
        }

    this.pstmt.close();
    return flag;
}


public List<Emp> findAll(String keyWord) throws Exception {
    List<Emp> all = new ArrayList<Emp>();
    String sql = "SELECT empno, ename, job, hiredate ,sal , comm FROM emp WHERE ename LIKE? OR job LIKE?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, "%"+keyWord+"%");
        this.pstmt.setString(2, "%"+keyWord+"%");
        ResultSet rs =this.pstmt.executeQuery();
        Emp emp=null;
        while(rs.next()) {
            emp = new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getFloat(5));
            emp.setSal(rs.getFloat(6));
            all.add(emp);
        }

    this.pstmt.close();
    return all;
}


public Emp findByld(int empno) throws Exception {
    Emp emp=null;
    String sql = "SELECT empno, ename, job, hiredate ,sal FROM emp WHERE empno=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,empno);
        ResultSet rs =this.pstmt.executeQuery();
        while(rs.next()) {
            emp = new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setHiredate(rs.getDate(4));
            emp.setSal(rs.getFloat(5));
        }

    this.pstmt.close();
    return emp;
}
}
