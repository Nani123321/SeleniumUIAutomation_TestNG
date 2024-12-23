package com.orangeHRM.Framework.ExcelUtilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider (name="LoginData")
	public String [][] getdata() throws IOException
	{
		String path=".\\testData\\orangeHRMLoginData.xlsx";
		ExcelUtilities xlUtil =new ExcelUtilities(path);
		int totalRowcount = xlUtil.getRowCount("sheet1");
		int totalColCount = xlUtil.getcellCount("sheet1",1);
		String loginData [][]=new String [totalRowcount][totalColCount];
		for(int i=1;i<=totalRowcount;i++) {
			for(int j=0;j<totalColCount;j++)
			{
				loginData[i-1][j]=xlUtil.getCellData("sheet1", i, j);
			}
		}
		return loginData;
	}
}
