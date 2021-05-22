package com.brandothedev;

import com.brandothedev.connector.ConnectorHorse;
import com.brandothedev.create.UpdateHorse;
import com.brandothedev.delete.DeleteHorse;
import com.brandothedev.read.ReadHorse;
import com.brandothedev.update.CreateHorse;

/**
 * After almost two months of java programming I wanted to go back and recreate
 * my CRUD application I tackled a lot of issues that I commented on the first
 * one such as using preparedStatements instead of regular statements. Followed
 * the SOLID as much as possible which if you look at my old classes, it really
 * cleaned up my code, and using packages now! My only peeve is I didnt swap
 * year to something like int(4)
 * 
 * @author BrandoTheDev
 *
 */
public class MainHorse {

    public static void main(String[] args) {
	new ConnectorHorse();

	/*
	 * Example(s) of the CreateHorse Class
	 */
	CreateHorse.create("Chevy", "Corvette", "2007");// INSERT INTO VEHICLES (make, model, year) VALUES("Chevy", "Corvette", "2007")";

	/*
	 * Example(s) of the ReadHorse Class
	 */
	ReadHorse.read(20); // SELECT * FROM VEHICLES LIMIT 20
	ReadHorse.read("", "", "2007", 20); // SELECT * FROM VEHICLES WHERE make="" OR model="" OR year="2007" LIMIT 20
	ReadHorse.read("", "Mustang", "", 20); // SELECT * FROM VEHICLES WHERE make="" OR model="Mustang" OR year="" LIMIT 20
	ReadHorse.read("Ford", "", "", 20); // SELECT * FROM VEHICLES WHERE make="Ford" OR model="" OR year="" LIMIT 20
	ReadHorse.read("Ford", "Mustang", "2007", 20); // SELECT * FROM VEHICLES WHERE make="Ford" OR model="Mustang" OR year="2007" LIMIT 20

	/*
	 * Example(s) of the UpdateHorse Class
	 */
	UpdateHorse.updateMake("Chevy", 10); // UPDATE VEHICLES SET make = "Chevy" where vehicle_id = 10
	UpdateHorse.updateModel("s10", 10); // UPDATE VEHICLES SET model = "s10" where vehicle_id = 10
	UpdateHorse.updateYear("1982", 10); // UPDATE VEHICLES SET year = "1982" where vehicle_id = 10

	/*
	 * Example(s) of the DeleteHorse Class
	 */
	DeleteHorse.delete(10); // DELETE FROM VEHICLES WHERE vehicle_id = 10

	ConnectorHorse.closeConnection(); // Always remember to close what you open! :)

    }

}
