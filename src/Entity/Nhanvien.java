/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findByMaNV", query = "SELECT n FROM Nhanvien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "Nhanvien.findByHoTenNV", query = "SELECT n FROM Nhanvien n WHERE n.hoTenNV = :hoTenNV"),
    @NamedQuery(name = "Nhanvien.findByGioiTinh", query = "SELECT n FROM Nhanvien n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nhanvien.findByNgaySinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nhanvien.findBySdt", query = "SELECT n FROM Nhanvien n WHERE n.sdt = :sdt"),
    @NamedQuery(name = "Nhanvien.findByEmail", query = "SELECT n FROM Nhanvien n WHERE n.email = :email"),
    @NamedQuery(name = "Nhanvien.findByMatKhau", query = "SELECT n FROM Nhanvien n WHERE n.matKhau = :matKhau")})
public class Nhanvien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNV")
    private Integer maNV;
    @Column(name = "HoTenNV")
    private String hoTenNV;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "Email")
    private String email;
    @Column(name = "MatKhau")
    private String matKhau;
    @OneToMany(mappedBy = "maNV")
    private Collection<Hoadonphat> hoadonphatCollection;
    @OneToMany(mappedBy = "maNV")
    private Collection<Phieumuon> phieumuonCollection;

    public Nhanvien() {
    }

    public Nhanvien(Integer maNV) {
        this.maNV = maNV;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @XmlTransient
    public Collection<Hoadonphat> getHoadonphatCollection() {
        return hoadonphatCollection;
    }

    public void setHoadonphatCollection(Collection<Hoadonphat> hoadonphatCollection) {
        this.hoadonphatCollection = hoadonphatCollection;
    }

    @XmlTransient
    public Collection<Phieumuon> getPhieumuonCollection() {
        return phieumuonCollection;
    }

    public void setPhieumuonCollection(Collection<Phieumuon> phieumuonCollection) {
        this.phieumuonCollection = phieumuonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.Nhanvien[ maNV=" + maNV + " ]";
    }
    
}
