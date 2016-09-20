package pl.krupix.mas.finalproject.gui.frame;

import pl.krupix.mas.finalproject.model.dto.PartDTO;
import pl.krupix.mas.finalproject.model.dto.WarehouseDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;

/**
 * Created by krupix on 14.06.2016.
 */
public class MainFrame extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel repairsTab, clientsTab, workersTab, warehouseTab;

    private JPanel warehousePanel, leftWarehousePanel, rightWarehousePanel;

    private JLabel chooseWarehouseLabel;
    private JComboBox<String> warehousesComboBox;
    private JButton editWarehouseButton, addWarehouseButton, importPartsButton;

    private JLabel warehouseNameLabel, warehouseAdressLabel, warehouseContactLabel, warehouseAdditionalInformationLabel;
    private JButton viewPartsCatalogButton;

    private JTextField searchPartTextArea;
    private JButton searchButton;
    private JTable partsTable;
    private JLabel partNameLabel;
    private JComboBox<String> chooseRepair;
    private JComboBox<Integer> chooseCount;
    private JLabel priceWithTaxLabel, priceWithoutTaxLabel;
    private JPanel headerPanel, eastPanel;
    private JButton placeOrderButton;

    public MainFrame() {
        super("PG Auto");
        initMainComponents();
        initTabs();
        initWarehouseTabComponents();
//        initPartsCatalogView();
    }

    private void initMainComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(300,100);
        setSize(600, 300);
    }

    private void initTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        repairsTab = new JPanel();
        clientsTab = new JPanel();
        workersTab = new JPanel();
        warehouseTab = new JPanel();

        tabbedPane.addTab("Hurtownie", warehouseTab); // todo zmienić na osstatnie miejsce
        tabbedPane.addTab("Naprawy", repairsTab);
        tabbedPane.addTab("Klienci", clientsTab);
        tabbedPane.addTab("Pracownicy", workersTab);

        add(tabbedPane);
    }

    private void initWarehouseTabComponents() {
        warehousePanel = new JPanel(new BorderLayout());
        initLeftWarehousePanel();
        initRightWarehousePanel();
        warehouseTab.add(leftWarehousePanel, BorderLayout.WEST);
        warehouseTab.add(rightWarehousePanel, BorderLayout.EAST);
    }

    private void initLeftWarehousePanel() {
        leftWarehousePanel = new JPanel(new GridLayout(5,1));

        chooseWarehouseLabel = new JLabel("Wybierz hurtownię:");
        leftWarehousePanel.add(chooseWarehouseLabel);

        warehousesComboBox = new JComboBox<String>();
        leftWarehousePanel.add(warehousesComboBox);

        editWarehouseButton = new JButton("Edytuj dane");
        addWarehouseButton = new JButton("Dodaj hurtownię");
        importPartsButton = new JButton("Importuj katalog części");
        leftWarehousePanel.add(editWarehouseButton);
        leftWarehousePanel.add(addWarehouseButton);
        leftWarehousePanel.add(importPartsButton);
    }

    private void initRightWarehousePanel() {
        rightWarehousePanel = new JPanel(new GridLayout(5,1));

        warehouseNameLabel = new JLabel("Parts4You");
        warehouseAdressLabel = new JLabel("Adres:");
        warehouseContactLabel = new JLabel("Kontakt:");
        rightWarehousePanel.add(warehouseNameLabel);
        rightWarehousePanel.add(warehouseAdressLabel);
        rightWarehousePanel.add(warehouseContactLabel);

        viewPartsCatalogButton = new JButton("Przeglądaj katalog części");
        rightWarehousePanel.add(viewPartsCatalogButton);
    }

    public void initPartsCatalogView(WarehouseDTO warehouseDTO) {
        warehousePanel = new JPanel(new BorderLayout());

        headerPanel = new JPanel();
        searchPartTextArea = new JTextField(20);
        searchButton = new JButton("Znajdź");
        headerPanel.add(searchPartTextArea);
        headerPanel.add(searchButton);
        warehousePanel.add(headerPanel, BorderLayout.NORTH);

        partsTable = new JTable();
        List<PartDTO> partList = warehouseDTO.getAllParts();
        DefaultTableModel model = (DefaultTableModel) partsTable.getModel();
        model.addColumn("Col1");
        model.addColumn("Col2");
        for (PartDTO part : partList) {
            System.out.print("Got: " + part.toRow());
            model.addRow(part.toRow());
        }
        partsTable.setModel(model);
        warehousePanel.add(partsTable, BorderLayout.CENTER);

        eastPanel = new JPanel(new GridLayout(4,1));
        partNameLabel = new JLabel("Klocek");
        placeOrderButton = new JButton("Zamów");
        eastPanel.add(partNameLabel);
        eastPanel.add(placeOrderButton);

        warehousePanel.add(eastPanel, BorderLayout.EAST);
        warehouseTab.removeAll();
        warehouseTab.add(warehousePanel);
    }

    public JButton getPlaceOrderButton() {
        return placeOrderButton;
    }

    public void setPlaceOrderButton(JButton placeOrderButton) {
        this.placeOrderButton = placeOrderButton;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public void setEastPanel(JPanel eastPanel) {
        this.eastPanel = eastPanel;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(JPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public JLabel getPriceWithoutTaxLabel() {
        return priceWithoutTaxLabel;
    }

    public void setPriceWithoutTaxLabel(JLabel priceWithoutTaxLabel) {
        this.priceWithoutTaxLabel = priceWithoutTaxLabel;
    }

    public JLabel getPriceWithTaxLabel() {
        return priceWithTaxLabel;
    }

    public void setPriceWithTaxLabel(JLabel priceWithTaxLabel) {
        this.priceWithTaxLabel = priceWithTaxLabel;
    }

    public JComboBox<Integer> getChooseCount() {
        return chooseCount;
    }

    public void setChooseCount(JComboBox<Integer> chooseCount) {
        this.chooseCount = chooseCount;
    }

    public JComboBox<String> getChooseRepair() {
        return chooseRepair;
    }

    public void setChooseRepair(JComboBox<String> chooseRepair) {
        this.chooseRepair = chooseRepair;
    }

    public JLabel getPartNameLabel() {
        return partNameLabel;
    }

    public void setPartNameLabel(JLabel partNameLabel) {
        this.partNameLabel = partNameLabel;
    }

    public JTable getPartsTable() {
        return partsTable;
    }

    public void setPartsTable(JTable partsTable) {
        this.partsTable = partsTable;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public JTextField getSearchPartTextArea() {
        return searchPartTextArea;
    }

    public void setSearchPartTextArea(JTextField searchPartTextArea) {
        this.searchPartTextArea = searchPartTextArea;
    }

    public JButton getViewPartsCatalogButton() {
        return viewPartsCatalogButton;
    }

    public void setViewPartsCatalogButton(JButton viewPartsCatalogButton) {
        this.viewPartsCatalogButton = viewPartsCatalogButton;
    }

    public JLabel getWarehouseAdditionalInformationLabel() {
        return warehouseAdditionalInformationLabel;
    }

    public void setWarehouseAdditionalInformationLabel(JLabel warehouseAdditionalInformationLabel) {
        this.warehouseAdditionalInformationLabel = warehouseAdditionalInformationLabel;
    }

    public JLabel getWarehouseContactLabel() {
        return warehouseContactLabel;
    }

    public void setWarehouseContactLabel(JLabel warehouseContactLabel) {
        this.warehouseContactLabel = warehouseContactLabel;
    }

    public JLabel getWarehouseAdressLabel() {
        return warehouseAdressLabel;
    }

    public void setWarehouseAdressLabel(JLabel warehouseAdressLabel) {
        this.warehouseAdressLabel = warehouseAdressLabel;
    }

    public JLabel getWarehouseNameLabel() {
        return warehouseNameLabel;
    }

    public void setWarehouseNameLabel(JLabel warehouseNameLabel) {
        this.warehouseNameLabel = warehouseNameLabel;
    }

    public JButton getImportPartsButton() {
        return importPartsButton;
    }

    public void setImportPartsButton(JButton importPartsButton) {
        this.importPartsButton = importPartsButton;
    }

    public JButton getAddWarehouseButton() {
        return addWarehouseButton;
    }

    public void setAddWarehouseButton(JButton addWarehouseButton) {
        this.addWarehouseButton = addWarehouseButton;
    }

    public JButton getEditWarehouseButton() {
        return editWarehouseButton;
    }

    public void setEditWarehouseButton(JButton editWarehouseButton) {
        this.editWarehouseButton = editWarehouseButton;
    }

    public JComboBox<String> getWarehousesComboBox() {
        return warehousesComboBox;
    }

    public void setWarehousesComboBox(JComboBox<String> warehousesComboBox) {
        this.warehousesComboBox = warehousesComboBox;
    }

    public JLabel getChooseWarehouseLabel() {
        return chooseWarehouseLabel;
    }

    public void setChooseWarehouseLabel(JLabel chooseWarehouseLabel) {
        this.chooseWarehouseLabel = chooseWarehouseLabel;
    }

    public JPanel getRightWarehousePanel() {
        return rightWarehousePanel;
    }

    public void setRightWarehousePanel(JPanel rightWarehousePanel) {
        this.rightWarehousePanel = rightWarehousePanel;
    }

    public JPanel getLeftWarehousePanel() {
        return leftWarehousePanel;
    }

    public void setLeftWarehousePanel(JPanel leftWarehousePanel) {
        this.leftWarehousePanel = leftWarehousePanel;
    }

    public JPanel getWarehousePanel() {
        return warehousePanel;
    }

    public void setWarehousePanel(JPanel warehousePanel) {
        this.warehousePanel = warehousePanel;
    }

    public JPanel getWarehouseTab() {
        return warehouseTab;
    }

    public void setWarehouseTab(JPanel warehouseTab) {
        this.warehouseTab = warehouseTab;
    }

    public JPanel getWorkersTab() {
        return workersTab;
    }

    public void setWorkersTab(JPanel workersTab) {
        this.workersTab = workersTab;
    }

    public JPanel getClientsTab() {
        return clientsTab;
    }

    public void setClientsTab(JPanel clientsTab) {
        this.clientsTab = clientsTab;
    }

    public JPanel getRepairsTab() {
        return repairsTab;
    }

    public void setRepairsTab(JPanel repairsTab) {
        this.repairsTab = repairsTab;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }
}
