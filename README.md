# Trivago-website-automation
Automating the trivage website to find the hotels sorted by rating  by giving the input like location, check-in and check-out date.


ProjectName : Find Hotel Availability
Case Study: Find Hotel Availability

Problem Statement:  
Hotel Availability Automation
1) Available hotel in next week (e.g. 27 July Check in and 28 July Check out) for a specific city. Ex: Mumbai
2) Get the Price of All the Hotels
3) Sort the hotels by rating
4) Check that the first 5 hotels contains the specific city searched for. Ex: Mumbai

Suggested site: https://www.trivago.in/
Detailed Description:
	1.Open the application https://www.trivago.in/ in chrome or fire fox browser.
	2.In search field, enter City “Mumbai” as destination.
	3.Select Check-In Date for the next week (e.g. 27 July)
	4.Select Check-Out Date for the next week (e.g.28 July)
	5.Select Adults 1
	6.Select Rooms 1
	7.Click on Apply.
	8.Click on Search.
	9.Select Sort By “Rating only”
	10.Get the list of Rent of the hotels displayed.
	11.Check that the all the ratings of the hotels is in descending order (e.g. 10.0>9.8>9.6..)
	12.Close the browser

Key Automation Scope:
	1.Multiple browser handling
	2.Assign synchronization technique
	3.Use Calendar or Date-Picker
	4.Navigation to Home page5
	5.Exception Handling
	6.Locating Elements precisely


Note: Through we are sorting by rating only option, we could see highest rating hotels comes in last page.This could be a bug in trivago.We can see this issue manually as well.
      So i attached the screenshot of highest rating in last page.

In Two cases: I used Thread.Sleep();
In First Case: this is sleep being used to handle page loadings. Because implicity,explicity and pageloadTimeout are not working.
In Sceond Case: this sleep is used because when we filter the hotels or when we select the next page we get a loading message,
		Unable to wait using implicit and explicit so i used thread.sleep(); 
	




