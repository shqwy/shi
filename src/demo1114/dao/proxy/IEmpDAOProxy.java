package demo1114.dao.proxy;

import java.util.List;
import demo1114.dao.IEmpDAO;
import demo1114.dao.impl.EmpDAOImpl;
import demo1114.dbc.DatabaseConnection;
import demo1114.vo.Emp;

public class IEmpDAOProxy implements IEmpDAO{
    private DatabaseConnection dbc = null;
    private IEmpDAO dao=null;
    public IEmpDAOProxy() throws Exception {
        this.dbc = new DatabaseConnection();
        // 在这里对真正的DAO实现内进行实例化       
        this.dao = new EmpDAOImpl(this.dbc.getConnection());
    }

    @Override
    // 书籍查找
    public boolean doCreate(Emp emp) throws Exception {
        boolean flag = false;
        try {
            if(this.dao.findByld(emp.getEmpno())==null) {
            	flag=this.dao.doCreate(emp);
            }
        }catch(Exception e) {
            throw e;
        }finally {
            // 关闭数据库
            this.dbc.close();
        }
        return flag;
    }

    @Override
    // 列出所有书籍
    public List<Emp> findAll(String keyWord) throws Exception {
        List<Emp> all = null;
        try {
            all = this.dao.findAll(keyWord);
        }catch(Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return all;
    }

 
    public Emp findByld(int empno) throws Exception {
        Emp emp=null;
        try {
            emp=this.dao.findByld(empno);
        }catch(Exception e) {
            throw e;
        }finally {
            this.dbc.close();
        }
        return emp;
    }
}
 
