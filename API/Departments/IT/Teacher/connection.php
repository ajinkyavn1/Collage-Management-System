<?php

$servername = "localhost";
$username = "root";
$password = "@@@@@@@@";
$database = "goverment polytechnic jalgaon";
$conn = new mysqli($servername, $username, $password, $database);
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
	
}
?>