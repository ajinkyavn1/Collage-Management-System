<?php
require_once ('connection.php');

$result1 = mysqli_query($conn,"SELECT * FROM department_activity where Branch='IT'");
$response = array();
$res=array();

while($row1 = mysqli_fetch_assoc($result1))
{
   $r["photo"]=$row1["photo"];
   $r["name"]=$row1["name"];
   $r["username"]=$row1["username"];
  
   array_push($res,$r);
   

}
echo json_encode($res);

?>