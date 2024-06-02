/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Untils;

import Entity.Nhanvien;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class XuLy {
    public static int layId(String a) {
        int id=-1;
        try{
           return Integer.parseInt(a.split("-")[0]);
        }catch(Exception e){
            return id;
        }
    }
    
    public static void mesLoi(Exception e,JFrame t){
           JOptionPane.showMessageDialog(t,e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
     }
    
    public static Nhanvien taiKhoanNhanVien;
}
