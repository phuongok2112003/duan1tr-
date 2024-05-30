/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "chitietpm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitietpm.findAll", query = "SELECT c FROM Chitietpm c"),
    @NamedQuery(name = "Chitietpm.findByMaPM", query = "SELECT c FROM Chitietpm c WHERE c.chitietpmPK.maPM = :maPM"),
    @NamedQuery(name = "Chitietpm.findByMaSach", query = "SELECT c FROM Chitietpm c WHERE c.chitietpmPK.maSach = :maSach"),
    @NamedQuery(name = "Chitietpm.findBySoLuongMuon", query = "SELECT c FROM Chitietpm c WHERE c.soLuongMuon = :soLuongMuon"),
    @NamedQuery(name = "Chitietpm.findByTinhTrangKhiMuon", query = "SELECT c FROM Chitietpm c WHERE c.tinhTrangKhiMuon = :tinhTrangKhiMuon")})
public class Chitietpm implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChitietpmPK chitietpmPK;
    @Column(name = "SoLuongMuon")
    private Integer soLuongMuon;
    @Column(name = "TinhTrangKhiMuon")
    private String tinhTrangKhiMuon;
    @JoinColumn(name = "MaPM", referencedColumnName = "MaPM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Phieumuon phieumuon;
    @JoinColumn(name = "MaSach", referencedColumnName = "MaSach", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sach sach;

    public Chitietpm() {
    }

    public Chitietpm(ChitietpmPK chitietpmPK) {
        this.chitietpmPK = chitietpmPK;
    }

    public Chitietpm(int maPM, int maSach) {
        this.chitietpmPK = new ChitietpmPK(maPM, maSach);
    }

    public ChitietpmPK getChitietpmPK() {
        return chitietpmPK;
    }

    public void setChitietpmPK(ChitietpmPK chitietpmPK) {
        this.chitietpmPK = chitietpmPK;
    }

    public Integer getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setSoLuongMuon(Integer soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }

    public String getTinhTrangKhiMuon() {
        return tinhTrangKhiMuon;
    }

    public void setTinhTrangKhiMuon(String tinhTrangKhiMuon) {
        this.tinhTrangKhiMuon = tinhTrangKhiMuon;
    }

    public Phieumuon getPhieumuon() {
        return phieumuon;
    }

    public void setPhieumuon(Phieumuon phieumuon) {
        this.phieumuon = phieumuon;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chitietpmPK != null ? chitietpmPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitietpm)) {
            return false;
        }
        Chitietpm other = (Chitietpm) object;
        if ((this.chitietpmPK == null && other.chitietpmPK != null) || (this.chitietpmPK != null && !this.chitietpmPK.equals(other.chitietpmPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.Chitietpm[ chitietpmPK=" + chitietpmPK + " ]";
    }
    
}
