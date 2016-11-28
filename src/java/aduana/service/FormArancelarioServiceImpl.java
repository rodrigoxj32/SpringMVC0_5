/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

import org.springframework.stereotype.Service;
 
import aduana.modelo.Formularioarancelario;
import aduana.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Service("formArancelarioService")
public class FormArancelarioServiceImpl implements FormArancelarioService {
     
    
    private static List<Formularioarancelario> formularioarancelario;
	
   
    private HibernateTemplate  hibernateTemplate;
    

    Session cn = HibernateUtil.getSessionFactory().getCurrentSession();

    public FormArancelarioServiceImpl() {
        cn = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Session getSession() {
        if (cn == null) {
            cn = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        return cn;
    }

    public void desconectar() {
        if (cn != null) {
            cn = null;
        }
    }
    
    @Override
    public Formularioarancelario findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveFormularioArancelario(Formularioarancelario fa) {
            /*codigo para guardar en la base*/
        System.out.println("algo paso");
        
        Transaction t = getSession().getTransaction();
        try {
            t.begin();
            getSession().save(fa);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFormularioArancelario(Formularioarancelario fa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFormularioArancelarioById(long id) {
        
        Transaction t = getSession().getTransaction();
        try {
            t.begin();
            
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Formularioarancelario> findAllFormularioArancelario() {        
        //String hql = "FROM Person as p ORDER BY p.pid";
	System.out.println("algo paso findAllFormularioArancelario");
        String hql = "FROM igf.formularioarancelario";
        try {
            //lista = getSession().createCriteria(Cajero.class).list();
            formularioarancelario = getSession().createQuery(hql).list();
            //lista = getSession().createSQLQuery("select * from cajero").list();
        } catch (Exception e) {
        } finally {
            desconectar();
        }
        return formularioarancelario;
     
    }

    @Override
    public void deleteAllFormularioArancelario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

