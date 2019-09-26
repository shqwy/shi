package demo1114.dao;
import java.util.List;
import demo1114.vo.Emp;

public interface IEmpDAO {

    public boolean doCreate(Emp emp) throws Exception;
    public List<Emp>findAll(String keyWord) throws Exception;
    public Emp findByld(int empno) throws Exception;
}
