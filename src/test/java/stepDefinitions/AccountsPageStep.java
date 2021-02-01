package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageStep {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialsTable) {
		List<Map<String,String>> crenedtialList = credentialsTable.asMaps();
		String email = crenedtialList.get(0).get("username");
		String pass = crenedtialList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.loginToApplication(email, pass);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println(title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List <String> expectedAccountsSectionList = sectionsTable.asList();
		System.out.println("Expected Accounts Section List: "+expectedAccountsSectionList);
		List <String> actualAccountsSectionList = accountsPage.getAccountsSectionList();
		System.out.println(actualAccountsSectionList);
		Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}
}
