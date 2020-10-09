Feature: Rightwayautosale Inventory page tests

  Background:
    Given User navigates to "https://www.rightwayautosale.com/inventory " page

  Scenario Outline: Verifying the menu bar by years test
    When User clicks on the <checking_Year> of the car
    Then Verify the <checking_Year> is displayed on the Autosearch page
    Examples:

      | checking_Year |
      | 2014          |
      | 2013          |
      | 2012          |
      | 2011          |
      | 2010          |
      | 2009          |
#
  Scenario Outline: Verifying the menu bar by body type, make and engine tests
    When User clicks on the "<checking_element>" of the car
    Then Verify the "<checking_element>" is displayed on the Autosearch page
    Examples:


      | checking_element  |
      | Sedan             |
      | SUV-Crossover     |
      | Hatchback         |
      | Minivan-Van       |
      | Volkswagen        |
      | Honda             |
      | Nissan            |
      | Kia               |
      | Chevrolet         |
      | Dodge             |
      | Mazda             |
      | Hyundai           |
      | 4 Cylinder Engine |
      | 6 Cylinder Engine |



  Scenario Outline: Verifying the sorting bar tests
    When User clicks on the "<sorting_option>" of the cars
    Then Verify the correctness of the sorted cars according to the choose "<sorting_option>"

    Examples:
      | sorting_option |
      | Year           |
      | Make           |
      | Model          |
      | Price          |
      | Mileage        |

  Scenario Outline: Verifying the details about the car tests
    When User refresh the Inventory page
    Then Verify all the "<carDeatils>" are present on the Inventory page

    Examples:

      | carDeatils                                                                        |
      | //div[@data-key='347']//li[1]/strong[text()='Stock#']                             |
      | //div[@data-key='347']//li[4]/strong[text()='Drivetrain']                         |
      | //div[@data-key='347']//li[7]/strong[text()='Engine']                             |
      | //div[@data-key='347']//li[2]/strong[text()='Transmission']                       |
      | //div[@data-key='347']//li[5]/strong[text()='Exterior']                           |
      | //div[@data-key='347']//li[8]/strong[text()=' Odometer ']                         |
      | //div[@data-key='347']//li[3]/strong[text()='Fuel']                               |
      | //div[@data-key='347']//li[6]/strong[text()='Interior']                           |
      | //div[@data-key='347']/li[@id='products']/div[@class='col-md-9 inventory-detail'] |
      | //div[@data-key='347']//span[@class='eziVehiclePrice']                            |
      | //div[@data-key='347']//div[2]/div[3]/a[text()='View Details']                    |
      | //div[@data-key='347']//div/div/a/div[@class='img-list-respnsivex']               |


  Scenario Outline: Verifying are the elements active
    When User refresh the Inventory page
    Then Verify is the "<element>" active
    Examples:

      | element                                                             |
      | //div[@data-key='347']//h2                                          |
      | //div[@data-key='347']//div[2]/div[3]/a[text()='View Details']      |
      | //div[@data-key='347']//div/div/a/div[@class='img-list-respnsivex'] |