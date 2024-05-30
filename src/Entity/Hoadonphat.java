/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author X.Phuong
 */
@Entity
@Table(name = "hoadonphat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadonphat.findAll", query = "SELECT h FROM Hoadonphat h"),
    @NamedQuery(name = "Hoadonphat.findBySoHoaDon", query = "SELECT h FROM Hoadonphat h WHERE h.soHoaDon = :soHoaDon"),
    @NamedQuery(name = "Hoadonphat.findByTienphat", query = "SELECT h FROM Hoadonphat h WHERE h.tienphat = :tienphat"),
    @NamedQuery(name = "Hoadonphat.findByNgayPhat", query = "SELECT h FROM Hoadonphat h WHERE h.ngayPhat = :ngayPhat")})
public class Hoadonphat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SoHoaDon")
    private Integer soHoaDon;
    @Column(name = "Tienphat")
    private Integer tienphat;
    @Lob
    @Column(name = "LyDo")
    private String lyDo;
    @Column(name = "NgayPhat")
    @Temporal(TemporalType.DATE)
    private Date ngayPhat;
    @JoinColumn(name = "MaDG", referencedColumnName = "MaDG")
    @ManyToOne
    private Docgia maDG;
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne
    private Nhanvien maNV;

    public Hoadonphat() {
    }

    public Hoadonphat(Integer soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Integer getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(Integer soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Integer getTienphat() {
        return tienphat;
    }

    public void setTienphat(Integer tienphat) {
        this.tienphat = tienphat;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Date getNgayPhat() {
        return ngayPhat;
    }

    public void setNgayPhat(Date ngayPhat) {
        this.ngayPhat = ngayPhat;
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
        hash += (soHoaDon != null ? soHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadonphat)) {
            return false;
        }
        Hoadonphat other = (Hoadonphat) object;
        if ((this.soHoaDon == null && other.soHoaDon != null) || (this.soHoaDon != null && !this.soHoaDon.equals(other.soHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.Hoadonphat[ soHoaDon=" + soHoaDon + " ]";
    }
    
}
