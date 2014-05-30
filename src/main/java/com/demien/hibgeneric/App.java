package com.demien.hibgeneric;

import java.util.List;

import com.demien.hibgeneric.service.GenericServiceImpl;
import com.demien.hibgeneric.service.IGenericService;
import com.demien.hibgeneric.domain.Country;
import com.demien.hibgeneric.domain.Region;

public class App {
	public static void main(String[] args) {
		
	
		IGenericService<Region> regionService = new GenericServiceImpl<Region>(
				Region.class, HibernateUtil.getSessionFactory());
		
		IGenericService<Country> countryService = new GenericServiceImpl<Country>(
				Country.class, HibernateUtil.getSessionFactory());
		
		regionService.deleteAll();

		Region region1 = new Region();
		region1.setRegionId(1);
		region1.setRegionName("Africa");
		regionService.save(region1);
		
		Region region2 = new Region();
		region2.setRegionId(2);
		region2.setRegionName("America");
		regionService.save(region2);
		
		Country country1=new Country();
		country1.setCountryId("EGY");
		country1.setCountryName("Egypt");
		country1.setRegion(region1);
		countryService.save(country1);
		
		Country country2=new Country();
		country2.setCountryId("TUN");
		country2.setCountryName("Tunis");
		country2.setRegion(region1);
		countryService.save(country2);
		
		Country country3=new Country();
		country3.setCountryId("CAN");
		country3.setCountryName("Canada");
		country3.setRegion(region2);
		countryService.save(country3);
		
		Country country4=new Country();
		country4.setCountryId("USA");
		country4.setCountryName("USA");
		country4.setRegion(region2);
		countryService.save(country4);

		List<Country> countryList = countryService.getAll();
		if (countryList != null) {
			for (Country c : countryList) {
				System.out.println(c.toString());
			}
		}

	}
}
