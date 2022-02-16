package com.project.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idResidentialComplexSalesDepartment")
@Table(name = "residential_complexes_sales_departments", schema = "swipe", catalog = "")
public class ResidentialComplexesSalesDepartments {
    private int idResidentialComplexSalesDepartment;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private String eMail;
    private Collection<ResidentialComplexes> residentialComplexesByIdResidentialComplexSalesDepartment;

    public ResidentialComplexesSalesDepartments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_residential_complex_sales_department", nullable = false)
    public int getIdResidentialComplexSalesDepartment() {
        return idResidentialComplexSalesDepartment;
    }

    public void setIdResidentialComplexSalesDepartment(int idResidentialComplexSalesDepartment) {
        this.idResidentialComplexSalesDepartment = idResidentialComplexSalesDepartment;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = false, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, length = 45)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "e_mail", nullable = false, length = 255)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentialComplexesSalesDepartments that = (ResidentialComplexesSalesDepartments) o;
        return idResidentialComplexSalesDepartment == that.idResidentialComplexSalesDepartment && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(eMail, that.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResidentialComplexSalesDepartment, firstName, secondName, phoneNumber, eMail);
    }


    @OneToMany(mappedBy = "residentialComplexesSalesDepartmentsByIdResidentialComplexSalesDepartment")
    public Collection<ResidentialComplexes> getResidentialComplexesByIdResidentialComplexSalesDepartment() {
        return residentialComplexesByIdResidentialComplexSalesDepartment;
    }

    public void setResidentialComplexesByIdResidentialComplexSalesDepartment(Collection<ResidentialComplexes> residentialComplexesByIdResidentialComplexSalesDepartment) {
        this.residentialComplexesByIdResidentialComplexSalesDepartment = residentialComplexesByIdResidentialComplexSalesDepartment;
    }
}
