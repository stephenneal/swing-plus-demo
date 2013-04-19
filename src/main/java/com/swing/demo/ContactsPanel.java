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
public class ContactsPanel extends PlusJPanel<ContactsModel> {

    private JLabel emailLabel;
    private JTextField email;
    private JLabel faxLabel;
    private JTextField fax;
    private JLabel phoneMobileLabel;
    private JTextField phoneMobile;
    private JLabel phoneWorkLabel;
    private JTextField phoneWork;
    private JLabel phoneHomeLabel;
    private JTextField phoneHome;

    public ContactsPanel(ContactsModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.emailLabel = newFieldLabel();
        this.email = new JTextField();
        this.faxLabel = newFieldLabel();
        this.fax = new JTextField();
        this.phoneHomeLabel = newFieldLabel();
        this.phoneHome = new JTextField();
        this.phoneWorkLabel = newFieldLabel();
        this.phoneWork = new JTextField();
        this.phoneMobileLabel = newFieldLabel();
        this.phoneMobile = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, "email", this.email));
        bind(TextBinding.text(model, "emailLabel", this.emailLabel));
        bind(StateBinding.editable(model, "emailEditable", this.email));
        bind(TextBinding.text(model, "fax", this.fax));
        bind(TextBinding.text(model, "faxLabel", this.faxLabel));
        bind(StateBinding.editable(model, "faxEditable", this.fax));
        bind(TextBinding.text(model, "phoneHome", this.phoneHome));
        bind(TextBinding.text(model, "phoneHomeLabel", this.phoneHomeLabel));
        bind(StateBinding.editable(model, "phoneHomeEditable", this.phoneHome));
        bind(TextBinding.text(model, "phoneWork", this.phoneWork));
        bind(TextBinding.text(model, "phoneWorkLabel", this.phoneWorkLabel));
        bind(StateBinding.editable(model, "phoneWorkEditable", this.phoneWork));
        bind(TextBinding.text(model, "phoneMobile", this.phoneMobile));
        bind(TextBinding.text(model, "phoneMobileLabel", this.phoneMobileLabel));
        bind(StateBinding.editable(model, "phoneMobileEditable", this.phoneMobile));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(1, 1),
                        LayoutFactory2.relatedRowSpec(5)), this);
        builder.append(this.phoneHomeLabel);
        builder.append(this.phoneHome);
        builder.nextLine(2);
        builder.append(this.phoneWorkLabel);
        builder.append(this.phoneWork);
        builder.nextLine(2);
        builder.append(this.phoneMobileLabel);
        builder.append(this.phoneMobile);
        builder.nextLine(2);
        builder.append(this.faxLabel);
        builder.append(this.fax);
        builder.nextLine(2);
        builder.append(this.emailLabel);
        builder.append(this.email);
    }

}
