<?php

		require_once ('connection.php');
		$image = $_POST['image'];
		$name = $_POST['name'];
		$image1 = $_POST['branch'];


		$path = "uploads/$name.png";

		$actualpath = "http://1bdfa4184a5d.ngrok.io/GPJ/Departments/IT/Teacher/Notice/$path";

		$sql = "INSERT INTO itnotice (photo,name,Branch) VALUES ('$actualpath','$name','$image1')";

		if(mysqli_query($conn,$sql)){
			file_put_contents($path,base64_decode($image));
			echo "Successfully Uploaded";
		}

		mysqli_close($conn);

?>