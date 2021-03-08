<?php
	require_once ('connection.php');


		$name = $_POST['name'];
		$email = $_POST['email'];
		$username=$_POST['username'];
		$password = $_POST['password'];
		$mobail=$_POST['mobail'];
		$ocupation=$_POST['ocupation'];
		$year_Join = $_POST['Year_of_joining'];
		$DOB=$_POST['DOB'];
		$Branch=$_POST['Branch'];
		//$password = password_hash($password, PASSWORD_DEFAULT);	
		$response = array();

		if($name=="" ||$email==""||$username=="" || $password=="" || $year_Join=="" || $ocupation=="" || $mobail=="" || $DOB==""|| $Branch=="")
		{
			echo "All Fields Are Mandatory";
		}
		if(!preg_match('/^\d{10}$/',$mobail)) // phone number is valid
		{
			echo 'Phone number invalid !';
		}
		if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
				 echo "Invalid email format";
				}
	 


		else{
	$sql= "select * from  teacher where username like '".$username."';";

	$result=mysqli_query($conn,$sql);
	$response;
		if(mysqli_num_rows($result)>0)
		{
        $response= "User already Exit...";
		//echo json_encode($response);
		echo $response;
        mysqli_close($conn);

		}
		else{	


		$sql = "insert into teacher values('','".$username."','".$password."','".$name."','".$email."','".$year_Join ."','".$DOB."','".$mobail."','".$ocupation."','".$Branch."','http:/sssssssss');";
		$result=mysqli_query($conn,$sql);
        $response = "User Register Sucessfully...............";
		//echo json_encode($response);
		echo $response;
        mysqli_close($conn);
	}
	
}
	

?>