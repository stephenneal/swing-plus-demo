package com.swing.demo.panels;

import java.util.Date;

import org.jdesktop.beansbinding.Property;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlyParticipant;

/**
 * Presentation model for the {@link PersonPanel}.
 */
public class PersonModel extends DualModePresentationModel {

    /**
     * Defines properties that can be bound on this model.
     */
    public static class Properties extends DualModePresentationModel.Properties {
        public static Property<PersonModel, Date> DATE_OF_BIRTH = create("dateOfBirth");
        public static Property<PersonModel, Date> DATE_DECEASED = create("dateDeceased");
        public static Property<PersonModel, String> FIRST_NAME = create("firstName");
        public static Property<PersonModel, String> ID = create("id");
        public static Property<PersonModel, String> OTHER_NAMES = create("otherNames");
        public static Property<PersonModel, String> SURNAME = create("surname");

        public static Property<PersonModel, Date> DATE_OF_BIRTH_LABEL = create("dateOfBirthLabel");
        public static Property<PersonModel, Date> DATE_DECEASED_LABEL = create("dateDeceasedLabel");
        public static Property<PersonModel, String> FIRST_NAME_LABEL = create("firstNameLabel");
        public static Property<PersonModel, String> ID_LABEL = create("idLabel");
        public static Property<PersonModel, String> OTHER_NAMES_LABEL = create("otherNamesLabel");
        public static Property<PersonModel, String> SURNAME_LABEL = create("surnameLabel");

        public static Property<PersonModel, Boolean> DATE_OF_BIRTH_EDITABLE = create("dateOfBirthEditable");
        public static Property<PersonModel, Boolean> DATE_DECEASED_EDITABLE = create("dateDeceasedEditable");
        public static Property<PersonModel, Boolean> FIRST_NAME_EDITABLE = create("firstNameEditable");
        public static Property<PersonModel, Boolean> ID_EDITABLE = create("idEditable");
        public static Property<PersonModel, Boolean> OTHER_NAMES_EDITABLE = create("otherNamesEditable");
        public static Property<PersonModel, Boolean> SURNAME_EDITABLE = create("surnameEditable");
    }

    private Date dateOfBirth;
    private Date dateDeceased;
    private String firstName;
    private String id;
    private String otherNames;
    private String surname;

    private boolean dateOfBirthEditable;
    private boolean dateDeceasedEditable;
    private boolean firstNameEditable;
    private boolean idEditable;
    private boolean otherNamesEditable;
    private boolean surnameEditable;

    private String dateOfBirthLabel;
    private String dateDeceasedLabel;
    private String firstNameLabel;
    private String idLabel;
    private String otherNamesLabel;
    private String surnameLabel;

    public PersonModel() {
        super();
        // Set defaults for label values
        this.dateOfBirthLabel = "Date of Birth";
        this.dateDeceasedLabel = "Date Deceased";
        this.firstNameLabel = "First name";
        this.idLabel = "Id";
        this.otherNamesLabel = "Other name(s)";
        this.surnameLabel = "Surname";
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date newValue) {
        Date oldValue = this.dateOfBirth;
        this.dateOfBirth = newValue;
        firePropertyChange("dateOfBirth", oldValue, newValue);
    }

    public boolean getDateOfBirthEditable() {
        return this.dateOfBirthEditable;
    }

    @ReadOnlyParticipant
    public void setDateOfBirthEditable(boolean newValue) {
        boolean oldValue = this.dateOfBirthEditable;
        this.dateOfBirthEditable = newValue;
        firePropertyChange("dateOfBirthEditable", oldValue, newValue);
    }

    public String getDateOfBirthLabel() {
        return this.dateOfBirthLabel;
    }

    public void setDateOfBirthLabel(String newValue) {
        String oldValue = this.dateOfBirthLabel;
        this.dateOfBirthLabel = newValue;
        firePropertyChange("dateOfBirthLabel", oldValue, newValue);
    }

    public Date getDateDeceased() {
        return this.dateDeceased;
    }

