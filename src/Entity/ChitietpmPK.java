/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author X.Phuong
 */
@Embeddable
public class ChitietpmPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MaPM")
    private int maPM;
    @Basic(optional = false)
    @Column(name = "MaSach")
    private int maSach;

    public ChitietpmPK() {
    }

    public ChitietpmPK(int maPM, int maSach) {
        this.maPM = maPM;
        this.maSach = maSach;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) maPM;
        hash += (int) maSach;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChitietpmPK)) {
            return false;
        }
        ChitietpmPK other = (ChitietpmPK) object;
        if (this.maPM != other.maPM) {
            return false;
        }
        if (this.maSach != other.maSach) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qlthuvien.ChitietpmPK[ maPM=" + maPM + ", maSach=" + maSach + " ]";
    }
    
}
