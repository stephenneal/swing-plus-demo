package com.swing.demo.address;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.swing.binding.bbb.AbstractPanel;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;

@SuppressWarnings("serial")
public class AddressPanel extends AbstractPanel<AddressModel> {

    private JLabel address1Label;
    private JTextField address1;
    private JLabel address2Label;
    private JTextField address2;
    private JLabel postcodeLabel;
    private JTextField postcode;
    private JLabel stateLabel;
    private JTextField state;
    private JLabel suburbLabel;
    private JTextField suburb;

    public AddressPanel(AddressModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.address1Label = new JLabel("Address Line 1");
        this.address1 = new JTextField();
        this.address2Label = new JLabel("Address Line 2");
        this.address2 = new JTextField();
        this.postcodeLabel = new JLabel("Postcode");
        this.postcode = new JTextField();
        this.stateLabel = new JLabel("State");
        this.state = new JTextField();
        this.suburbLabel = new JLabel("Suburb");
        this.suburb = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, "address1", this.address1));
        bind(StateBinding.editable(model, "address1Editable", this.address1));
        bind(TextBinding.text(model, "address2", this.address2));
        bind(StateBinding.editable(model, "address2Editable", this.address2));
        bind(TextBinding.text(model, "postcode", this.postcode));
        bind(StateBinding.editable(model, "postcodeEditable", this.postcode));
        bind(TextBinding.text(model, "state", this.state));
        bind(StateBinding.editable(model, "stateEditable", this.state));
        bind(TextBinding.text(model, "suburb", this.suburb));
        bind(StateBinding.editable(model, "suburbEditable", this.suburb));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(LayoutFactory2.defaultFormLayout(2, 5), this);
        builder.append(this.address1Label);
        builder.append(this.address1);
        builder.nextLine(2);
        builder.append(this.address2Label);
        builder.append(this.address2);
        builder.nextLine(2);
        builder.append(this.suburbLabel);
        builder.append(this.suburb);
        builder.nextLine(2);
        builder.append(this.stateLabel);
        builder.append(this.state);
        builder.nextLine(2);
        builder.append(this.postcodeLabel);
        builder.append(this.postcode);
        // setLayout(LayoutFactory2.defaultFormLayout(1, 5));
        // add(this.address1Label, "1, 1");
        // add(this.address1, "3, 1");
        // add(this.address2Label, "1, 3");
        // add(this.address2, "3, 3");
        // add(this.suburbLabel, "1, 5");
        // add(this.suburb, "3, 5");
        // add(this.stateLabel, "1, 7");
        // add(this.state, "3, 7");
        // add(this.postcodeLabel, "1, 9");
        // add(this.postcode, "3, 9");

        setBorder(Borders.DIALOG);
    }

}
