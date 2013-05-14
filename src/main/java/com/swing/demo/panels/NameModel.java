package com.swing.demo.panels;

import org.jdesktop.beansbinding.Property;

import com.swing.plus.mvc.DualModePresentationModel;
import com.swing.plus.mvc.ReadOnlySwitch;

/**
 * Presentation model for the {@link NamePanel}.
 */
public class NameModel extends DualModePresentationModel {

    /**
     * Defines properties that can be bound on this model.
     */
    public static class Properties extends DualModePresentationModel.Properties {
        public static Property<NameModel, String> NAME = create("name");
        public static Property<NameModel, String> NAME_LABEL = create("nameLabel");
        public static Property<NameModel, Boolean> NAME_EDITABLE = create("nameEditable");
    }

    private String name;
    private boolean nameEditable;
    private String nameLabel;

    public NameModel() {
        super();
        // Set defaults for label values
        this.nameLabel = "Name";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newValue) {
        String oldValue = this.name;
        this.name = newValue;
        firePropertyChange("name", oldValue, newValue);
    }

    public boolean getNameEditable() {
        return this.nameEditable;
    }

    @ReadOnlySwitch
    public void setNameEditable(boolean newValue) {
        boolean oldValue = this.nameEditable;
        this.nameEditable = newValue;
        firePropertyChange("nameEditable", oldValue, newValue);
    }

    public String getNameLabel() {
        return this.nameLabel;
    }

    public void setNameLabel(String newValue) {
        String oldValue = this.nameLabel;
        this.nameLabel = newValue;
        firePropertyChange("nameLabel", oldValue, newValue);
    }

}