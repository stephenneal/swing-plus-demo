package com.swing.demo.panels;

import java.util.Date;
import java.util.List;

import org.jdesktop.beansbinding.Property;
import org.jdesktop.observablecollections.ObservableList;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlySwitch;

/**
 * Presentation model for the {@link AddressPanel}.
 */
public class AddressModel extends DualModePresentationModel {

    /**
     * Defines properties that can be bound on this model.
     */
    public static class Properties extends DualModePresentationModel.Properties {
        public static Property<AddressModel, String> ADDRESS1 = create("address1");
        public static Property<AddressModel, String> ADDRESS2 = create("address2");
        public static Property<AddressModel, String> POSTCODE = create("postcode");
        public static Property<AddressModel, List<String>> POSTCODES = create("postcodes");
        public static Property<AddressModel, String> STATE = create("state");
        public static Property<AddressModel, List<String>> STATES = create("states");
        public static Property<AddressModel, String> SUBURB = create("suburb");
        public static Property<AddressModel, List<String>> SUBURBS = create("suburbs");

        public static Property<AddressModel, Date> ADDRESS1_LABEL = create("address1Label");
        public static Property<AddressModel, String> ADDRESS2_LABEL = create("address2Label");
        public static Property<AddressModel, String> POSTCODE_LABEL = create("postcodeLabel");
        public static Property<AddressModel, String> STATE_LABEL = create("stateLabel");
        public static Property<AddressModel, String> SUBURB_LABEL = create("suburbLabel");

        public static Property<AddressModel, Boolean> ADDRESS1_EDITABLE = create("address1Editable");
        public static Property<AddressModel, Boolean> ADDRESS2_EDITABLE = create("address2Editable");
        public static Property<AddressModel, Boolean> POSTCODE_EDITABLE = create("postcodeEditable");
        public static Property<AddressModel, Boolean> POSTCODE_ENABLED = create("postcodeEnabled");
        public static Property<AddressModel, Boolean> STATE_EDITABLE = create("stateEditable");
        public static Property<AddressModel, Boolean> STATE_ENABLED = create("stateEnabled");
        public static Property<AddressModel, Boolean> SUBURB_EDITABLE = create("suburbEditable");
        public static Property<AddressModel, Boolean> SUBURB_ENABLED = create("suburbEnabled");
    }

    private String address1;
    private String address2;
    private String postcode;
    private ObservableList<String> postcodes;
    private String state;
    private ObservableList<String> states;
    private String suburb;
    private ObservableList<String> suburbs;

    private boolean address1Editable;
    private boolean address2Editable;
    private boolean postcodeEditable;
    private boolean postcodeEnabled;
    private boolean stateEditable;
    private boolean stateEnabled;
    private boolean suburbEditable;
    private boolean suburbEnabled;

    private String address1Label;
    private String address2Label;
    private String postcodeLabel;
    private String stateLabel;
    private String suburbLabel;

    public AddressModel() {
        super();
        // Set defaults for label values
        this.address1Label = "Address Line 1";
        this.address2Label = "Address Line 2";
        this.postcodeLabel = "Postcode";
        this.stateLabel = "State";
        this.suburbLabel = "Suburb";
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String newValue) {
        String oldValue = this.address1;
        this.address1 = newValue;
        firePropertyChange("address1", oldValue, newValue);
    }

    public boolean getAddress1Editable() {
        return this.address1Editable;
    }

    @ReadOnlySwitch
    public void setAddress1Editable(boolean newValue) {
        boolean oldValue = this.address1Editable;
        this.address1Editable = newValue;
        firePropertyChange("address1Editable", oldValue, newValue);
    }

    public String getAddress1Label() {
        return this.address1Label;
    }

    public void setAddress1Label(String newValue) {
        String oldValue = this.address1Label;
        this.address1Label = newValue;
        firePropertyChange("address1Label", oldValue, newValue);
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String newValue) {
        String oldValue = this.address2;
        this.address2 = newValue;
        firePropertyChange("address2", oldValue, newValue);
    }

    public boolean getAddress2Editable() {
        return this.address2Editable;
    }

    @ReadOnlySwitch
    public void setAddress2Editable(boolean newValue) {
        boolean oldValue = this.address2Editable;
        this.address2Editable = newValue;
        firePropertyChange("address2Editable", oldValue, newValue);
    }

    public String getAddress2Label() {
        return this.address2Label;
    }

