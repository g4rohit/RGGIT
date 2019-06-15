package com.primusbank.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources2.base;

public class PrimusHomePageObj extends base {

	public static WebDriver driver;

	By BranchesButton = By.xpath("//a[@href='admin_banker_master.aspx']");
	By RolesButton = By.xpath("//a[@href='Admin_Roles_details.aspx']");
	By UsersButton = By.xpath("//a[@href='userdetails.aspx']");
	By EmployeeButton = By.xpath("//a[@href='Admin_Emp_details.aspx']");
	By NewBrachButton=By.cssSelector("#BtnNewBR");



	public PrimusHomePageObj(WebDriver driver2) {
		this.driver=driver2;
	}
	public WebElement getBranchesButton() {
		return driver.findElement(BranchesButton);

	}
	public WebElement getRolesButton() {
		return driver.findElement(RolesButton);

	}
	public WebElement getUsersButton() {
		return driver.findElement(UsersButton);

	}
	public WebElement getEmployeeButtonButton() {
		return driver.findElement(EmployeeButton);

	}
	public WebElement getNewBranchCreationButton() {
		return driver.findElement(NewBrachButton);

	}
}
