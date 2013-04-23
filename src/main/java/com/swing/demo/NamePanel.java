package com.swing.demo;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.NameModel.Properties;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.plus.mvc.PlusJPanel;

@SuppressWarnings("serial")
public class NamePanel extends PlusJPanel<NameModel> {

    private JLabel nameLabel;
    private JTextField name;

    public NamePanel(NameModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.nameLabel = newFieldLabel();
        this.name = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, Properties.NAME_LABEL, this.nameLabel));
        bind(TextBinding.text(model, Properties.NAME, this.name));
        bind(StateBinding.editable(model, Properties.NAME_EDITABLE, this.name));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(1, 1),
                        LayoutFactory2.relatedRowSpec(1)), this);
        builder.append(this.nameLabel);
        builder.append(this.name);
    }

}
