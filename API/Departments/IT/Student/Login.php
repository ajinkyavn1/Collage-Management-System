 <?php
	require_once ('connection.php');

		$username=$_POST['username'];
		$password = $_POST['password'];


	$sql= "select * from  students where username like '".$username."' and  password like '".$password."';";
	$result=mysqli_query($conn,$sql);
	$response = array();
		if(mysqli_num_rows($result)>0)
		{
			$row = mysqli_fetch_assoc($result);



			$index['error'] ="NO";
			$index['message']= "success";
			$index['name']= $row['name'];
			$index['email'] = $row['email'];
			$index['DOB']=$row['DOB'];
			$index['enrollment']=$row['enrollment'];
			$index['rollNo']=$row['rollno'];
			$index['mobail']=$row['mobail'];
			$index['year']=$row['year'];
			$index['Branch']=$row['Branch'];
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