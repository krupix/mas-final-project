package pl.krupix.mas.finalproject.service.impl;

import org.apache.log4j.Logger;
import pl.krupix.mas.finalproject.gui.frame.MainFrame;
import pl.krupix.mas.finalproject.model.DaoSerivce;
import pl.krupix.mas.finalproject.model.domain.Warehouse;
import pl.krupix.mas.finalproject.model.dto.PartDTO;
import pl.krupix.mas.finalproject.model.dto.WarehouseDTO;
import pl.krupix.mas.finalproject.model.exception.NoSuchWarehouseException;
import pl.krupix.mas.finalproject.model.exception.PartAlreadyExistsException;
import pl.krupix.mas.finalproject.model.impl.DaoServiceImpl;
import pl.krupix.mas.finalproject.model.mock.MockData;
import pl.krupix.mas.finalproject.service.MainService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Created by krupix on 13.06.2016.
 */
public class MainServiceImpl implements Runnable, MainService {

    private static Logger log = Logger.getLogger(WarehouseDTO.class);

    private MainFrame view;
    private MockData mockData;
    private DaoServiceImpl daoSerivce;

    public MainServiceImpl() {
        daoSerivce = new DaoServiceImpl();
        createMockData();
        go();
        init();
        addListeners();
    }

    private void addListeners() {
        view.getViewPartsCatalogButton().addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.initPartsCatalogView(WarehouseDTO.findByName((String)view.getWarehousesComboBox().getSelectedItem()));
                view.revalidate();
                view.repaint();
            }
        });

    }

    private void createMockData() {
        log.info("adding MOCK DATA");
        Warehouse warehouse = new Warehouse();
        warehouse.setName("AutoParts");
        daoSerivce.persist(warehouse);

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("InterCars");
        daoSerivce.persist(warehouse1);

        PartDTO partDTO = null;
        try {
            partDTO = PartDTO.createPart(warehouse.getDTO(), "Bosh");
            partDTO.setNetPrice(100);
            PartDTO partDTO1 = PartDTO.createPart(warehouse.getDTO(), "OMP");
            partDTO1.setNetPrice(200);
            PartDTO partDTO3 = PartDTO.createPart(warehouse1.getDTO(), "Ferrari");
            partDTO3.setNetPrice(200);

        } catch (NoSuchWarehouseException e) {
            e.printStackTrace();
        } catch (PartAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
    }

    public void init() {
        mockData = new MockData();
        mockData.init();
        List<Warehouse> warehouseList = daoSerivce.getAllWarehouses();
        for(Warehouse w : warehouseList) {
            view.getWarehousesComboBox().addItem(w.getName());

        }

//        view.revalidate();
//        view.repaint();
    }

    @Override
    public void go() {
        log.info("Starting view");
        view = new MainFrame();
        log.info("View started");
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                view = new MainFrame();
//                log.info("View started");
//            }
//        });
    }

}

