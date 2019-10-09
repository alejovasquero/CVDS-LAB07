package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.ItemRentado;
import java.sql.Date;

public interface ItemRentadoMapper {
    
    
    public ItemRentado getItemRentado(@Param ("ir")int id);
    
	public void insertItemRentado(@Param ("docu")long docu,@Param ("itemId")int itemId,@Param ("fechaIni")Date fechaIni,@Param ("fechaFin")Date fechaFin);

	public List<ItemRentado> consultarItemsSinDevolver(@Param("doc") long documento);
}
