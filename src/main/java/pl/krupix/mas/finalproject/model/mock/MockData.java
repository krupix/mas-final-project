package pl.krupix.mas.finalproject.model.mock;

import pl.krupix.mas.finalproject.model.dto.AdressDataDTO;
import pl.krupix.mas.finalproject.model.dto.ContactDataDTO;
import pl.krupix.mas.finalproject.model.dto.PartDTO;
import pl.krupix.mas.finalproject.model.dto.WarehouseDTO;
import pl.krupix.mas.finalproject.model.exception.NoSuchWarehouseException;
import pl.krupix.mas.finalproject.model.exception.PartAlreadyExistsException;

/**
 * Created by krupix on 18.06.2016.
 */
public class MockData {


    private WarehouseDTO warehouseDTO;

   public void init() {

        try {
            warehouseDTO = new WarehouseDTO(new AdressDataDTO(), new ContactDataDTO(), "test", "123456", "test", 0);
            PartDTO partDTO = PartDTO.createPart(warehouseDTO, "OMP");
            PartDTO partDTO2 = PartDTO.createPart(warehouseDTO, "OMP2");
            warehouseDTO.addPart(partDTO);
            warehouseDTO.addPart(partDTO2);
        } catch (NoSuchWarehouseException e) {
            e.printStackTrace();
        } catch (PartAlreadyExistsException e) {
            e.printStackTrace();
        }




    }

    public WarehouseDTO getWarehouseDTO() {
        return warehouseDTO;
    }

    public void setWarehouseDTO(WarehouseDTO warehouseDTO) {
        this.warehouseDTO = warehouseDTO;
    }
}
