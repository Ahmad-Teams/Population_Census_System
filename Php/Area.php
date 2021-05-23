<?php
class Area {
  // Properties
  public $areaID;
  public $areaName;

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