Feature: Open filters dialog

  Scenario Outline: Successful open filters dialog
    Given I open NewsListScreen
    And I click filter button
    Then I expect to see filters dialog

    Examples:
      | |
      | |