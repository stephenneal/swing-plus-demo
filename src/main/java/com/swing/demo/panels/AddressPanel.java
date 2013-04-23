package com.swing.demo.panels;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.ListBinding;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.panels.AddressModel.Properties;
import com.swing.plus.mvc.PlusJPanel;

@SuppressWarnings("serial")
public class AddressPanel extends PlusJPanel<AddressModel> {

    private JLabel address1Label;
    private JTextField address1;
    private JLabel address2Label;
    private JTextField address2;
    private JLabel postcodeLabel;
    // private JTextField postcode;
    private JComboBox postcodes;
    private JLabel stateLabel;
    // private JTextField state;
    private JComboBox states;
    private JLabel suburbLabel;
    private JTextField suburb;

    public AddressPanel(AddressModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.address1Label = newFieldLabel();
        this.address1 = new JTextField();
        this.address2Label = newFieldLabel();
        this.address2 = new JTextField();
        this.postcodeLabel = newFieldLabel();
        // this.postcode = new JTextField();
        this.postcodes = new JComboBox();
        this.stateLabel = newFieldLabel();
        // this.state = new JTextField();
        this.states = new JComboBox();
        this.suburbLabel = newFieldLabel();
        this.suburb = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, Properties.ADDRESS1_LABEL, this.address1Label));
        bind(TextBinding.text(model, Properties.ADDRESS1, this.address1));
        bind(StateBinding.editable(model, Properties.ADDRESS1_EDITABLE, this.address1));

        bind(TextBinding.text(model, Properties.ADDRESS2_LABEL, this.address2Label));
        bind(TextBinding.text(model, Properties.ADDRESS2, this.address2));
        bind(StateBinding.editable(model, Properties.ADDRESS2_EDITABLE, this.address2));

        bind(TextBinding.text(model, Properties.POSTCODE_LABEL, this.postcodeLabel));
        // bind(TextBinding.text(model, Properties.POSTCODE, this.postcode));
        // bind(StateBinding.editable(model, Properties.POSTCODE_EDITABLE, this.postcode));
        bind(ListBinding.model(model, Properties.POSTCODES, this.postcodes));
        bind(ListBinding.selection(model, Properties.POSTCODE, this.postcodes));
        bind(StateBinding.editable(model, Properties.POSTCODE_EDITABLE, this.postcodes));

        bind(TextBinding.text(model, Properties.SUBURB_LABEL, this.suburbLabel));
        bind(TextBinding.text(model, Properties.SUBURB, this.suburb));
        bind(StateBinding.editable(model, Properties.SUBURB_EDITABLE, this.suburb));

        bind(TextBinding.text(model, Properties.STATE_LABEL, this.stateLabel));
        // bind(TextBinding.text(model, Properties.STATE, this.state));
        // bind(StateBinding.editable(model, Properties.STATE_EDITABLE, this.state));
        bind(ListBinding.model(model, Properties.STATES, this.states));
        bind(ListBinding.selection(model, Properties.STATE, this.states));
        bind(StateBinding.editable(model, Properties.STATE_EDITABLE, this.states));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(2, 1, 2),
                        LayoutFactory2.relatedRowSpec(5)), this);
        builder.append(this.address1Label);
        builder.append(this.address1, 5);
        builder.nextLine(2);
        builder.append(this.address2Label);
        builder.append(this.address2, 5);
        builder.nextLine(2);
        builder.append(this.suburbLabel);
        builder.append(this.suburb, 5);
        builder.nextLine(2);
        builder.append(this.postcodeLabel);
        // builder.append(this.postcode);
        builder.append(this.postcodes);
        builder.append(this.stateLabel);
        // builder.append(this.state);
        builder.append(this.states);
    }

}
