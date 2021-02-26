Feature: Check top riser and faller on the FTSE

  Scenario: Get Top Riser
    Given that I can navigate to the h1.co.uk ftse page
    When I click the risers link
    And find the top table entry
    Then I output it
    
  Scenario: Get Top Faller
    Given that I can navigate to the h1.co.uk ftse page
    When I click the fallers link
    And find the top table entry
    Then I output it