/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import Entity.Chitietpm;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "phieumuon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phieumuon.findAll", query = "SELECT p FROM Phieumuon p"),
    @NamedQuery(name = "Phieumuon.findByMaPM", query = "SELECT p FROM Phieumuon p WHERE p.maPM = :maPM"),
    @NamedQuery(name = "Phieumuon.findByNgayMuon", query = "SELECT p FROM Phieumuon p WHERE p.ngayMuon = :ngayMuon"),
    @NamedQuery(name = "Phieumuon.findByNgayHenTra", query = "SELECT p FROM Phieumuon p WHERE p.ngayHenTra = :ngayHenTra"),
    @NamedQuery(name = "Phieumuon.findByNgayTra", query = "SELECT p FROM Phieumuon p WHERE p.ngayTra = :ngayTra"),
    @NamedQuery(name = "Phieumuon.findByTrangThai", query = "SELECT p FROM Phieumuon p WHERE p.trangThai = :trangThai")})
public class Phieumuon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaPM")
    private Integer maPM;
    @Column(name = "NgayMuon")
    @Temporal(TemporalType.DATE)
    private Date ngayMuon;
    @Column(name = "NgayHenTra")
    @Temporal(TemporalType.DATE)
    private Date ngayHenTra;
    @Column(name = "NgayTra")
    @Temporal(TemporalType.DATE)
    private Date ngayTra;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "phieumuon")
    private Collection<Chitietpm> chitietpmCollection;
    @JoinColumn(name = "MaDG", referencedColumnName = "MaDG")
    @ManyToOne
    private Docgia maDG;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne
    private Nhanvien maNV;

    public Phieumuon() {
    }

    public Phieumuon(Integer maPM) {
        this.maPM = maPM;
    }

    public Integer getMaPM() {
        return maPM;
    }

    public void setMaPM(Integer maPM) {
        this.maPM = maPM;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayHenTra() {
        return ngayHenTra;
    }

    public void setNgayHenTra(Date ngayHenTra) {
        this.ngayHenTra = ngayHenTra;
    }

    public Date getNgayTra() {
        return ngayTra;
    }
    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @XmlTransient
    public Collection<Chitietpm> getChitietpmCollection() {
        return chitietpmCollection;
    }

    public void setChitietpmCollection(Collection<Chitietpm> chitietpmCollection) {
        this.chitietpmCollection = chitietpmCollection;
    }

    public Docgia getMaDG() {
        return maDG;
    }

    public void setMaDG(Docgia maDG) {
        this.maDG = maDG;
    }

    public Nhanvien getMaNV() {
        return maNV;
    }

    public void setMaNV(Nhanvien maNV) {
        this.maNV = maNV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPM != null ? maPM.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phieumuon)) {
            return false;
        }
        Phieumuon other = (Phieumuon) object;
        if ((this.maPM == null && other.maPM != null) || (this.maPM != null && !this.maPM.equals(other.maPM))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.Phieumuon[ maPM=" + maPM + " ]";
    }
    
}
