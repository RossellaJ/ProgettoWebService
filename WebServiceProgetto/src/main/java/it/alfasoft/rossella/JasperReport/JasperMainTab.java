package it.alfasoft.rossella.JasperReport;

import it.alfasoft.rossella.dao.BustaPagaDao;
import it.alfasoft.rossella.dao.FatturaDao;
import it.alfasoft.rossella.model.BustaPaga;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperMainTab {

	public static void main(String[] args) {

		BustaPagaDao bDao = new BustaPagaDao();
		
		String pathJasper="Tab.jasper";	
		System.out.println(pathJasper);
		String pathJasperImm="logo.jpg";	
		System.out.println(pathJasperImm);
		
		String nomeFile="TabellaBustePaga.pdf";
		//metti concatenazione nel nome con parametro per non sovrascrivere
		String percorso  = "C:\\Users\\corso\\Desktop\\Jasper\\";
		 
		String fileFinale=percorso+nomeFile;
		
		try {
			
		//la mia lista che mantiene i dati
        List<BustaPaga> buste =bDao.readTutteBustePaga() ;
	
      // Converto la  lista to JRBeanCollectionDataSource 
      JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(buste,false);
		
			
      //  una mappa per mandare i parametri a Jasper 
      Map<String, Object> parameters = new HashMap<String, Object>();
    
      parameters.put("BustaDataSource", itemsJRBean);
      parameters.put("logo", pathJasperImm);

     
      //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
      JasperPrint jasperPrint = JasperFillManager.fillReport(pathJasper, parameters, new JREmptyDataSource());

      //outputStream per creare PDF 
      OutputStream outputStream = new FileOutputStream(new File(fileFinale));
     
      
      // scrivo in un  file PDF  
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		System.out.println("il File.pdf e' stato creato");
		
		
		
	} catch (JRException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

       
//ClienteDao cDAo=new ClienteDao();
//		
//		Double d;
//		
//		String nomeFile="ElencoClienti.pdf";
//		
//		 String percorso  = "C:\\Users\\admin\\Documents\\A0\\";
//		 
//		 String fileFinale=percorso+nomeFile;
//		 
//		 
//		
//		try {
//             
//
//           //la mia lista che mantiene i dati
//             List<Cliente> clienti = cDAo.getListaClienti();
//     
//
//           // Converto la  lista to JRBeanCollectionDataSource 
//           JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(clienti,false);
//
//           //  una mappa per mandare i parametri a Jasper 
//           Map<String, Object> parameters = new HashMap<String, Object>();
//         
//           parameters.put("ClienteDataSource", itemsJRBean);
//           parameters.put("importo", 2.5);
//
//           //  file compilato di jasper (.jasper) di Jasper Report per creare  PDF 
//           JasperPrint jasperPrint = JasperFillManager.fillReport("ElencoClienti.jasper", parameters, new JREmptyDataSource());
//
//           //outputStream per creare PDF 
//           OutputStream outputStream = new FileOutputStream(new File(fileFinale));
//          
//           
//           // scrivo in un  file PDF  
//         
//           JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//
//           System.out.println("File e' stato creato");
//            
//     
//          
//           
//           
//           
//       } catch (JRException ex) {
//           ex.printStackTrace();
//       } catch (FileNotFoundException ex) {
//           ex.printStackTrace();
//       }
//		
//		
	



	}

}
