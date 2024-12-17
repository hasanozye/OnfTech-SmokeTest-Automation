@smokeTest
Feature: OnfTech Landing Page Smoke Test
  As a user visiting OnfTech's website
  I want to navigate through the key pages
  So that I can verify they open and display the expected features

  Background:
    Given I am on the OnfTech Home Page

  @homePageTest
  Scenario: Verify Home Page Features
    Then I should see the logo
    And  the page URL should be "https://onftech.com/"
    And  the page title should contain "ONFTECH | Your Partner in Transforming the Future of Fintech"
    And  the slider content should be visible

  @productsPageTest
  Scenario: Navigate to Products Page
    When I click on the burger menu
    Then I should see the sidebar with its contents
    When I open the "Products" page
    Then I should see the list of available products

    When I click on the "Tanfeeth Watheeq Gateway" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "Letter of Guarantee Gateway" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "Online Document Gateway" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "iAnalytics" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "Electronic Government Gateway" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "Gateway of SADAD" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "Your Ultimate IT Service Management Solution" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "Unlock Compliance Excellence" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "The Integrated Governance, Risk, and Compliance" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page

    When I click on the "API Gateway" product link
    Then I should see the product details page for the clicked link
    And  I should be able to return to the Products page


 #@pricingPageTest
 #Scenario: Navigate to Pricing Page and Verify Plans
 #  When I click on the "Pricing" navigation link
 #  Then I should see the pricing plans section displayed
 #  And the page title should contain "Pricing"
 #  And the page URL should be "https://onftech.com/pricing"
 #  When I interact with the pricing slider for 5 websites
 #  Then the price details should update correctly
 #  When I interact with the pricing slider for 10 websites
 #  Then the price details should update correctly

 #@joinPageTest
 #Scenario: Navigate to Join Page and Verify Sign-Up Form
 #  When I click on the "Join" navigation link
 #  Then the page title should contain "Join"
 #  And the page URL should be "https://onftech.com/join"
 #  When I fill out the sign-up form with valid data
 #  And I submit the form
 #  Then I should see a confirmation message "Thank you for signing up!"
