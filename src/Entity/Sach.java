/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import Entity.Chitietpm;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "sach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sach.findAll", query = "SELECT s FROM Sach s"),
    @NamedQuery(name = "Sach.findByMaSach", query = "SELECT s FROM Sach s WHERE s.maSach = :maSach"),
    @NamedQuery(name = "Sach.findByNxb", query = "SELECT s FROM Sach s WHERE s.nxb = :nxb"),
    @NamedQuery(name = "Sach.findByTacGia", query = "SELECT s FROM Sach s WHERE s.tacGia = :tacGia"),
    @NamedQuery(name = "Sach.findByViTri", query = "SELECT s FROM Sach s WHERE s.viTri = :viTri"),
    @NamedQuery(name = "Sach.findBySoLuong", query = "SELECT s FROM Sach s WHERE s.soLuong = :soLuong")})
public class Sach implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSach")
    private Integer maSach;
    @Lob
    @Column(name = "TenSach")
    private String tenSach;
    @Column(name = "NXB")
    private String nxb;
    @Column(name = "TacGia")
    private String tacGia;
    @Column(name = "ViTri")
    private String viTri;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Lob
    @Column(name = "TinhTrang")
    private String tinhTrang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sach")
    private Collection<Chitietpm> chitietpmCollection;

    public Sach() {
    }

    public Sach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @XmlTransient
    public Collection<Chitietpm> getChitietpmCollection() {
        return chitietpmCollection;
    }

    public void setChitietpmCollection(Collection<Chitietpm> chitietpmCollection) {
        this.chitietpmCollection = chitietpmCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSach != null ? maSach.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sach)) {
            return false;
        }
        Sach other = (Sach) object;
        if ((this.maSach == null && other.maSach != null) || (this.maSach != null && !this.maSach.equals(other.maSach))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.Sach[ maSach=" + maSach + " ]";
    }
    
}
