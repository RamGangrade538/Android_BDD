Feature: Login Functionality

  Scenario Outline: Login with invalid credentials
    Given Goto the Login page invalid
    When I enter username "<username>" and password "<password>" invalid
    And I click on the login button invalid
    Then Verify Error message invalid

    Examples:
      | username          | password |
      | alice@example.com | 10203040 |
      |                   |          |
      | 1@2.com           | f-o-o    |
      | bob@example.com   |          |



  Scenario Outline:Login with valid credentials
    Given Goto the Login page
    When I enter username "<username>" and password "<password>"
    And I click on the login button
    Then Verify login successfully
    Examples:
      | username        | password |
      | bob@example.com | 10203040 |
