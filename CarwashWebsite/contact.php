<?php

$firstname = Filter_input(INPUT_POST, 'fname');
$lastname = Filter_input(INPUT_POST, 'lname');
$phone = Filter_input(INPUT_POST, 'contactNumber');
$email = Filter_input(INPUT_POST, 'email');
$area = Filter_input(INPUT_POST, 'area');
$message = Filter_input(INPUT_POST, 'message');
$valet = Filter_input(INPUT_POST, 'valet');

if(!empty($firstname) || !empty($lastname)|| !empty($area) || !empty($message) || !empty($email) || !empty($phone) || !empty($valet))
{	
		$host = "localhost";
		$dbusername = "root";
		$dbpassword = "";
		$dbname = "carwash_website_visitor";
		
		$conn = new mysqli ($host, $dbusername, $dbpassword, $dbname);		//makes connection to the database, using the provided database information.
		
		if(mysqli_connect_error())
		{
			die('Connect Error ('.mysqli_connect_errno().')'.mysqli_connect_error()); 		// Error message to be shown when connection to the database fails, "die" kills the connection.
		}
		else 	//if connection to the database is successful the php file will write data into the database.
		{ 
			$sql = "INSERT INTO users (FIRSTNAME, SURNAME, CONTACT, EMAIL, AREA, MESSAGE, VALET) values('$firstname', '$lastname', '$phone', '$email', '$area', '$message', '$valet')";		//SQL code that writes data into the database.
			
			if($conn->query($sql))		//when information is added to the databse successfully the messgage below is what the user will see.
			{
                           echo '<script>alert("Submission Succesful!, We will get back to you soon.")</script>';
                           //echo '<script>alert("Added ' .$productname. ' to cart")</script>';
                            header( "Refresh:0; url=index.php", true, 303);
                            ////header('location: Product.php');
                            //header('"Login Successful!");
				
			}
			else		//If information was not added this is what will be shown
			{
				echo "Error: ". $sql . "<br>" . $conn->error;
			}
			$conn->close(); 	//This ends the connection between the database and the website.
		}
}
else 		
{
	echo "One of the fields is empty, Please provide the required information.";
	die();		//kills connection.
}

?>

