/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

import org.springframework.stereotype.Service;
 
import aduana.modelo.Formularioarancelario;
import aduana.HibernateUtil;
import aduana.modelo.Formularioexportacion;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Service("formArancelarioService ")
@Transactional
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
              Formularioarancelario aux = null;
        Transaction t = getSession().getTransaction();    
        try {
            t.begin();           
            aux = (Formularioarancelario) getSession().createCriteria(Formularioarancelario.class).setFirstResult(id).uniqueResult();
            t.commit();

        } catch (Exception e) {
             t.rollback();
        } finally {
           desconectar();
        }
        return aux;
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
             Transaction t = getSession().getTransaction();
        try {
            t.begin();
            getSession().update(fa);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        }
    }

    @Override
    public void deleteFormularioArancelarioById(int fa) {
        
        Transaction t = getSession().getTransaction();
        try {
            t.begin();
             getSession().delete(fa);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        }

    }

   
    @Override
    public List<Formularioarancelario> findAllFormularioArancelario() {
	      System.out.println("algo paso findAllFormularioArancelario");
        List<Formularioarancelario> formularioarancelario = null;
        Transaction t = getSession().getTransaction(); 
        String hql = "from Formularioarancelario f";
        try {
            t.begin();
            formularioarancelario = getSession().createQuery(hql).list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
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

