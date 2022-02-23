package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import lombok.AllArgsConstructor;
@Entity
@Table(name="PATIENTS")
@Data @NoArgsConstructor  @ToString @AllArgsConstructor

public class Patient {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	
	@Column(name="NOM",length=25)
	@NotNull
	@Size(min=4,max=15)
		private String nom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
		private Date DateNaissnace;
		private boolean malade;
		@DecimalMin("4")
		private int score ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
