 <?php
	require_once ('connection.php');
		
		$username=$_POST['username'];
		$password = $_POST['password'];
		
	$sql= "select * from teacher where username like '".$username."' and  password like '".$password."';";

	$result=mysqli_query($conn,$sql);
	$response = array();
		if(mysqli_num_rows($result)>0)
		{
			$row = mysqli_fetch_assoc($result);

	
	
			$index['error'] ="NO";
			$index['message']= "success";
			$index['username']=$row['username'];
			$index['name']= $row['name'];
			$index['email'] = $row['email'];
			$index['Year_of_joining']= $row['Year of joining'];
			$index['DOB'] = $row['DOB'];
			$index['Branch']= $row['Branch'];
			$index['Mobail'] = $row['Mobail'];
			//$index['ImageuUrl'] = $row['ImageuUrl'];
			array_push($response,$index);
			
			echo json_encode($response);
	
	
			
        	mysqli_close($conn);

		}
		else{
			$index['error'] ='YES';
			$index['message']='error';
			array_push($response,$index);
			echo json_encode($response);
			mysqli_close($conn);
	}

	
	


?>