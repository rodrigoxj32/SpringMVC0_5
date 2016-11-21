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

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


 
@Service("formExportacionService")
public class FormExportacionServiceImpl implements FormExportacionService {
    
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

    public void desconetcar() {
        if (cn != null) {
            cn = null;
        }
    }

    @Override
    public Formularioexportacion findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            desconetcar();
        }
            

    }

    @Override
    public void updateFormularioExportacion(Formularioexportacion user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFormularioExportacionById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formularioexportacion> findAllFormExportacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllFormularioexportacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
