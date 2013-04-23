package com.swing.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.panels.AddressPanel;
import com.swing.demo.panels.ContactsPanel;
import com.swing.demo.panels.NamePanel;
import com.swing.demo.panels.PersonDetailsPanel;
import com.swing.demo.panels.PersonPanel;
import com.swing.plus.PanelFactory;

public class PanelsDemo {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(PanelsDemo.class);

    public static void main(String[] args) {
        final BindingService binding = new BindingService();
        final JPanel panel = createContentPane(binding);
        final JFrame frame = new JFrame("Panels Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                binding.release();
            }
        });
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.getContentPane().add(panel, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static JPanel createContentPane(final BindingService bindingService) {
        final JPanel panelsPanel = PanelFactory.boxX();
        panelsPanel.setBorder(Borders.DIALOG);
        JScrollPane panelsPane = new JScrollPane(panelsPanel);
        panelsPane.setMinimumSize(new Dimension(400, 800));
        panelsPane.setPreferredSize(new Dimension(1000, 800));

        DefaultTreeModel treeModel = new DefaultTreeModel(getRoot(bindingService));
        final JTree tree = new JTree(treeModel);
        JScrollPane treePane = new JScrollPane(tree);
        treePane.setMinimumSize(new Dimension(200, 800));

        final JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane, panelsPane);
        split.setOneTouchExpandable(true);
        split.setDividerLocation(250);

        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node == null) {
                    return;
                }
                final Object nodeObject = node.getUserObject();
                if (nodeObject instanceof PanelUserObject) {
                    panelsPanel.removeAll();
                    JPanel panel = ((PanelUserObject) nodeObject).getPanel();
                    panelsPanel.add(panel);
                    panel.revalidate();
                    panelsPanel.repaint();
                }
            }
        });

        JPanel panel = PanelFactory.boxX();
        panel.add(split);
        return panel;
    }

    private static TreeNode getRoot(BindingService bindingService) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Panels");

        // Person Panel
        JPanel person1 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (no data)", false, false);
        JPanel person2 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (with data)", false, true);
        PersonPanel person3 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (read only, no data)", true,
                        false);
        PersonPanel person4 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (read only, with data)", true,
                        true);
        root.add(newTreeNode("Person Panel", PanelFactory.grid(0, 2, person1, person2, person3, person4)));

        // Address Panel
        JPanel address1 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (no data)", false, false);
        JPanel address2 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (with data)", false, true);
        AddressPanel address3 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (read only, no data)", true,
                        false);
        AddressPanel address4 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (read only, with data)",
                        true, true);
        root.add(newTreeNode("Address Panel", PanelFactory.grid(0, 2, address1, address2, address3, address4)));

        // Name Panel
        JPanel name1 = PanelsDemoFactory.newNamePanel(bindingService, "Name (no data)", false, false);
        JPanel name2 = PanelsDemoFactory.newNamePanel(bindingService, "Name (with data)", false, true);
        NamePanel name3 = PanelsDemoFactory.newNamePanel(bindingService, "Name (read only, no data)", true, false);
        NamePanel name4 = PanelsDemoFactory.newNamePanel(bindingService, "Name (read only, with data)", true, true);
        root.add(newTreeNode("Name Panel", PanelFactory.grid(0, 2, name1, name2, name3, name4)));

        // Contacts Panel
        JPanel contacts1 = PanelsDemoFactory.newContactsPanel(bindingService, "Contacts (no data)", false, false);
        JPanel contacts2 = PanelsDemoFactory.newContactsPanel(bindingService, "Contacts (with data)", false, true);
        ContactsPanel contacts3 = PanelsDemoFactory.newContactsPanel(bindingService, "Contacts (read only, no data)",
                        true, false);
        ContactsPanel contacts4 = PanelsDemoFactory.newContactsPanel(bindingService, "Contacts (read only, with data)",
                        true, true);
        root.add(newTreeNode("Contacts Panel", PanelFactory.grid(0, 2, contacts1, contacts2, contacts3, contacts4)));

        // Person Details Panel
        JPanel personDetails1 = PanelsDemoFactory.newPersonDetailsPanel(bindingService, "Person Details (no data)",
                        false, false);
        JPanel personDetails2 = PanelsDemoFactory.newPersonDetailsPanel(bindingService, "Person Details (with data)",
                        false, true);
        PersonDetailsPanel personDetails3 = PanelsDemoFactory.newPersonDetailsPanel(bindingService,
                        "Person Details (read only, no data)", true, false);
        PersonDetailsPanel personDetails4 = PanelsDemoFactory.newPersonDetailsPanel(bindingService,
                        "Person Details (read only, with data)", true, true);
        root.add(newTreeNode("Person Details Panel",
                        PanelFactory.grid(0, 2, personDetails1, personDetails2, personDetails3, personDetails4)));

        // Combination Person, Address, Contact, Person Details, Name Panel
        PersonPanel comboPerson = PanelsDemoFactory.newPersonPanel(bindingService, "Person", true, true);
        JPanel comboAddresses = PanelsDemoFactory.newAddressesPanel(bindingService, "Addresses", true, true);
        PersonDetailsPanel comboDetails = PanelsDemoFactory.newPersonDetailsPanel(bindingService, "Person Details",
                        true, true);
        NamePanel comboName = PanelsDemoFactory.newNamePanel(bindingService, "Trading As Name", true, true);
        ContactsPanel comboContacts = PanelsDemoFactory.newContactsPanel(bindingService, "Contacts", true, true);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.relatedColumnSpec(2, 1, 2),
                        LayoutFactory2.relatedRowSpec(4)));
        builder.append(comboPerson);
        builder.add(comboAddresses, CC.xywh(3, 1, 1, 5));
        builder.nextLine(2);
        builder.append(comboName);
        builder.nextLine(2);
        builder.append(comboContacts);
        builder.nextLine(2);
        builder.append(comboDetails);
        root.add(newTreeNode("Combination (read only)", builder.getPanel()));

        return root;
    }

    private static DefaultMutableTreeNode newTreeNode(String nodeText, JPanel panel) {
        return new DefaultMutableTreeNode(new PanelUserObject(nodeText, panel));
    }

    private static class PanelUserObject {

        private final JPanel panel;
        private final String nodeText;

        public PanelUserObject(String nodeText, JPanel panel) {
            super();
            this.nodeText = nodeText;
            this.panel = panel;
        }

        public JPanel getPanel() {
            return this.panel;
        }

        @Override
        public String toString() {
            return this.nodeText == null || this.nodeText.isEmpty() ? super.toString() : this.nodeText;
        }

    }
}
