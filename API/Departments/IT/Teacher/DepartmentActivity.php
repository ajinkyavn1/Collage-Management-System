<?php

		
        $image = $_POST['image'];
        require_once ('connection.php');
		
		$sql = "INSERT INTO it_notices (image) VALUES (?)";

		$stmt = mysqli_prepare($conn,$sql);
		
		mysqli_stmt_bind_param($stmt,"s",$image);
		mysqli_stmt_execute($stmt);
		
        $check = mysqli_stmt_affected_rows($stmt);
       
		
		if($check == 1){
            echo "Image Uploaded Successfully";
         
		}else{
			echo "Error Uploading Image";
		}
		mysqli_close($conn);

    ?>