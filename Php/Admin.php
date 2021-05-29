<?php
class Area {
  // Properties
  private $AID;
  private $username;
  private $password;

	

	// Methods
  function get_AID() {
    return $this->AID;
  }
  function get_username() {
    return $this->username;
  }
  function set_username($username) {
    $this->username = $username;
  }
  function get_password() {
    return $this->password;
  }
  function set_password($password) {
    $this->password = $password;
  }
  function addOfficer($officer){
	  
  }

}
?>