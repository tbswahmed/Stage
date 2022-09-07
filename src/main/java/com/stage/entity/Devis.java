package com.stage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Devis implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long idDevis;
	String Description;
	long Quantite;
	@Temporal(TemporalType.DATE)
	Date dateDevis = new Date(System.currentTimeMillis());
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long numDevis;
	boolean confirmerDevis;
	
	@JsonIgnore
	@ManyToOne
	Article artciles ;
	
	
}
