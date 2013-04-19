package com.swing.demo.address;

import com.swing.binding.bbb.AbstractPanel;
import com.swing.binding.bbb.AbstractPanelModel;

/**
 * Model for the {@link AbstractPanel}.
 */
public class AddressModel extends AbstractPanelModel {

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

    public AddressModel() {
        super();
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

    public void setAddress1Editable(boolean newValue) {
        boolean oldValue = this.address1Editable;
        this.address1Editable = newValue;
        getPropertyChangeSupport().firePropertyChange("address1Editable", oldValue, newValue);
    }

    public boolean getAddress2Editable() {
        return this.address2Editable;
    }

    public void setAddress2Editable(boolean newValue) {
        boolean oldValue = this.address2Editable;
        this.address2Editable = newValue;
        getPropertyChangeSupport().firePropertyChange("address2Editable", oldValue, newValue);
    }

    public boolean getPostcodeEditable() {
        return this.postcodeEditable;
    }

    public void setPostcodeEditable(boolean newValue) {
        boolean oldValue = this.postcodeEditable;
        this.postcodeEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("postcodeEditable", oldValue, newValue);
    }

    public boolean getSuburbEditable() {
        return this.suburbEditable;
    }

    public void setSuburbEditable(boolean newValue) {
        boolean oldValue = this.suburbEditable;
        this.suburbEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("suburbEditable", oldValue, newValue);
    }

    public boolean getStateEditable() {
        return this.stateEditable;
    }

    public void setStateEditable(boolean newValue) {
        boolean oldValue = this.stateEditable;
        this.stateEditable = newValue;
        getPropertyChangeSupport().firePropertyChange("stateEditable", oldValue, newValue);
    }

}