package Tax;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TaxOperation {

	public void doTaxCalculation(int empId, double annualIncome) {

		File taxRateFile = getOperationFile("taxrates.txt", "tax_rates");
	}

	public File getOperationFile(String filepath, String fileType) {
		File file = new File(filepath);
		if (file.exists())
			return file;

		// If file does not exists in file system, System attempts user to create a file
		// by specifying name

		String newFilePath = TaxKilareUI.getInputText("Enter the file name : ", new Scanner(System.in));
		if (newFilePath != null) {
			TaxKilareUI.printOutput("File Name is : " + newFilePath);
			file = new File(newFilePath);
			try {
				if (file.createNewFile()) {
					FileWriter writer = new FileWriter(file, true);
					writer.write(getTaxRateText(fileType));
					writer.flush();
					writer.close();
				} else
					TaxKilareUI.printErrorOutput("File Creation was not successfull !");

			} catch (Exception e) {
				TaxKilareUI.printErrorOutput("Error occurs while creating new file : " + newFilePath);
				e.printStackTrace();
			}

		}

		return file;
	}

	private String getTaxRateText(String fileType) {

		String content = fileType != "tax_rates" ? null
				: "180001	54232	0.450\r\n" + "87001	19822	0.370\r\n" + "37001	3572	0.325\r\n"
						+ "18201	0	0.190\r\n" + "0	0	0.000";

		return content;
	}

}
