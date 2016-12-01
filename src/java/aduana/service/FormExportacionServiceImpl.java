/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aduana.service;

/**
 *
 * @author Rodrigo Daniel
 */

import org.springframework.stereotype.Service;
 
import aduana.modelo.Formularioexportacion;
import aduana.HibernateUtil;
import aduana.modelo.Formularioarancelario;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


@Service("formExportacionService")
public class FormExportacionServiceImpl implements FormExportacionService {
    
    private static List<Formularioexportacion> formularioexportacion;
     Session cn = HibernateUtil.getSessionFactory().getCurrentSession();

    public FormExportacionServiceImpl() {
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
    public Formularioexportacion findById(int id) {
        Formularioexportacion aux = null;
        Transaction t = getSession().getTransaction();    
        try {
            t.begin();           
            aux = (Formularioexportacion) getSession().createCriteria(Formularioexportacion.class).setFirstResult(id).uniqueResult();
            t.commit();

        } catch (Exception e) {
             t.rollback();
        } finally {
           desconectar();
        }
        return aux;
    }

    @Override
    public void saveFormularioExportacion(Formularioexportacion c) {
        
            /*codigo para guardar en la base*/
        System.out.println("algo paso");
        
        Transaction t = getSession().getTransaction();
        try {
            t.begin();
            getSession().save(c);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        }
            

    }

    @Override
    public void updateFormularioExportacion(Formularioexportacion fe) {
        Transaction t = getSession().getTransaction();
        try {
            t.begin();
            getSession().update(fe);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        }
    }

    @Override
    public void deleteFormularioExportacionById(Formularioexportacion fe) {
        Transaction t = getSession().getTransaction();
        try {
            t.begin();
            getSession().delete(fe);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            desconectar();
        }
    }

    @Override
    public List<Formularioexportacion> findAllFormExportacion() {
                //String hql = "FROM Person as p ORDER BY p.pid";
	System.out.println("algo paso findAllFormularioArancelario");
        String hql = "FROM Formularioexportacion";
        try {
            //lista = getSession().createCriteria(Cajero.class).list();
            formularioexportacion= getSession().createQuery(hql).list();
            //lista = getSession().createSQLQuery("select * from cajero").list();
        } catch (Exception e) {
            
        } finally {
            desconectar();
        }
        return formularioexportacion;
    }

    @Override
    public void deleteAllFormularioexportacion() {
        
    }
    
}
