package com.swing.demo;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlyParticipant;

/**
 * Presentation model for the {@link ContactsPanel}.
 */
public class ContactsModel extends DualModePresentationModel {

    private String email;
    private String fax;
    private String phoneHome;
    private String phoneWork;
    private String phoneMobile;

    private boolean emailEditable;
    private boolean faxEditable;
    private boolean phoneHomeEditable;
    private boolean phoneWorkEditable;
    private boolean phoneMobileEditable;
    private String emailLabel;
    private String faxLabel;
    private String phoneHomeLabel;
    private String phoneWorkLabel;
    private String phoneMobileLabel;

    public ContactsModel() {
        super();
        // Set defaults for label values
        this.emailLabel = "Email";
        this.faxLabel = "Fax";
        this.phoneHomeLabel = "Phone (Home)";
        this.phoneWorkLabel = "Phone (Work)";
        this.phoneMobileLabel = "Phone (Mobile)";
    }

    // Data properties
    // -----------------------------------------------------------------------------------------------------------------

    public String getPhoneHome() {
        return this.phoneHome;
    }

    public void setPhoneHome(String newValue) {
        String oldValue = this.phoneHome;
        this.phoneHome = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneHome", oldValue, newValue);
    }

    public String getPhoneWork() {
        return this.phoneWork;
    }

    public void setPhoneWork(String newValue) {
        String oldValue = this.phoneWork;
        this.phoneWork = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneWork", oldValue, newValue);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newValue) {
        String oldValue = this.email;
        this.email = newValue;
        getPropertyChangeSupport().firePropertyChange("email", oldValue, newValue);
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String newValue) {
        String oldValue = this.fax;
        this.fax = newValue;
        getPropertyChangeSupport().firePropertyChange("fax", oldValue, newValue);
    }

    public String getPhoneMobile() {
        return this.phoneMobile;
    }

    public void setPhoneMobile(String newValue) {
        String oldValue = this.phoneMobile;
        this.phoneMobile = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneMobile", oldValue, newValue);
    }

    // State properties
    // -----------------------------------------------------------------------------------------------------------------

    public boolean getEmailEditable() {
        return this.emailEditable;
    }

    @ReadOnlyParticipant
    public void setEmailEditable(boolean newValue) {
        boolean oldValue = this.emailEditable;
        this.emailEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("emailEditable", oldValue, newValue);
    }

    public boolean getFaxEditable() {
        return this.faxEditable;
    }

    @ReadOnlyParticipant
    public void setFaxEditable(boolean newValue) {
        boolean oldValue = this.faxEditable;
        this.faxEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("faxEditable", oldValue, newValue);
    }

    public boolean getPhoneHomeEditable() {
        return this.phoneHomeEditable;
    }

    @ReadOnlyParticipant
    public void setPhoneHomeEditable(boolean newValue) {
        boolean oldValue = this.phoneHomeEditable;
        this.phoneHomeEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneHomeEditable", oldValue, newValue);
    }

    public boolean getPhoneWorkEditable() {
        return this.phoneWorkEditable;
    }

    @ReadOnlyParticipant
    public void setPhoneWorkEditable(boolean newValue) {
        boolean oldValue = this.phoneWorkEditable;
        this.phoneWorkEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneWorkEditable", oldValue, newValue);
    }

    public boolean getPhoneMobileEditable() {
        return this.phoneMobileEditable;
    }

    @ReadOnlyParticipant
    public void setPhoneMobileEditable(boolean newValue) {
        boolean oldValue = this.phoneMobileEditable;
        this.phoneMobileEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneMobileEditable", oldValue, newValue);
    }

    public String getEmailLabel() {
        return this.emailLabel;
    }

    public void setEmailLabel(String newValue) {
        String oldValue = this.emailLabel;
        this.emailLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("emailLabel", oldValue, newValue);
    }

    public String getFaxLabel() {
        return this.faxLabel;
    }

    public void setFaxLabel(String newValue) {
        String oldValue = this.faxLabel;
        this.faxLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("faxLabel", oldValue, newValue);
    }

    public String getPhoneHomeLabel() {
        return this.phoneHomeLabel;
    }

    public void setPhoneHomeLabel(String newValue) {
        String oldValue = this.phoneHomeLabel;
        this.phoneHomeLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneHomeLabel", oldValue, newValue);
    }

    public String getPhoneWorkLabel() {
        return this.phoneWorkLabel;
    }

    public void setPhoneWorkLabel(String newValue) {
        String oldValue = this.phoneWorkLabel;
        this.phoneWorkLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneWorkLabel", oldValue, newValue);
    }

    public String getPhoneMobileLabel() {
        return this.phoneMobileLabel;
    }

    public void setPhoneMobileLabel(String newValue) {
        String oldValue = this.phoneMobileLabel;
        this.phoneMobileLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("phoneMobileLabel", oldValue, newValue);
    }

}