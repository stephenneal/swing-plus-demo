package com.swing.demo.person;

import java.util.Date;

import com.swing.binding.bbb.AbstractPanel;
import com.swing.binding.bbb.AbstractPanelModel;

/**
 * Model for the {@link AbstractPanel}.
 */
public class PersonModel extends AbstractPanelModel {

    private Date dateOfBirth;
    private String id;
    private String firstName;
    private String middleNames;
    private String surname;

    private boolean dateOfBirthEditable;
    private boolean idEditable;
    private boolean firstNameEditable;
    private boolean middleNamesEditable;
    private boolean surnameEditable;

    public PersonModel() {
        super();
    }

    // Data properties
    // -----------------------------------------------------------------------------------------------------------------

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newValue) {
        String oldValue = this.firstName;
        this.firstName = newValue;
        getPropertyChangeSupport().firePropertyChange("firstName", oldValue, newValue);
    }

    public String getMiddleNames() {
        return this.middleNames;
    }

    public void setMiddleNames(String newValue) {
        String oldValue = this.middleNames;
        this.middleNames = newValue;
        getPropertyChangeSupport().firePropertyChange("middleNames", oldValue, newValue);
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date newValue) {
        Date oldValue = this.dateOfBirth;
        this.dateOfBirth = newValue;
        getPropertyChangeSupport().firePropertyChange("dateOfBirth", oldValue, newValue);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String newValue) {
        String oldValue = this.id;
        this.id = newValue;
        getPropertyChangeSupport().firePropertyChange("id", oldValue, newValue);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String newValue) {
        String oldValue = this.surname;
        this.surname = newValue;
        getPropertyChangeSupport().firePropertyChange("surname", oldValue, newValue);
    }

    // State properties
    // -----------------------------------------------------------------------------------------------------------------

    public boolean getFirstNameEditable() {
        return this.firstNameEditable;
    }

    public void setFirstNameEditable(boolean newValue) {
        boolean oldValue = this.firstNameEditable;
        this.firstNameEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("firstNameEditable", oldValue, newValue);
    }

    public boolean getMiddleNamesEditable() {
        return this.middleNamesEditable;
    }

    public void setMiddleNamesEditable(boolean newValue) {
        boolean oldValue = this.middleNamesEditable;
        this.middleNamesEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("middleNamesEditable", oldValue, newValue);
    }

    public boolean getSurnameEditable() {
        return this.surnameEditable;
    }

    public void setSurnameEditable(boolean newValue) {
        boolean oldValue = this.surnameEditable;
        this.surnameEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("surnameEditable", oldValue, newValue);
    }

    public boolean getDateOfBirthEditable() {
        return this.dateOfBirthEditable;
    }

    public void setDateOfBirthEditable(boolean newValue) {
        boolean oldValue = this.dateOfBirthEditable;
        this.dateOfBirthEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("dateOfBirthEditable", oldValue, newValue);
    }

    public boolean getIdEditable() {
        return this.idEditable;
    }

    public void setIdEditable(boolean newValue) {
        boolean oldValue = this.idEditable;
        this.idEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("idEditable", oldValue, newValue);
    }
}