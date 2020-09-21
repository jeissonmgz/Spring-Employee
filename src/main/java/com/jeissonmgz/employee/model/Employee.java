/**
 * 
 */
package com.jeissonmgz.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author JMalaver
 *
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "document_type", "document_number" }) })
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "document_type")
    @Enumerated(value = EnumType.STRING)
    private DocumentType documentType;

    @Column(nullable = false, name = "document_number")
    private String documentNumber;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String function;

    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Employee boss;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public DocumentType getDocumentType() {
	return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
	this.documentType = documentType;
    }

    public String getDocumentNumber() {
	return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
	this.documentNumber = documentNumber;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getFunction() {
	return function;
    }

    public void setFunction(String function) {
	this.function = function;
    }

    public Employee getBoss() {
	return boss;
    }

    public void setBoss(Employee boss) {
	this.boss = boss;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ", documentType=" + documentType + ", documentNumber=" + documentNumber
		+ ", name=" + name + ", lastName=" + lastName + ", function=" + function + ", boss=" + boss + "]";
    }

}
