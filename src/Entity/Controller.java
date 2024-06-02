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
import java.util.stream.Collectors;
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

// định nghĩa một lớp tổng quát (Controller<T>) trong Java để thực hiện các thao tác cơ bản với cơ sở dữ liệu sử dụng JPA
public class Controller<T> {
    private Class<T> entityClass;  //entityClass là lớp thực thể mà Controller sẽ làm việc.
    private static EntityManagerFactory emf;

    public Controller(Class<T> t) {
        entityClass = t;
        emf = Persistence.createEntityManagerFactory("QLTHUVIENPU");  // tạo và quản lý các EntityManager cần thiết để thực hiện
                                                                      //các hoạt động tương tác với cơ sở dữ liệu.
    }
    public Controller(){
         emf = Persistence.createEntityManagerFactory("QLTHUVIENPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();    // trả về một EntityManager từ EntityManagerFactory.
    }

    //Lấy tất cả các bản ghi của thực thể T bằng cách sử dụng NamedQuery có định danh entityClass.getSimpleName() + ".findAll"
    public List<T> getAll() {
        EntityManager em = getEntityManager();
        try {
            return em.createNamedQuery(entityClass.getSimpleName() + ".findAll", entityClass).getResultList();
          
        } finally {
            em.close();
        }
    }

    // Tìm một bản ghi cụ thể theo ID.
    public T findById(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }
    
    // trả về danh sách các thực thể T dựa trên ID là maPM. Sử dụng NamedQuery với định danh entityClass.getSimpleName() + ".findByMaPM".
    public List<T> findByIdAll(int id){
        EntityManager em = getEntityManager();
        try {
           return  em.createNamedQuery(entityClass.getSimpleName()+".findByMaPM",entityClass).setParameter("maPM", id).getResultList();
        } finally {
            em.close();
        }
    }

    // Xóa thực thể theo ID
    public void xoa(Object id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T t = findById(id);    
            // Nếu thực thể tồn tại
            if (t != null) {
                em.remove(em.contains(t) ? t : em.merge(t));    // Xóa khỏi CSDL
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Cập nhật một thực thể
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

    //Thêm một thực thể mới
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
    
    // Tìm kiếm các thực thể dựa trên từ khóa và trả về kết quả dưới dạng bảng dữ liệu (DefaultTableModel)
    public DefaultTableModel timkiem(DefaultTableModel model,String keyword,String[] methodNames) {
        List<T> list=getAll();
        List<T> t=list.stream().filter(a-> containsKey(a, keyword, methodNames)).collect(Collectors.toList());
        
         return xuly(model,methodNames,t);
    }
    
     private  boolean containsKey(T item, String key, String[] methodNames) {
        try {
            for (String methodName : methodNames) {
                Method method = entityClass.getMethod(methodName);
                Object value = method.invoke(item);
                if (value != null && value.toString().contains(key)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
