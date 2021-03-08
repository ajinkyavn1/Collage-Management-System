<?php
require_once ('connection.php');

$result1 = mysqli_query($conn,"SELECT * FROM itnotice where Branch='E&TC'");
$response = array();
$res=array();

while($row1 = mysqli_fetch_assoc($result1))
{
   $r["photo"]=$row1["photo"];
   $r["name"]=$row1["name"];
  
   array_push($res,$r);
   

}
echo json_encode($res);

?>