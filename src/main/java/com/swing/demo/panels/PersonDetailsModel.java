package com.swing.demo.panels;

import java.util.Date;
import java.util.List;

import org.jdesktop.beansbinding.Property;
import org.jdesktop.observablecollections.ObservableList;

import com.swing.demo.mvc.DualModePresentationModel;
import com.swing.demo.mvc.ReadOnlySwitch;

/**
 * Presentation model for the {@link PersonDetailsPanel}.
 */
public class PersonDetailsModel extends DualModePresentationModel {

    /**
     * Defines properties that can be bound on this model.
     */
    public static class Properties extends DualModePresentationModel.Properties {
        public static Property<PersonDetailsModel, String> EYE_COLOUR = create("eyeColour");
        public static Property<PersonDetailsModel, List<String>> EYE_COLOURS = create("eyeColours");
        public static Property<PersonDetailsModel, String> GENDER = create("gender");
        public static Property<PersonDetailsModel, List<String>> GENDERS = create("genders");
        public static Property<PersonDetailsModel, String> HEIGHT = create("height");

        public static Property<PersonDetailsModel, String> EYE_COLOUR_LABEL = create("eyeColourLabel");
        public static Property<PersonDetailsModel, String> GENDER_LABEL = create("genderLabel");
        public static Property<PersonDetailsModel, Date> HEIGHT_LABEL = create("heightLabel");

        public static Property<PersonDetailsModel, Boolean> EYE_COLOUR_EDITABLE = create("eyeColourEditable");
        public static Property<PersonDetailsModel, Boolean> EYE_COLOUR_ENABLED = create("eyeColourEnabled");
        public static Property<PersonDetailsModel, Boolean> GENDER_EDITABLE = create("genderEditable");
        public static Property<PersonDetailsModel, Boolean> GENDER_ENABLED = create("genderEnabled");
        public static Property<PersonDetailsModel, Boolean> HEIGHT_EDITABLE = create("heightEditable");
    }

    private String height;
    private String gender;
    private ObservableList<String> genders;
    private String eyeColour;
    private ObservableList<String> eyeColours;

    private boolean heightEditable;
    private boolean genderEnabled;
    private boolean genderEditable;
    private boolean eyeColourEditable;
    private boolean eyeColourEnabled;

    private String heightLabel;
    private String genderLabel;
    private String eyeColourLabel;

    public PersonDetailsModel() {
        super();
        // Set defaults for label values
        this.heightLabel = "Height (cm)";
        this.genderLabel = "Genders";
        this.eyeColourLabel = "Eye Colour";
    }

    public String getEyeColour() {
        return this.eyeColour;
    }

    public void setEyeColour(String newValue) {
        String oldValue = this.eyeColour;
        this.eyeColour = newValue;
        firePropertyChange("eyeColour", oldValue, newValue);
    }

    public boolean getEyeColourEditable() {
        return this.eyeColourEditable;
    }

    @ReadOnlySwitch
    public void setEyeColourEditable(boolean newValue) {
        boolean oldValue = this.eyeColourEditable;
        this.eyeColourEditable = newValue;
        firePropertyChange("eyeColourEditable", oldValue, newValue);
    }

    public boolean getEyeColourEnabled() {
        return this.eyeColourEnabled;
    }

    @ReadOnlySwitch
    public void setEyeColourEnabled(boolean newValue) {
        boolean oldValue = this.eyeColourEnabled;
        this.eyeColourEnabled = newValue;
        firePropertyChange("eyeColourEnabled", oldValue, newValue);
    }

    public String getEyeColourLabel() {
        return this.eyeColourLabel;
    }

    public void setEyeColourLabel(String newValue) {
        String oldValue = this.eyeColourLabel;
        this.eyeColourLabel = newValue;
        firePropertyChange("eyeColourLabel", oldValue, newValue);
    }

    public ObservableList<String> getEyeColours() {
        return this.eyeColours;
    }

    public void setEyeColours(ObservableList<String> newValue) {
        ObservableList<String> oldValue = this.eyeColours;
        this.eyeColours = newValue;
        firePropertyChange("eyeColours", oldValue, newValue);
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String newValue) {
        String oldValue = this.gender;
        this.gender = newValue;
        firePropertyChange("gender", oldValue, newValue);
    }

    public boolean getGenderEditable() {
        return this.genderEditable;
    }

    @ReadOnlySwitch
    public void setGenderEditable(boolean newValue) {
        boolean oldValue = this.genderEditable;
        this.genderEditable = newValue;
        firePropertyChange("genderEditable", oldValue, newValue);
    }

    public boolean getGenderEnabled() {
        return this.genderEnabled;
    }

    @ReadOnlySwitch
    public void setGenderEnabled(boolean newValue) {
        boolean oldValue = this.genderEnabled;
        this.genderEnabled = newValue;
        firePropertyChange("genderEnabled", oldValue, newValue);
    }

    public String getGenderLabel() {
        return this.genderLabel;
    }

    public void setGenderLabel(String newValue) {
        String oldValue = this.genderLabel;
        this.genderLabel = newValue;
        firePropertyChange("genderLabel", oldValue, newValue);
    }

    public ObservableList<String> getGenders() {
        return this.genders;
    }

    public void setGenders(ObservableList<String> newValue) {
        ObservableList<String> oldValue = this.genders;
        this.genders = newValue;
        firePropertyChange("genders", oldValue, newValue);
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String newValue) {
        String oldValue = this.height;
        this.height = newValue;
        firePropertyChange("height", oldValue, newValue);
    }

    public boolean getHeightEditable() {
        return this.heightEditable;
    }

    @ReadOnlySwitch
    public void setHeightEditable(boolean newValue) {
        boolean oldValue = this.heightEditable;
        this.heightEditable = newValue;
        firePropertyChange("heightEditable", oldValue, newValue);
    }

    public String getHeightLabel() {
        return this.heightLabel;
    }

    public void setHeightLabel(String newValue) {
        String oldValue = this.heightLabel;
        this.heightLabel = newValue;
        firePropertyChange("heightLabel", oldValue, newValue);
    }

}