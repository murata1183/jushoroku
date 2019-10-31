package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_meibo")
@Where(clause = " Determine = 0")
public class List_Entity implements Serializable{

	private static final long serialVersionUID = -870708489937857961L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="No")
	private Long No;

	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;

	@Column(name="number")
	private String number;

	@Column(name="Determine")
	private Long Determine;

	public Long getId() {
        return No;
    }
    public void setId(Long No) {
        this.No = No;
    }


}

