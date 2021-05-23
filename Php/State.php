<?php
class State {
  // Properties
  public $stateID;
  public $stateName;

  // Methods
  function get_stateID() {
    return $this->stateID;
  }
  function set_stateName($stateName) {
    $this->stateName = $stateName;
  }
  function get_stateName() {
    return $this->stateName;
  }

}
?>