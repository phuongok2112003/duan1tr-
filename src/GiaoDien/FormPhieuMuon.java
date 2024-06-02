/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GiaoDien;

import Entity.Chitietpm;
import Entity.Controller;
import Entity.Docgia;
import Entity.Nhanvien;
import Entity.Phieumuon;
import Entity.Sach;
import Untils.DateUtils;
import Untils.XuLy;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class FormPhieuMuon extends javax.swing.JFrame {

    /**
     * Creates new form FormPhieuMuon
     */
    Controller<Phieumuon> ketNoi = new Controller<>(Phieumuon.class);
    Controller<Docgia> ketNoi_dg = new Controller<>(Docgia.class);
    Controller<Nhanvien> ketNoi_nv = new Controller<>(Nhanvien.class);
    Controller<Chitietpm> ketNoi_CTPM = new Controller<>(Chitietpm.class);
    Controller<Sach> ketNoi_sach = new Controller<>(Sach.class);
    DefaultTableModel model;
    List<Docgia> listDocGia = ketNoi_dg.getAll();
    public FormPhieuMuon() {
        initComponents();
         for(Docgia dg : listDocGia){
            cboMaDG.addItem(dg.getMaDG()+"-"+dg.getHoTenDG());
        }
        model = (DefaultTableModel) jTable1.getModel();
        load();
    }
    
    void load() {
        clear();
        model = ketNoi.loaddata(model, new String[]{"getMaPM", "getInforDocGia", 
            "getInforNhanVien", "getNgayMuon", "getNgayHenTra", "getNgayTra", "getTrangThai"});
        
        txtMaNV.setText("1-Trần Huyền Trang");
       
    }
    
    void clear() {
        cboMaDG.setSelectedIndex(-1);
        ketNoi.clear(new JTextField[] {txtMaPM, txtMaNV, txtTimKiem}, model);
        DateUtils.setDateToCurrent(dtpNgayMuon);
        DateUtils.setDateToCurrent(dtpNgayTra);
        DateUtils.setDateToCurrent(dtpNgayHenTra);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaPM = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        dtpNgayMuon = new com.toedter.calendar.JDateChooser();
        dtpNgayHenTra = new com.toedter.calendar.JDateChooser();
        dtpNgayTra = new com.toedter.calendar.JDateChooser();
        rdoDaTra = new javax.swing.JRadioButton();
        rdoChuaTra = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnTraSach = new javax.swing.JButton();
        btnChiTietPhieu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cboMaDG = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Mã phiếu mượn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã độc giả");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày mượn");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Ngày hẹn trả");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Ngày trả");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Trạng thái");

        txtMaPM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaPM.setEnabled(false);

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaNV.setEnabled(false);

        dtpNgayMuon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        dtpNgayHenTra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        dtpNgayTra.setEnabled(false);
        dtpNgayTra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        buttonGroup1.add(rdoDaTra);
        rdoDaTra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoDaTra.setText("Đã trả");
        rdoDaTra.setEnabled(false);

        buttonGroup1.add(rdoChuaTra);
        rdoChuaTra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoChuaTra.setSelected(true);
        rdoChuaTra.setText("Chưa trả");
        rdoChuaTra.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUẢN LÝ MƯỢN TRẢ SÁCH");

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnTraSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTraSach.setText("Trả sách");
        btnTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSachActionPerformed(evt);
            }
        });

        btnChiTietPhieu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnChiTietPhieu.setText("Chi tiết phiếu");
        btnChiTietPhieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietPhieuActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu mượn", "Mã độc giả", "Mã nhân viên", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Trạng thái"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cboMaDG.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dtpNgayHenTra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(dtpNgayMuon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaPM, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMaDG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSua))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(btnTraSach)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                            .addComponent(btnChiTietPhieu))
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoDaTra)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoChuaTra))
                                    .addComponent(dtpNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(dtpNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdoDaTra)
                                            .addComponent(rdoChuaTra)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cboMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dtpNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dtpNgayHenTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua)
                            .addComponent(btnThem)
                            .addComponent(btnXoa)
                            .addComponent(btnClear))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTraSach)
                            .addComponent(btnChiTietPhieu))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row =jTable1.getSelectedRow();
        if(row>=0){
            txtMaPM.setText(jTable1.getValueAt( row, 0).toString());
            cboMaDG.setSelectedItem(jTable1.getValueAt(row, 1).toString());
            txtMaNV.setText(jTable1.getValueAt(row, 2).toString());
            
            dtpNgayMuon.setDate(DateUtils.parseDate(jTable1.getValueAt(row, 3).toString()));
            dtpNgayHenTra.setDate(DateUtils.parseDate(jTable1.getValueAt(row, 4).toString()));
            
            String ngayTraValue = jTable1.getValueAt(row, 5) != null ? jTable1.getValueAt(row, 5).toString() : null;
            if (ngayTraValue != null && !ngayTraValue.isEmpty()) {
                dtpNgayTra.setDate(DateUtils.parseDate(ngayTraValue));
            } else {
                dtpNgayTra.setDate(null);
            }
            
            if(jTable1.getValueAt(row, 6).toString().equals("true")){
                rdoDaTra.setSelected(true);
            }else rdoChuaTra.setSelected(true);
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Phieumuon pm = new Phieumuon();
        pm.setMaDG( ketNoi_dg.findById(XuLy.layId(cboMaDG.getSelectedItem().toString())));
        pm.setMaNV(ketNoi_nv.findById(XuLy.layId(txtMaNV.getText())));
        pm.setNgayMuon(dtpNgayMuon.getDate());
        pm.setNgayHenTra(dtpNgayHenTra.getDate());
        pm.setNgayTra(null);
        pm.setTrangThai(false);
        
        ketNoi.addSv(pm);
        load();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (!txtMaPM.getText().isEmpty()) {
            Phieumuon pm = new Phieumuon();
            pm.setMaPM(Integer.parseInt(txtMaPM.getText()));
            pm.setMaDG(ketNoi_dg.findById(XuLy.layId(cboMaDG.getSelectedItem().toString())));
            pm.setMaNV(ketNoi_nv.findById(XuLy.layId(txtMaNV.getText())));
            pm.setNgayMuon(dtpNgayMuon.getDate());
            pm.setNgayHenTra(dtpNgayHenTra.getDate());
            pm.setNgayTra(null);
            pm.setTrangThai(false);

            ketNoi.sua(pm);
            load();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if(!txtMaPM.getText().isEmpty()){
            ketNoi.xoa(Integer.parseInt(txtMaPM.getText()));
            load();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        load();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(!txtTimKiem.getText().isEmpty()){
            String key=txtTimKiem.getText();

            List<Phieumuon> pm = ketNoi.getAll();
            List<Phieumuon> result=pm.stream().filter(rootPane->
                rootPane.getMaPM().toString().contains(key)||
                rootPane.getMaDG().getMaDG().toString().contains(key)||
                rootPane.getMaNV().getMaNV().toString().contains(key)||
                rootPane.getNgayMuon().toString().contains(key)||
                rootPane.getNgayHenTra().toString().contains(key)|| 
                rootPane.getNgayTra().toString().contains(key)||
                rootPane.getTrangThai().toString().contains(key)
            ).collect(Collectors.toList());
            model=ketNoi.xuly(model,new String[]{"getMaPM", "getInforDocGia", 
            "getInforNhanVien", "getNgayMuon", "getNgayHenTra", "getNgayTra", "getTrangThai"}, result);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnChiTietPhieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietPhieuActionPerformed
        int row=jTable1.getSelectedRow();
        if(row>=0){
            FormChiTietPhieuMuon form = new FormChiTietPhieuMuon(jTable1.getValueAt(row, 0).toString());
            form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đảm bảo form sẽ đóng mà không tắt ứng dụng
            form.setVisible(true);
        }
    }//GEN-LAST:event_btnChiTietPhieuActionPerformed

    private void btnTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSachActionPerformed
        if (!txtMaPM.getText().isEmpty()) {
            Phieumuon pm = new Phieumuon();
            pm.setMaPM(Integer.parseInt(txtMaPM.getText()));
            pm.setMaDG(ketNoi_dg.findById(XuLy.layId(cboMaDG.getSelectedItem().toString())));
            pm.setMaNV(ketNoi_nv.findById(XuLy.layId(txtMaNV.getText())));
            pm.setNgayMuon(dtpNgayMuon.getDate());
            pm.setNgayHenTra(dtpNgayHenTra.getDate());
            DateUtils.setDateToCurrent(dtpNgayTra);
            pm.setNgayTra(dtpNgayTra.getDate());
            pm.setTrangThai(true);

            ketNoi.sua(pm);
            
            List<Chitietpm> chitietpm = ketNoi_CTPM.findByIdAll(Integer.parseInt(txtMaPM.getText()));
            for(Chitietpm chi : chitietpm) {
                try{
                    int soLuongMuon = chi.getSoLuongMuon();

                    Sach kho=chi.getSach();

                    kho.setSoLuong(kho.getSoLuong()+soLuongMuon);
                    ketNoi_sach.sua(kho);
                    
                } catch(Exception e){
                   XuLy.mesLoi(e, this);
                }    
            }
            
            load();
        }
    }//GEN-LAST:event_btnTraSachActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPhieuMuon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietPhieu;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTraSach;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboMaDG;
    private com.toedter.calendar.JDateChooser dtpNgayHenTra;
    private com.toedter.calendar.JDateChooser dtpNgayMuon;
    private com.toedter.calendar.JDateChooser dtpNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rdoChuaTra;
    private javax.swing.JRadioButton rdoDaTra;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPM;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
