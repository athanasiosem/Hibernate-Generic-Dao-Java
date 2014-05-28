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

		Region region = new Region();
		region.setRegionId(1);
		region.setRegionName("Africa");
		regionService.save(region);
		
		Country country=new Country();
		country.setCountryId("EGY");
		country.setCountryName("Egypt");
		country.setRegion(region);
		countryService.save(country);
		
		country=new Country();
		country.setCountryId("TUN");
		country.setCountryName("Tunis");
		country.setRegion(region);
		countryService.save(country);
		
		
		region = new Region();
		region.setRegionId(2);
		region.setRegionName("America");
		regionService.save(region);
		
		country=new Country();
		country.setCountryId("CAN");
		country.setCountryName("Canada");
		country.setRegion(region);
		countryService.save(country);
		
		country=new Country();
		country.setCountryId("USA");
		country.setCountryName("USA");
		country.setRegion(region);
		countryService.save(country);

		List<Country> countryList = countryService.getAll();
		if (countryList != null) {
			for (Country c : countryList) {
				System.out.println(c.toString());
			}
		}

	}
}
