package com.swing.demo.panels;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.panels.ContactsModel.Properties;
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
        bind(TextBinding.text(model, Properties.EMAIL_LABEL, this.emailLabel));
        bind(TextBinding.text(model, Properties.EMAIL, this.email));
        bind(StateBinding.editable(model, Properties.EMAIL_EDITABLE, this.email));

        bind(TextBinding.text(model, Properties.FAX_LABEL, this.faxLabel));
        bind(TextBinding.text(model, Properties.FAX, this.fax));
        bind(StateBinding.editable(model, Properties.FAX_EDITABLE, this.fax));

        bind(TextBinding.text(model, Properties.PHONE_HOME_LABEL, this.phoneHomeLabel));
        bind(TextBinding.text(model, Properties.PHONE_HOME, this.phoneHome));
        bind(StateBinding.editable(model, Properties.PHONE_HOME_EDITABLE, this.phoneHome));

        bind(TextBinding.text(model, Properties.PHONE_MOBILE_LABEL, this.phoneMobileLabel));
        bind(TextBinding.text(model, Properties.PHONE_MOBILE, this.phoneMobile));
        bind(StateBinding.editable(model, Properties.PHONE_MOBILE_EDITABLE, this.phoneMobile));

        bind(TextBinding.text(model, Properties.PHONE_WORK_LABEL, this.phoneWorkLabel));
        bind(TextBinding.text(model, Properties.PHONE_WORK, this.phoneWork));
        bind(StateBinding.editable(model, Properties.PHONE_WORK_EDITABLE, this.phoneWork));

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
