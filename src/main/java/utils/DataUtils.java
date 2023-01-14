package utils;

import java.io.File;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataUtils {

	public static String getTestData(String sheetName, String fieldName) {
		System.out.println("Our Execution Environment is:" + System.getProperty("env"));
		String result = "unable to access data";
		String datFilePath = "no test data file provided ";

		if (null == System.getProperty("env")) {
			datFilePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
					+ "TestDataStage.xlsx";

		} else if (System.getProperty("env").toLowerCase().trim().equals("prod")) {
			datFilePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
					+ "TestDataProd.xlsx";
		}

		else {
			datFilePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
					+ "TestDataStage.xlsx";
		}

		datFilePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
				+ "TestDataStage.xlsx";

		try {
			Fillo fillo = new Fillo();

			Connection connection = fillo.getConnection(datFilePath);

			String query = "select * from " + sheetName + " where ID='" + fieldName + "'";

			Recordset resultSet = connection.executeQuery(query);

			while (resultSet.next()) {
				result = resultSet.getField("Value");
			}

			resultSet.close();
			connection.close();
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

}
