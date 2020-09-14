Feature:Customer is able view the product list on all pages

  /*As a User
  I want to View Products list based on my search
  So that i can view my products in all result pages*/

Scenario:View the Product list in all pages

Given the customer is on a product list page
And the customer has selected desired number of items to be displayed per page
When a certain number of items is displayed per page
And the customer proceeds to the next page
Then the system will display the next set of items