    public void setAddress2Label(String newValue) {
        String oldValue = this.address2Label;
        this.address2Label = newValue;
        firePropertyChange("address2Label", oldValue, newValue);
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String newValue) {
        String oldValue = this.postcode;
        this.postcode = newValue;
        firePropertyChange("postcode", oldValue, newValue);
    }

    public boolean getPostcodeEditable() {
        return this.postcodeEditable;
    }

    @ReadOnlySwitch
    public void setPostcodeEditable(boolean newValue) {
        boolean oldValue = this.postcodeEditable;
        this.postcodeEditable = newValue;
        firePropertyChange("postcodeEditable", oldValue, newValue);
    }

    public boolean getPostcodeEnabled() {
        return this.postcodeEnabled;
    }

    @ReadOnlySwitch
    public void setPostcodeEnabled(boolean newValue) {
        boolean oldValue = this.postcodeEnabled;
        this.postcodeEnabled = newValue;
        firePropertyChange("postcodeEnabled", oldValue, newValue);
    }

    public String getPostcodeLabel() {
        return this.postcodeLabel;
    }

    public void setPostcodeLabel(String newValue) {
        String oldValue = this.postcodeLabel;
        this.postcodeLabel = newValue;
        firePropertyChange("postcodeLabel", oldValue, newValue);
    }

    public ObservableList<String> getPostcodes() {
        return this.postcodes;
    }

    public void setPostcodes(ObservableList<String> newValue) {
        ObservableList<String> oldValue = this.postcodes;
        this.postcodes = newValue;
        firePropertyChange("postcodes", oldValue, newValue);
    }

    public String getState() {
        return this.state;
    }

    public void setState(String newValue) {
        String oldValue = this.state;
        this.state = newValue;
        firePropertyChange("state", oldValue, newValue);
    }

    public boolean getStateEditable() {
        return this.stateEditable;
    }

    @ReadOnlySwitch
    public void setStateEditable(boolean newValue) {
        boolean oldValue = this.stateEditable;
        this.stateEditable = newValue;
        firePropertyChange("stateEditable", oldValue, newValue);
    }

    public boolean getStateEnabled() {
        return this.stateEnabled;
    }

    @ReadOnlySwitch
    public void setStateEnabled(boolean newValue) {
        boolean oldValue = this.stateEnabled;
        this.stateEnabled = newValue;
        firePropertyChange("stateEnabled", oldValue, newValue);
    }

    public String getStateLabel() {
        return this.stateLabel;
    }

    public void setStateLabel(String newValue) {
        String oldValue = this.stateLabel;
        this.stateLabel = newValue;
        firePropertyChange("stateLabel", oldValue, newValue);
    }

    public ObservableList<String> getStates() {
        return this.states;
    }

    public void setStates(ObservableList<String> newValue) {
        ObservableList<String> oldValue = this.states;
        this.states = newValue;
        firePropertyChange("states", oldValue, newValue);
    }

    public String getSuburb() {
        return this.suburb;
    }

    public void setSuburb(String newValue) {
        String oldValue = this.suburb;
        this.suburb = newValue;
        firePropertyChange("suburb", oldValue, newValue);
    }

    public boolean getSuburbEditable() {
        return this.suburbEditable;
    }

    @ReadOnlySwitch
    public void setSuburbEditable(boolean newValue) {
        boolean oldValue = this.suburbEditable;
        this.suburbEditable = newValue;
        firePropertyChange("suburbEditable", oldValue, newValue);
    }

    public boolean getSuburbEnabled() {
        return this.suburbEnabled;
    }

    @ReadOnlySwitch
    public void setSuburbEnabled(boolean newValue) {
        boolean oldValue = this.suburbEnabled;
        this.suburbEnabled = newValue;
        firePropertyChange("suburbEnabled", oldValue, newValue);
    }

    public String getSuburbLabel() {
        return this.suburbLabel;
    }

    public void setSuburbLabel(String newValue) {
        String oldValue = this.suburbLabel;
        this.suburbLabel = newValue;
        firePropertyChange("suburbLabel", oldValue, newValue);
    }

    public ObservableList<String> getSuburbs() {
        return this.suburbs;
    }

    public void setSuburbs(ObservableList<String> newValue) {
        ObservableList<String> oldValue = this.suburbs;
        this.suburbs = newValue;
        firePropertyChange("suburbs", oldValue, newValue);
    }

}