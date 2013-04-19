package com.swing.demo.person;

import java.util.Date;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlyParticipant;

/**
 * Presentation model for the {@link PersonPanel}.
 */
public class PersonModel extends DualModePresentationModel {

    private Date dateOfBirth;
    private String id;
    private String firstName;
    private String otherNames;
    private String surname;

    private boolean dateOfBirthEditable;
    private boolean idEditable;
    private boolean firstNameEditable;
    private boolean otherNamesEditable;
    private boolean surnameEditable;
    private String dateOfBirthLabel;
    private String idLabel;
    private String firstNameLabel;
    private String otherNamesLabel;
    private String surnameLabel;

    public PersonModel() {
        super();
        // Set defaults for label values
        this.dateOfBirthLabel = "Date of Birth";
        this.idLabel = "Id";
        this.firstNameLabel = "First name";
        this.otherNamesLabel = "Other name(s)";
        this.surnameLabel = "Surname";
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

    public String getOtherNames() {
        return this.otherNames;
    }

    public void setOtherNames(String newValue) {
        String oldValue = this.otherNames;
        this.otherNames = newValue;
        getPropertyChangeSupport().firePropertyChange("otherNames", oldValue, newValue);
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

    public boolean getDateOfBirthEditable() {
        return this.dateOfBirthEditable;
    }

    @ReadOnlyParticipant
    public void setDateOfBirthEditable(boolean newValue) {
        boolean oldValue = this.dateOfBirthEditable;
        this.dateOfBirthEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("dateOfBirthEditable", oldValue, newValue);
    }

    public boolean getIdEditable() {
        return this.idEditable;
    }

    @ReadOnlyParticipant
    public void setIdEditable(boolean newValue) {
        boolean oldValue = this.idEditable;
        this.idEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("idEditable", oldValue, newValue);
    }

    public boolean getFirstNameEditable() {
        return this.firstNameEditable;
    }

    @ReadOnlyParticipant
    public void setFirstNameEditable(boolean newValue) {
        boolean oldValue = this.firstNameEditable;
        this.firstNameEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("firstNameEditable", oldValue, newValue);
    }

    public boolean getOtherNamesEditable() {
        return this.otherNamesEditable;
    }

    @ReadOnlyParticipant
    public void setOtherNamesEditable(boolean newValue) {
        boolean oldValue = this.otherNamesEditable;
        this.otherNamesEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("otherNamesEditable", oldValue, newValue);
    }

    public boolean getSurnameEditable() {
        return this.surnameEditable;
    }

    @ReadOnlyParticipant
    public void setSurnameEditable(boolean newValue) {
        boolean oldValue = this.surnameEditable;
        this.surnameEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("surnameEditable", oldValue, newValue);
    }

    public String getDateOfBirthLabel() {
        return this.dateOfBirthLabel;
    }

    public void setDateOfBirthLabel(String newValue) {
        String oldValue = this.dateOfBirthLabel;
        this.dateOfBirthLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("dateOfBirthLabel", oldValue, newValue);
    }

    public String getIdLabel() {
        return this.idLabel;
    }

    public void setIdLabel(String newValue) {
        String oldValue = this.idLabel;
        this.idLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("idLabel", oldValue, newValue);
    }

    public String getFirstNameLabel() {
        return this.firstNameLabel;
    }

    public void setFirstNameLabel(String newValue) {
        String oldValue = this.firstNameLabel;
        this.firstNameLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("firstNameLabel", oldValue, newValue);
    }

    public String getOtherNamesLabel() {
        return this.otherNamesLabel;
    }

    public void setOtherNamesLabel(String newValue) {
        String oldValue = this.otherNamesLabel;
        this.otherNamesLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("otherNamesLabel", oldValue, newValue);
    }

    public String getSurnameLabel() {
        return this.surnameLabel;
    }

    public void setSurnameLabel(String newValue) {
        String oldValue = this.surnameLabel;
        this.surnameLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("surnameLabel", oldValue, newValue);
    }

}