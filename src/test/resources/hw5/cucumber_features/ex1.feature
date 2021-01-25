Feature: Different Elements page

  Scenario: Go to Different Element Page and select elements
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And I set checkboxes
      | Checkboxes |
      | Water      |
      | Wind       |
    And  I set radio 'Selen'
    And  I set dropdown 'Yellow'
    Then There is an individual log row for each checkbox
      | Checkboxes |
      | Water      |
      | Wind       |
    And There is a log row for radio button 'Selen'
    And There is a log row for dropdown value 'Yellow'


