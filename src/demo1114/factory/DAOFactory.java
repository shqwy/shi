package demo1114.factory;

import demo1114.dao.IEmpDAO;
import demo1114.dao.proxy.IEmpDAOProxy;

public class DAOFactory {
	    public static IEmpDAO getIEmpDAOInstance() throws Exception {
	        return new IEmpDAOProxy();
	    }
}