    public void setDateDeceased(Date newValue) {
        Date oldValue = this.dateDeceased;
        this.dateDeceased = newValue;
        firePropertyChange("dateDeceased", oldValue, newValue);
    }

    public boolean getDateDeceasedEditable() {
        return this.dateDeceasedEditable;
    }

    @ReadOnlyParticipant
    public void setDateDeceasedEditable(boolean newValue) {
        boolean oldValue = this.dateDeceasedEditable;
        this.dateDeceasedEditable = newValue;
        firePropertyChange("dateDeceasedEditable", oldValue, newValue);
    }

    public String getDateDeceasedLabel() {
        return this.dateDeceasedLabel;
    }

    public void setDateDeceasedLabel(String newValue) {
        String oldValue = this.dateDeceasedLabel;
        this.dateDeceasedLabel = newValue;
        firePropertyChange("dateDeceasedLabel", oldValue, newValue);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String newValue) {
        String oldValue = this.firstName;
        this.firstName = newValue;
        firePropertyChange("firstName", oldValue, newValue);
    }

    public boolean getFirstNameEditable() {
        return this.firstNameEditable;
    }

    @ReadOnlyParticipant
    public void setFirstNameEditable(boolean newValue) {
        boolean oldValue = this.firstNameEditable;
        this.firstNameEditable = newValue;
        firePropertyChange("firstNameEditable", oldValue, newValue);
    }

    public String getFirstNameLabel() {
        return this.firstNameLabel;
    }

    public void setFirstNameLabel(String newValue) {
        String oldValue = this.firstNameLabel;
        this.firstNameLabel = newValue;
        firePropertyChange("firstNameLabel", oldValue, newValue);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String newValue) {
        String oldValue = this.id;
        this.id = newValue;
        firePropertyChange("id", oldValue, newValue);
    }

    public boolean getIdEditable() {
        return this.idEditable;
    }

    @ReadOnlyParticipant
    public void setIdEditable(boolean newValue) {
        boolean oldValue = this.idEditable;
        this.idEditable = newValue;
        firePropertyChange("idEditable", oldValue, newValue);
    }

    public String getIdLabel() {
        return this.idLabel;
    }

    public void setIdLabel(String newValue) {
        String oldValue = this.idLabel;
        this.idLabel = newValue;
        firePropertyChange("idLabel", oldValue, newValue);
    }

    public String getOtherNames() {
        return this.otherNames;
    }

    public void setOtherNames(String newValue) {
        String oldValue = this.otherNames;
        this.otherNames = newValue;
        firePropertyChange("otherNames", oldValue, newValue);
    }

    public boolean getOtherNamesEditable() {
        return this.otherNamesEditable;
    }

    @ReadOnlyParticipant
    public void setOtherNamesEditable(boolean newValue) {
        boolean oldValue = this.otherNamesEditable;
        this.otherNamesEditable = newValue;
        firePropertyChange("otherNamesEditable", oldValue, newValue);
    }

    public String getOtherNamesLabel() {
        return this.otherNamesLabel;
    }

    public void setOtherNamesLabel(String newValue) {
        String oldValue = this.otherNamesLabel;
        this.otherNamesLabel = newValue;
        firePropertyChange("otherNamesLabel", oldValue, newValue);
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String newValue) {
        String oldValue = this.surname;
        this.surname = newValue;
        firePropertyChange("surname", oldValue, newValue);
    }

    public boolean getSurnameEditable() {
        return this.surnameEditable;
    }

    @ReadOnlyParticipant
    public void setSurnameEditable(boolean newValue) {
        boolean oldValue = this.surnameEditable;
        this.surnameEditable = newValue;
        firePropertyChange("surnameEditable", oldValue, newValue);
    }

    public String getSurnameLabel() {
        return this.surnameLabel;
    }

    public void setSurnameLabel(String newValue) {
        String oldValue = this.surnameLabel;
        this.surnameLabel = newValue;
        firePropertyChange("surnameLabel", oldValue, newValue);
    }

}