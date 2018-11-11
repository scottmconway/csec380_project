<?php
$auth_token = $_SERVER['HTTP_authtoken'];

$user_id = http_get("/isAuthenticated", array("headers"=>$auth_token));

if($user_id == "INVALID SESSION"){
		die("Invalid Session");
	}
	
	if(!isset($_GET['new_name'])){
        die("new_name is not set")
    }

    $conn = new mysqli("database", "root", "skitteradmin", "skitter");
        // Check connection
        if ($conn->connect_error) {
                die("Connection failed: " . $conn->connect_error);
        }

        $stmt = $conn->prepare("UPDATE user SET (display_name) VALUES (?) WHERE user_id=?");
        $stmt->bind_param("si", $_GET['new_name'], $user_id);
        $stmt->execute();
?>	
