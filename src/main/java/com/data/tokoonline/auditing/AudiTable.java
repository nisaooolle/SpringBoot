package com.data.tokoonline.auditing;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AudiTable {
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss") // untuk membuat otomatis tgl pembuatan
    @CreationTimestamp // otomatis memunculkan tgl saat post
    @Column(name = "created_at",updatable = false)
    private Date createAt;

    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss") // untuk membuat otomatis tgl pembuatan
    @LastModifiedDate // otomatis mengganti tgl & waktu saat diupdate
    @Column(name = "updated_at")
    private Date updatedAt;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
