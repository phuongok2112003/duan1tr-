/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author X.Phuong
 */
public class Controller<T> {
     private Class<T> entityClass;
    private static EntityManagerFactory emf;

    public Controller(Class<T> t) {
        entityClass = t;
        emf = Persistence.createEntityManagerFactory("QLTHUVIENPU");
    }
    public Controller(){
         emf = Persistence.createEntityManagerFactory("QLTHUVIENPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<T> getAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass).getResultList();
          
        } finally {
            em.close();
        }
    }

    public T findById(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }
    public List<T> findByIdAll(int id){
        EntityManager em = getEntityManager();
        try {
           return  em.createNamedQuery(entityClass.getSimpleName()+".findByMaPM",entityClass).setParameter("maPM", id).getResultList();
        } finally {
            em.close();
        }
    }

    public void xoa(Object id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T t = findById(id);
            if (t != null) {
                em.remove(em.contains(t) ? t : em.merge(t));
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void sua(T t) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void addSv(T t) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    
    public <T> Integer addNhanVien(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            // Ép kiểu entity sang Nhanvien để lấy mã nhân viên
            if (entity instanceof Nhanvien) {
                return ((Nhanvien) entity).getMaNV();
            }
            return null;
        } finally {
            em.close();
        }
    }
    
   public List<T> executeQuery(String queryStr, Map<String, Object> parameters) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<T> query = em.createQuery(queryStr, entityClass);
        parameters.entrySet().stream().forEach((entry) -> {
            query.setParameter(entry.getKey(), entry.getValue());
        });
        return query.getResultList();
    } finally {
        em.close();
    }
}
    public DefaultTableModel timkiem(DefaultTableModel model,Object keyword,String[] methodNames) {
        EntityManager em = getEntityManager();
        try {
            String queryStr = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE ";
            Field[] fields = entityClass.getDeclaredFields();
            List<String> conditions = new ArrayList<>();

            for (Field field : fields) {
                if (!field.getName().equals("serialVersionUID") && !field.getName().equals("enrollmentCollection")
                        &&!Collection.class.isAssignableFrom(field.getType())) {
                    conditions.add("e." + field.getName() + " LIKE :keyword");
                }
            }
            queryStr += String.join(" OR ", conditions);

            TypedQuery<T> query = em.createQuery(queryStr, entityClass);
            query.setParameter("keyword", "%" + keyword + "%");
            List<T> t= query.getResultList();
            return xuly(model,methodNames,t);
        } finally {
            em.close();
        }
    }
   public DefaultTableModel xuly(DefaultTableModel model,String[] methodNames,List<T> t){
         Method[] methods = new Method[methodNames.length];
         model.setRowCount(0);
        try {
            for (int i = 0; i < methodNames.length; i++) {
                methods[i] = entityClass.getMethod(methodNames[i]);
            }

            for (T a : t) {
                Object[] rowData = new Object[methods.length];
                for (int i = 0; i < methods.length; i++) {
                    rowData[i] = methods[i].invoke(a);
                }
                model.addRow(rowData);
            }
             
        } catch (Exception e) {
            e.printStackTrace();            
        }

        return model;
    }
    public DefaultTableModel loaddataChitet(DefaultTableModel model,String[] methodNames,String id){
        List<T> t = findByIdAll(Integer.parseInt(id));
        return xuly(model,methodNames,t);
    }
     public DefaultTableModel loaddata(DefaultTableModel model,String[] methodNames){
        List<T> t = getAll();
        return xuly(model,methodNames,t);
    }
    public void clear(JTextField []list,DefaultTableModel model){
        for(int i=0;i<list.length;i++){
            list[i].setText("");
        }
         model.setRowCount(0);
    }
    
}
