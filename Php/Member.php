<?php
class Member {
  // Properties
  private $MID;
  private $DocName;

  // Methods
  function get_MID() {
    return $this->MID;
  }
  function set_DocName($DocName) {
    $this->DocName = $DocName;
  }
  function get_DocName() {
    return $this->DocName;
  }

}
?>