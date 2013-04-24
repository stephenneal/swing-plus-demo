package com.swing.demo.panels;

import java.util.Date;

import org.jdesktop.beansbinding.Property;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlyParticipant;

/**
 * Presentation model for the {@link ContactsPanel}.
 */
public class ContactsModel extends DualModePresentationModel {

    /**
     * Defines properties that can be bound on this model.
     */
    public static class Properties extends DualModePresentationModel.Properties {
        public static Property<ContactsModel, String> EMAIL = create("email");
        public static Property<ContactsModel, String> FAX = create("fax");
        public static Property<ContactsModel, String> PHONE_HOME = create("phoneHome");
        public static Property<ContactsModel, String> PHONE_MOBILE = create("phoneMobile");
        public static Property<ContactsModel, String> PHONE_WORK = create("phoneWork");

        public static Property<ContactsModel, Date> EMAIL_LABEL = create("emailLabel");
        public static Property<ContactsModel, String> FAX_LABEL = create("faxLabel");
        public static Property<ContactsModel, String> PHONE_HOME_LABEL = create("phoneHomeLabel");
        public static Property<ContactsModel, String> PHONE_MOBILE_LABEL = create("phoneMobileLabel");
        public static Property<ContactsModel, String> PHONE_WORK_LABEL = create("phoneWorkLabel");

        public static Property<ContactsModel, Boolean> EMAIL_EDITABLE = create("emailEditable");
        public static Property<ContactsModel, Boolean> FAX_EDITABLE = create("faxEditable");
        public static Property<ContactsModel, Boolean> PHONE_HOME_EDITABLE = create("phoneHomeEditable");
        public static Property<ContactsModel, Boolean> PHONE_MOBILE_EDITABLE = create("phoneMobileEditable");
        public static Property<ContactsModel, Boolean> PHONE_WORK_EDITABLE = create("phoneWorkEditable");
    }

    private String email;
    private String fax;
    private String phoneHome;
    private String phoneMobile;
    private String phoneWork;

    private boolean emailEditable;
    private boolean faxEditable;
    private boolean phoneHomeEditable;
    private boolean phoneMobileEditable;
    private boolean phoneWorkEditable;

    private String emailLabel;
    private String faxLabel;
    private String phoneHomeLabel;
    private String phoneMobileLabel;
    private String phoneWorkLabel;

    public ContactsModel() {
        super();
        // Set defaults for label values
        this.emailLabel = "Email";
        this.faxLabel = "Fax";
        this.phoneHomeLabel = "Phone (Home)";
        this.phoneWorkLabel = "Phone (Work)";
        this.phoneMobileLabel = "Phone (Mobile)";
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newValue) {
        String oldValue = this.email;
        this.email = newValue;
        firePropertyChange("email", oldValue, newValue);
    }

    public boolean getEmailEditable() {
        return this.emailEditable;
    }

    @ReadOnlyParticipant
    public void setEmailEditable(boolean newValue) {
        boolean oldValue = this.emailEditable;
        this.emailEditable = newValue;
        firePropertyChange("emailEditable", oldValue, newValue);
    }

    public String getEmailLabel() {
        return this.emailLabel;
    }

    public void setEmailLabel(String newValue) {
        String oldValue = this.emailLabel;
        this.emailLabel = newValue;
        firePropertyChange("emailLabel", oldValue, newValue);
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String newValue) {
        String oldValue = this.fax;
        this.fax = newValue;
        firePropertyChange("fax", oldValue, newValue);
    }

    public boolean getFaxEditable() {
        return this.faxEditable;
    }

    @ReadOnlyParticipant
    public void setFaxEditable(boolean newValue) {
        boolean oldValue = this.faxEditable;
        this.faxEditable = newValue;
        firePropertyChange("faxEditable", oldValue, newValue);
    }

    public String getFaxLabel() {
        return this.faxLabel;
    }

    public void setFaxLabel(String newValue) {
        String oldValue = this.faxLabel;
        this.faxLabel = newValue;
        firePropertyChange("faxLabel", oldValue, newValue);
    }

    public String getPhoneHome() {
        return this.phoneHome;
    }

    public void setPhoneHome(String newValue) {
        String oldValue = this.phoneHome;
        this.phoneHome = newValue;
        firePropertyChange("phoneHome", oldValue, newValue);
    }

    public boolean getPhoneHomeEditable() {
        return this.phoneHomeEditable;
    }

    @ReadOnlyParticipant
    public void setPhoneHomeEditable(boolean newValue) {
        boolean oldValue = this.phoneHomeEditable;
        this.phoneHomeEditable = newValue;
        firePropertyChange("phoneHomeEditable", oldValue, newValue);
    }

    public String getPhoneHomeLabel() {
        return this.phoneHomeLabel;
    }

    public void setPhoneHomeLabel(String newValue) {
        String oldValue = this.phoneHomeLabel;
        this.phoneHomeLabel = newValue;
        firePropertyChange("phoneHomeLabel", oldValue, newValue);
    }

    public String getPhoneMobile() {
        return this.phoneMobile;
    }

    public void setPhoneMobile(String newValue) {
        String oldValue = this.phoneMobile;
        this.phoneMobile = newValue;
        firePropertyChange("phoneMobile", oldValue, newValue);
    }

    public boolean getPhoneMobileEditable() {
        return this.phoneMobileEditable;
    }

    @ReadOnlyParticipant
    public void setPhoneMobileEditable(boolean newValue) {
        boolean oldValue = this.phoneMobileEditable;
        this.phoneMobileEditable = newValue;
        firePropertyChange("phoneMobileEditable", oldValue, newValue);
    }

    public String getPhoneMobileLabel() {
        return this.phoneMobileLabel;
    }

    public void setPhoneMobileLabel(String newValue) {
        String oldValue = this.phoneMobileLabel;
        this.phoneMobileLabel = newValue;
        firePropertyChange("phoneMobileLabel", oldValue, newValue);
    }

    public String getPhoneWork() {
        return this.phoneWork;
    }

    public void setPhoneWork(String newValue) {
        String oldValue = this.phoneWork;
        this.phoneWork = newValue;
        firePropertyChange("phoneWork", oldValue, newValue);
    }

    public boolean getPhoneWorkEditable() {
        return this.phoneWorkEditable;
    }

    @ReadOnlyParticipant
    public void setPhoneWorkEditable(boolean newValue) {
        boolean oldValue = this.phoneWorkEditable;
        this.phoneWorkEditable = newValue;
        firePropertyChange("phoneWorkEditable", oldValue, newValue);
    }

    public String getPhoneWorkLabel() {
        return this.phoneWorkLabel;
    }

    public void setPhoneWorkLabel(String newValue) {
        String oldValue = this.phoneWorkLabel;
        this.phoneWorkLabel = newValue;
        firePropertyChange("phoneWorkLabel", oldValue, newValue);
    }

}