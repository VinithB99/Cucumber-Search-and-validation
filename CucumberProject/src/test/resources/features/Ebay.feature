Feature: User will validate the Ebay Search

Scenario: Search Using the Hardcoded Data in Ebay
Given User should Launch Ebay Chrome Browser for Ebay
And User shold Navigate to URL "https://www.ebay.com/" for Ebay
When User search the product for Ebay
Then Validate the Result for Ebay
And Close the Browser for Ebay
