 Feature: Coupon related scenarios
 
 Background:
		 Given user navigated to login page
  	 When user enters "admin" and "Admin@123"
  	 Then user should see Dashboard
  	 Given user Hovers on share icon
  	 When user clicks on Coupons button
  	 And user should see Coupons page
  	
   Scenario: Add new coupon 
  	 And user Clicks on Add new coupon button
  	 And user enters all details and clicks save button
  	 Then user should see coupon name in coupons list
  	 And user should see modification success message
  	 
   Scenario: Edit coupon
  	 Given user clicks on Edit icon
   	 When user updates Type field dropdown
  	 And user clicks on save button
  	 Then user should see modification success message
  	 
   Scenario: Delete coupon
  	 Given user selects coupon to delete
  	 When user clicks on delete icon
  	 And user click on OK from delete alert
  	 Then user should see modification success message
  
  	    
      
      
      
