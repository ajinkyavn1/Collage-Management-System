<?php

    require_once ('connection.php');    
	
	$sql = "select id from it_notices";
	
	$res = mysqli_query($conn,$sql);
	
	
	$result = array();
	
	$url = "http://192.168.43.196/GPJ/departments/IT/teacher/View_Notice.php?id=";
	while($row = mysqli_fetch_array($res)){
		array_push($result,array('url'=>$url.$row['id']));
	}
	
	echo json_encode(array("result"=>$result));
	
	mysqli_close($conn);
?>