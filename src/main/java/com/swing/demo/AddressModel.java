package com.swing.demo;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlyParticipant;

/**
 * Presentation model for the {@link AddressPanel}.
 */
public class AddressModel extends DualModePresentationModel {

    private String address1;
    private String address2;
    private String postcode;
    private String suburb;
    private String state;

    private boolean address1Editable;
    private boolean address2Editable;
    private boolean postcodeEditable;
    private boolean suburbEditable;
    private boolean stateEditable;

    private String address1Label;
    private String address2Label;
    private String postcodeLabel;
    private String suburbLabel;
    private String stateLabel;

    public AddressModel() {
        super();
        // Set defaults for label values
        this.address1Label = "Address Line 1";
        this.address2Label = "Address Line 2";
        this.postcodeLabel = "Postcode";
        this.suburbLabel = "Suburb";
        this.stateLabel = "State";
    }

    // Data properties
    // -----------------------------------------------------------------------------------------------------------------

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String newValue) {
        String oldValue = this.address1;
        this.address1 = newValue;
        getPropertyChangeSupport().firePropertyChange("address1", oldValue, newValue);
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String newValue) {
        String oldValue = this.address2;
        this.address2 = newValue;
        getPropertyChangeSupport().firePropertyChange("address2", oldValue, newValue);
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String newValue) {
        String oldValue = this.postcode;
        this.postcode = newValue;
        getPropertyChangeSupport().firePropertyChange("postcode", oldValue, newValue);
    }

    public String getSuburb() {
        return this.suburb;
    }

    public void setSuburb(String newValue) {
        String oldValue = this.suburb;
        this.suburb = newValue;
        getPropertyChangeSupport().firePropertyChange("suburb", oldValue, newValue);
    }

    public String getState() {
        return this.state;
    }

    public void setState(String newValue) {
        String oldValue = this.state;
        this.state = newValue;
        getPropertyChangeSupport().firePropertyChange("state", oldValue, newValue);
    }

    // State properties
    // -----------------------------------------------------------------------------------------------------------------

    public boolean getAddress1Editable() {
        return this.address1Editable;
    }

    @ReadOnlyParticipant
    public void setAddress1Editable(boolean newValue) {
        boolean oldValue = this.address1Editable;
        this.address1Editable = newValue;
        getPropertyChangeSupport().firePropertyChange("address1Editable", oldValue, newValue);
    }

    public boolean getAddress2Editable() {
        return this.address2Editable;
    }

    @ReadOnlyParticipant
    public void setAddress2Editable(boolean newValue) {
        boolean oldValue = this.address2Editable;
        this.address2Editable = newValue;
        getPropertyChangeSupport().firePropertyChange("address2Editable", oldValue, newValue);
    }

    public boolean getPostcodeEditable() {
        return this.postcodeEditable;
    }

    @ReadOnlyParticipant
    public void setPostcodeEditable(boolean newValue) {
        boolean oldValue = this.postcodeEditable;
        this.postcodeEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("postcodeEditable", oldValue, newValue);
    }

    public boolean getSuburbEditable() {
        return this.suburbEditable;
    }

    @ReadOnlyParticipant
    public void setSuburbEditable(boolean newValue) {
        boolean oldValue = this.suburbEditable;
        this.suburbEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("suburbEditable", oldValue, newValue);
    }

    public boolean getStateEditable() {
        return this.stateEditable;
    }

    @ReadOnlyParticipant
    public void setStateEditable(boolean newValue) {
        boolean oldValue = this.stateEditable;
        this.stateEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("stateEditable", oldValue, newValue);
    }

    public String getAddress1Label() {
        return this.address1Label;
    }

    public void setAddress1Label(String newValue) {
        String oldValue = this.address1Label;
        this.address1Label = newValue;
        getPropertyChangeSupport().firePropertyChange("address1Label", oldValue, newValue);
    }

    public String getAddress2Label() {
        return this.address2Label;
    }

    public void setAddress2Label(String newValue) {
        String oldValue = this.address2Label;
        this.address2Label = newValue;
        getPropertyChangeSupport().firePropertyChange("address2Label", oldValue, newValue);
    }

    public String getPostcodeLabel() {
        return this.postcodeLabel;
    }

    public void setPostcodeLabel(String newValue) {
        String oldValue = this.postcodeLabel;
        this.postcodeLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("postcodeLabel", oldValue, newValue);
    }

    public String getSuburbLabel() {
        return this.suburbLabel;
    }

    public void setSuburbLabel(String newValue) {
        String oldValue = this.suburbLabel;
        this.suburbLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("suburbLabel", oldValue, newValue);
    }

    public String getStateLabel() {
        return this.stateLabel;
    }

    public void setStateLabel(String newValue) {
        String oldValue = this.stateLabel;
        this.stateLabel = newValue;
        getPropertyChangeSupport().firePropertyChange("stateLabel", oldValue, newValue);
    }

}