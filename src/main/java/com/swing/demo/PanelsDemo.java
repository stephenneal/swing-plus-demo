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

import com.jgoodies.forms.factories.Borders;
import com.swing.binding.bbb.BindingService;
import com.swing.demo.panels.AddressPanel;
import com.swing.demo.panels.NamePanel;
import com.swing.demo.panels.PersonPanel;
import com.swing.plus.PanelFactory;
import com.swing.plus.mvc.DualModePresentationModel.ViewMode;

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
        panelsPane.setPreferredSize(new Dimension(1100, 800));

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

        JPanel person1 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (no data)", false, false);
        JPanel person2 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (with data)", false, true);
        PersonPanel person3 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (read only, no data)", true,
                        false);
        PersonPanel person4 = PanelsDemoFactory.newPersonPanel(bindingService, "Person (read only, with data)", true,
                        true);
        person4.getModel().setMode(ViewMode.READ_ONLY);
        root.add(new DefaultMutableTreeNode(new PanelUserObject("Person Panel", PanelFactory.grid(0, 2, person1,
                        person2, person3, person4))));

        JPanel address1 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (no data)", false, false);
        JPanel address2 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (with data)", false, true);
        AddressPanel address3 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (read only, no data)", true,
                        false);
        address3.getModel().setMode(ViewMode.READ_ONLY);
        AddressPanel address4 = PanelsDemoFactory.newAddressPanel(bindingService, "Address (read only, with data)",
                        true, true);
        address4.getModel().setMode(ViewMode.READ_ONLY);
        root.add(new DefaultMutableTreeNode(new PanelUserObject("Address Panel", PanelFactory.grid(0, 2, address1,
                        address2, address3, address4))));

        JPanel name1 = PanelsDemoFactory.newNamePanel(bindingService, "Name (no data)", false, false);
        JPanel name2 = PanelsDemoFactory.newNamePanel(bindingService, "Name (with data)", false, true);
        NamePanel name3 = PanelsDemoFactory.newNamePanel(bindingService, "Name (read only, no data)", true, false);
        name3.getModel().setMode(ViewMode.READ_ONLY);
        NamePanel name4 = PanelsDemoFactory.newNamePanel(bindingService, "Name (read only, with data)", true, true);
        name4.getModel().setMode(ViewMode.READ_ONLY);
        root.add(new DefaultMutableTreeNode(new PanelUserObject("Name Panel", PanelFactory.grid(0, 2, name1, name2,
                        name3, name4))));

        return root;
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
