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
import org.springframework.transaction.annotation.Transactional;


@Service("formArancelarioService")
@Transactional
public class FormArancelarioServiceImpl implements FormArancelarioService {
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

    public void desconetcar() {
        if (cn != null) {
            cn = null;
        }
    }
    
    @Override
    public Formularioarancelario findById(long id) {
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
            desconetcar();
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFormularioArancelario(Formularioarancelario fa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFormularioArancelarioById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formularioarancelario> findAllFormularioArancelario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllFormularioArancelario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

