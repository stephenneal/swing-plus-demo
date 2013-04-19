package com.swing.demo;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.plus.mvc.PlusJPanel;

@SuppressWarnings("serial")
public class AddressPanel extends PlusJPanel<AddressModel> {

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
        this.address1Label = newFieldLabel();
        this.address1 = new JTextField();
        this.address2Label = newFieldLabel();
        this.address2 = new JTextField();
        this.postcodeLabel = newFieldLabel();
        this.postcode = new JTextField();
        this.stateLabel = newFieldLabel();
        this.state = new JTextField();
        this.suburbLabel = newFieldLabel();
        this.suburb = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, "address1", this.address1));
        bind(TextBinding.text(model, "address1Label", this.address1Label));
        bind(StateBinding.editable(model, "address1Editable", this.address1));
        bind(TextBinding.text(model, "address2", this.address2));
        bind(TextBinding.text(model, "address2Label", this.address2Label));
        bind(StateBinding.editable(model, "address2Editable", this.address2));
        bind(TextBinding.text(model, "postcode", this.postcode));
        bind(TextBinding.text(model, "postcodeLabel", this.postcodeLabel));
        bind(StateBinding.editable(model, "postcodeEditable", this.postcode));
        bind(TextBinding.text(model, "state", this.state));
        bind(TextBinding.text(model, "stateLabel", this.stateLabel));
        bind(StateBinding.editable(model, "stateEditable", this.state));
        bind(TextBinding.text(model, "suburb", this.suburb));
        bind(TextBinding.text(model, "suburbLabel", this.suburbLabel));
        bind(StateBinding.editable(model, "suburbEditable", this.suburb));

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
        builder.append(this.postcode);
        builder.append(this.stateLabel);
        builder.append(this.state);
    }

}
