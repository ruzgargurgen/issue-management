package com.ruzgargurgen.issuemanagement.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

	@Column(name = "crated_At")
	private Date createdAt;
	@Column(name = "crated_by", length = 50)
	private String createdByString;
	@Column(name = "updated_At")
	private Date updatedAtDate;
	@Column(name = "updated_by", length = 50)
	private String updatedByString;
	@Column(name = "status")
	private Boolean status;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedByString() {
		return createdByString;
	}

	public void setCreatedByString(String createdByString) {
		this.createdByString = createdByString;
	}

	public Date getUpdatedAtDate() {
		return updatedAtDate;
	}

	public void setUpdatedAtDate(Date updatedAtDate) {
		this.updatedAtDate = updatedAtDate;
	}

	public String getUpdatedByString() {
		return updatedByString;
	}

	public void setUpdatedByString(String updatedByString) {
		this.updatedByString = updatedByString;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public BaseModel(Date createdAt, String createdByString, Date updatedAtDate, String updatedByString,
			Boolean status) {
		super();
		this.createdAt = createdAt;
		this.createdByString = createdByString;
		this.updatedAtDate = updatedAtDate;
		this.updatedByString = updatedByString;
		this.status = status;
	}

	public BaseModel() {

	}

	@Override
	public String toString() {
		return "BaseModel [createdAt=" + createdAt + ", createdByString=" + createdByString + ", updatedAtDate="
				+ updatedAtDate + ", updatedByString=" + updatedByString + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((createdByString == null) ? 0 : createdByString.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedAtDate == null) ? 0 : updatedAtDate.hashCode());
		result = prime * result + ((updatedByString == null) ? 0 : updatedByString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (createdByString == null) {
			if (other.createdByString != null)
				return false;
		} else if (!createdByString.equals(other.createdByString))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updatedAtDate == null) {
			if (other.updatedAtDate != null)
				return false;
		} else if (!updatedAtDate.equals(other.updatedAtDate))
			return false;
		if (updatedByString == null) {
			if (other.updatedByString != null)
				return false;
		} else if (!updatedByString.equals(other.updatedByString))
			return false;
		return true;
	}

}
