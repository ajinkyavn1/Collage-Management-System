<?php


		$image = $_POST['image'];
		$name = $_POST['name'];
		$Branch = $_POST['branch'];
		$Username = $_POST['username'];
		require_once ('connection.php');

		$path = "Activitys/$name.png";

		$actualpath = "http://1bdfa4184a5d.ngrok.io/GPJ/Departments/IT/Teacher/Department_activity/$path";

		$sql = "INSERT INTO department_activity (photo,name,username,Branch) VALUES ('$actualpath','$name','$Username','$Branch')";

		if(mysqli_query($conn,$sql)){
			file_put_contents($path,base64_decode($image));
			echo "Successfully Uploaded";
		}

		mysqli_close($conn);

?>