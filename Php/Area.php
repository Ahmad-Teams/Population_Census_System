<?php
class Area {
  // Properties
  private $areaID;
  private $areaName;

  // Methods
  function get_areaID() {
    return $this->stateID;
  }
  function set_areaName($areaName) {
    $this->areaName = $areaName;
  }
  function get_areaName() {
    return $this->areaName;
  }

}
?>