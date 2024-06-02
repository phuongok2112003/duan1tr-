/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "docgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docgia.findAll", query = "SELECT d FROM Docgia d"),
    @NamedQuery(name = "Docgia.findByMaDG", query = "SELECT d FROM Docgia d WHERE d.maDG = :maDG"),
    @NamedQuery(name = "Docgia.findByHoTenDG", query = "SELECT d FROM Docgia d WHERE d.hoTenDG = :hoTenDG"),
    @NamedQuery(name = "Docgia.findByGioiTinh", query = "SELECT d FROM Docgia d WHERE d.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Docgia.findByNgaySinh", query = "SELECT d FROM Docgia d WHERE d.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Docgia.findBySdt", query = "SELECT d FROM Docgia d WHERE d.sdt = :sdt"),
    @NamedQuery(name = "Docgia.findByEmail", query = "SELECT d FROM Docgia d WHERE d.email = :email")})
public class Docgia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDG")
    private Integer maDG;
    @Column(name = "HoTenDG")
    private String hoTenDG;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "Email")
    private String email;
    @Lob
    @Column(name = "DiaChi")
    private String diaChi;
    @OneToMany(mappedBy = "maDG")
    private Collection<Phieumuon> phieumuonCollection;

    public Docgia() {
    }

    public Docgia(Integer maDG) {
        this.maDG = maDG;
    }

    public Integer getMaDG() {
        return maDG;
    }

    public void setMaDG(Integer maDG) {
        this.maDG = maDG;
    }

    public String getHoTenDG() {
        return hoTenDG;
    }

    public void setHoTenDG(String hoTenDG) {
        this.hoTenDG = hoTenDG;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(ngaySinh);
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
        hash += (maDG != null ? maDG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docgia)) {
            return false;
        }
        Docgia other = (Docgia) object;
        if ((this.maDG == null && other.maDG != null) || (this.maDG != null && !this.maDG.equals(other.maDG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.Docgia[ maDG=" + maDG + " ]";
    }
    
}
